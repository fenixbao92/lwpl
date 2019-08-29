const BASE_URL = 'https://lwpl.fenixbao92.com/';
const BASE_URL_OVERRIDE = {
};

//创建牌局
export function createPlay(playInfo){
  let data = {
    ...playInfo,
    openId:wx.getStorageSync("openid")
  }
  console.log("[createPlay]:", data);
  request('play/create', data, 'GET', {});
}

//更新用户信息
export function pushUserinfoAndOpenid(userInfo,openId){
  let data = {
    ...userInfo,
    openId
  }
  console.log("[pushUserinfoAndOpenid]",data);
  request('user/push',data,'GET',{});
}

export function setUserInfoToPage(page, userInfo) {
  page.setData({
    avatarUrl: userInfo.avatarUrl,
    userInfo: userInfo,
    logged: true
  });
}

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

//HTTP
function validate200(res, options) {
  console.log("validate200",res);
  // if (res.statusCode != '200') {
  //   console.error(res);
  //   !options.silent && wx.showToast({ title: `网络错误：${res.statusInfo || res.message}`, icon: 'none' })
  //   throw 'invalid statusCode ' + res.statusCode;
  // }
  // console.log('validate200 OK');
  return res;
}

function validateLoginStatus(data, options) {
  console.log('validateLoginStatus', data ,options);
  if (options.skipValidateLoginStatus) {
    return data;
  }
  if (data.code === 304) {
    wx.reLaunch({ url: '/pages/guide/guide', })
    throw "[Warning] Need infomation input";
  }
  if (data.code === 404) {
    wx.reLaunch({ url: '/pages/login/login', })
    throw "[Warning] Need login";
  }
  return data;
}

const requestPromiseMap = {};

export function request(path, data, method, options = {}) {
  const requestPromiseKey = method + ':' + path + ':' + JSON.stringify(data);
  let requestPromise = requestPromiseMap[requestPromiseKey];
  if (requestPromiseMap[requestPromiseKey]) {
    return requestPromise;
  }

  const header = ['POST', 'PUT'].indexOf(method) >= 0 ? {
    'Content-Type': 'application/json',
  } : {};
  console.debug('HTTP request', path, data, method, options);
  !options.silent && wx.showLoading({});
  const baseUrl = BASE_URL_OVERRIDE[path] || BASE_URL;
  requestPromise = new Promise((resolve, reject) => {
    wx.request({
      url: baseUrl + path,
      data: data,
      method,
      header,
      success: resolve,
      fail: reject,
    })
  }).then(res => {
    !options.silent && wx.hideLoading();
    return res;
  }).then(res => {
    console.debug('HTTP response for', path, data, method, options, res);
    return res;
  })
    .then(res => validate200(res, options))
    .then(res => res.data)
    .then(res => validateLoginStatus(res, options))
    .catch(e => {
      wx.hideLoading();
      throw e;
    })
  // .then(res => res.data || res)
  // .then(data => validate200(data, options));

  function removeRequestPromise(res) {
    delete requestPromiseMap[requestPromiseKey];
    return res;
  }
  requestPromiseMap[requestPromiseKey] = requestPromise.then(removeRequestPromise).catch(removeRequestPromise);
  return requestPromise;
}