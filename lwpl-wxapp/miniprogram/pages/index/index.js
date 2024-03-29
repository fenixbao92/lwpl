const app = getApp()
import { getAndStoreOpenid, pushUserinfoAndOpenid,setUserInfoToPage } from '../../data.js';
//index.js

Page({
  data: {
    avatarUrl: './user-unlogin.png',
    userInfo: {},
    logged: false,
    takeSession: false,
    requestResult: ''
  },

  onLoad: function() {
    if (!wx.cloud) {
      wx.redirectTo({
        url: '../chooseLib/chooseLib',
      })
      return
    }

    getAndStoreOpenid();
    
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              wx.setStorageSync("userInfo", res.userInfo);
              pushUserinfoAndOpenid(res.userInfo, wx.getStorageSync("openid"));
              setUserInfoToPage(this,res.userInfo);
            }
          })
        }
      }
    })
  },

  mylogin: function(e){
    if (!this.logged && e.detail.userInfo) {
      wx.setStorageSync("userInfo", e.detail.userInfo);
      pushUserinfoAndOpenid(e.detail.userInfo, wx.getStorageSync("openid"));
      setUserInfoToPage(this, e.detail.userInfo);
    }
  },

  createPlay: function(){
    // const url = `/pages/post/post?id=${this.data.id}`;
    const url = `/pages/createPlay/createPlay`;
    wx.navigateTo({
      url,
    });
  },

  joinPlay:function(){
    // const url = `/pages/post/post?id=${this.data.id}`;
    const url = `/pages/joinPlay/joinPlay`;
    wx.navigateTo({
      url,
    });
  },

  // 上传图片
  doUpload: function () {
    // 选择图片
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {

        wx.showLoading({
          title: '上传中',
        })

        const filePath = res.tempFilePaths[0]
        
        // 上传图片
        const cloudPath = 'my-image' + filePath.match(/\.[^.]+?$/)[0]
        wx.cloud.uploadFile({
          cloudPath,
          filePath,
          success: res => {
            console.log('[上传文件] 成功：', res)

            app.globalData.fileID = res.fileID
            app.globalData.cloudPath = cloudPath
            app.globalData.imagePath = filePath
            
            wx.navigateTo({
              url: '../storageConsole/storageConsole'
            })
          },
          fail: e => {
            console.error('[上传文件] 失败：', e)
            wx.showToast({
              icon: 'none',
              title: '上传失败',
            })
          },
          complete: () => {
            wx.hideLoading()
          }
        })

      },
      fail: e => {
        console.error(e)
      }
    })
  },

})
