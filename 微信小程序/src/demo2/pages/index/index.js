Page({
  data: {
    checkCoupon: {},
    result: ''
  },
  num1: 0,
  num2: 0, 
  onLoad: function (options) {
  },
  onReady: function () {
  },
  onShow: function () {
  },
  n1: function (e) {
    this.num1 = Number(e.detail.value)
    console.log('数1为' + this.num1)
  },
  n2: function (e) {
    this.num2 = Number(e.detail.value)
    console.log('数2为' + this.num2)
  },
  bj: function (e) {
    var str = '相等'
    if (this.num1 > this.num2) {
      str = '数1大'
    } else if (this.num1 < this.num2) {
      str = '数2大'
    }
    this.setData({
      result: str
    })
  }
})