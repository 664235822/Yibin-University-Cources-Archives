// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    msgFile:''
  },
  // 事件处理函数
  onLoad() {
    
  },
  
  getFile:function(e){
    var rootPath='data'
    rootPath = wx.env.USER_DATA_PATH
    const fs = wx.getFileSystemManager()
    var that = this
    fs.readFile({
      filePath: `${wx.env.USER_DATA_PATH}/hello.txt`,
      encoding:'utf-8',
      position:0,
      success:function(e){
        console.log("加载文件成功")
        that.setData({
          msgFile:e.data
        })
      }
    })
  },
  saveFile:function(e){
    var rootPath='data'
    rootPath = wx.env.USER_DATA_PATH
    const fs = wx.getFileSystemManager()
    var that = this
    fs.writeFile({
      filePath: `${wx.env.USER_DATA_PATH}/hello.txt`,
      data:that.data.msgFile,
      encoding:'utf-8',
      position:0,
      success:function(e){
        console.log("保存文件成功")
      }
    })
  },
  changemsg:function(e){
    var that = this
    that.setData({
      msgFile:e.detail.value
    })
  }
})
