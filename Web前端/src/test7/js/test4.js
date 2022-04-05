//获取此元素
var dom = document.getElementById('clock');
//返回一个用于在画布上绘图的环境
var ctx = dom.getContext('2d');
//得到画布的宽度
var width = ctx.canvas.width;
//得到画布的高度
var height = ctx.canvas.height;
//得到半径
var r = width/2;
//设置比例
var rem = width/200;
//画圆
function drawcircle(){
	ctx.save();
	//设置圆心
	ctx.translate(r,r);
	//设置起始点
	ctx.beginPath();
	//设置线条宽度
	ctx.lineWidth = 10*rem;
	//创建一个圆形
	ctx.arc(0,0,r-ctx.lineWidth/2,2*Math.PI,false);
	//绘制
	ctx.stroke();

	//定义存储时针数组
	var hoursNumbers=[3,4,5,6,7,8,9,10,11,12,1,2];
	ctx.font=16*rem+"px Arial";
	ctx.textAlign="center";
	ctx.textBaseline="middle";
	//遍历数组画出时针
	hoursNumbers.forEach(function(number,i){
		//得到每个时针的弧度
		var rad = 2*Math.PI/12*i;
		//得到每个时针的x坐标
		var x = Math.cos(rad)*(r-30*rem);
		//得到每个时针的x坐标
		var y = Math.sin(rad)*(r-30*rem);
		//将数字绘制
		ctx.fillText(number,x,y);
	});
	//画出时针点
	for(var i=0;i<60;i++){
		//得到每个点的弧度
		var rad = 2*Math.PI/60*i;
		//得到每个点的x坐标
		var x = Math.cos(rad)*(r-18*rem);
		//得到每个点的y坐标
		var y = Math.sin(rad)*(r-18*rem);
		//重置起始点
		ctx.beginPath();
		//判断是否为5的倍数,绘制灰色点
		if(i%5===0){
			ctx.fillStyle = "#ccc";
			ctx.arc(x,y,3*rem,0,2*Math.PI,false);
		}else{
			ctx.fillStyle = "#000";
			ctx.arc(x,y,2*rem,0,2*Math.PI,false);
		}
		//绘制点
		ctx.fill();
	}
}
//画时针
function drawHour(hour,minute){
	ctx.save();
	ctx.beginPath();
	var rad = 2*Math.PI/12*hour;
	var mrad = 2*Math.PI/12/60*minute;
	ctx.rotate(rad+mrad);
	ctx.lineWidth = 6*rem;
	ctx.lineCap="round";
	ctx.moveTo(0*rem,10*rem);
	ctx.lineTo(0*rem,-r/2);
	ctx.stroke();
	ctx.restore();
}
//画分针
function drawMinute(minute){
	ctx.save();
	ctx.beginPath();
	ctx.fillStyle = '#ccc';
	var rad = 2*Math.PI/60*minute;
	ctx.rotate(rad);
	ctx.lineWidth = 3*rem;
	ctx.lineCap="round";
	ctx.moveTo(0*rem,10*rem);
	ctx.lineTo(0*rem,-r+40*rem);
	ctx.stroke();
	ctx.restore();
}
//画秒针
function drawSecond(second){
	ctx.save();
	ctx.beginPath();
	ctx.fillStyle='#ff0000';
	var rad = 2*Math.PI/60*second;
	ctx.rotate(rad);
	ctx.lineWidth = 3*rem;
	ctx.lineCap="round";
	ctx.moveTo(-2*rem,20*rem);
	ctx.lineTo(2*rem,20*rem);
	ctx.lineTo(1,-r+20*rem);
	ctx.lineTo(-1,-r/2);
	ctx.fill();
	ctx.restore();
}
//画圆心点
function drawcircledot(){
	ctx.beginPath();
	ctx.fillStyle='#fff';
	ctx.arc(0,0,3*rem,2*Math.PI,false);
	ctx.fill();
	ctx.restore();
}
//执行方法
function draw(){
	ctx.clearRect(0,0,width,height);
	drawcircle();
	var now = new Date();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	drawHour(hour,minute);
	drawMinute(minute);
	drawSecond(second);
	drawcircledot();
	ctx.restore();
}
draw();
setInterval(draw,1000);