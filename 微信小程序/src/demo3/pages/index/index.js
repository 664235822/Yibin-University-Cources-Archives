Page({
  data: {
    checkCoupon: {},
    result: ''
  },
  name:"",
  sex:"",
  age:"",
  grade:"",
  favorate:"",
  onLoad: function (options) {
  },
  onReady: function () {
  },
  onShow: function () {
  },
  n1: function (e) {
    this.name = e.detail.value
  },
  n2: function (e) {
    this.sex = e.detail.value
  },
  n3: function (e) {
    this.age = e.detail.value
  },
  n4: function (e) {
    this.grade = e.detail.value
  },
  n5: function (e) {
    this.favorate = e.detail.value
  },
  bj: function (e) {
    console.log("姓名："+this.name);
    console.log("性别："+this.sex);
    console.log("年龄："+this.age);
    console.log("学历："+this.grade);
    console.log("特长："+this.favorate);
  }
})