const BASE_URL = 'https://moments.weiwangge.com/quarktest/';

export function getAndStoreOpenid() {
  // 调用云函数
  wx.cloud.callFunction({
    name: 'login',
    data: {},
    success: res => {
      console.log('[云函数] [login] user openid: ', res.result.openid);
      wx.setStorageSync("openid", res.result.openid);
      // return res.result.openid;
      // app.globalData.openid = res.result.openid
      // wx.navigateTo({
      //   url: '../userConsole/userConsole',
      // })
    },
    fail: err => {
      console.error('[云函数] [login] 调用失败', err)
      wx.navigateTo({
        url: '../deployFunctions/deployFunctions',
      })
    }
  })
}

export function setUserInfoToPage(page,userInfo){
  page.setData({
    avatarUrl: userInfo.avatarUrl,
    userInfo: userInfo,
    logged: true
  });
}

export function pushUserinfoAndOpenid(userInfo,openId){
  let data = {
    ...userInfo,
    openId
  }
  console.log("ready to push:",data);
}