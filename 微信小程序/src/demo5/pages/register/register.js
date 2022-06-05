// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    
  },

  username:"",
  password:"",
  u:function(e){
    this.username=e.detail.value;
  },
  p:function(e){
    this.password=e.detail.value;
  },
  c:function(e){
    if(this.username=="" || this.password==""){
      wx.showToast({
        title: "请输入账号和密码",
        icon:"error",
        duration:2000
      })
    }
    wx.request({
      url: 'http://localhost:8080/register',
      header: {'content-type': 'application/json'},
      data:{"username":this.username,"password":this.password},
      success(res){
        console.log(res.data);
        wx.showToast({
          title: res.data,
          icon:"success",
          duration:2000
        })
      }
    })
  }
})