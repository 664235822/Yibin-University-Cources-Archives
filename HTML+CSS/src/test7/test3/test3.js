
	var WINDOW_WIDTH=1024;
    var WINDOW_HEIGHT=768;
    var RADIUS=8;
    var Marginleft=30;
    var Margintop=60;

    var endTime=new Date ();
    endTime.setTime(endTime.getTime()+3600*1000);
    var curShowTimeSeconds=0;

    var balls=[];
    var colors=["#33B5E5","#0099CC","#AA66CC","#9933CC","#99CC00","#669900","#FFBB33","#FF8800","#FF4444","#CC0000"];

window.onload =function () {

	var canvas=document.getElementById("canvas");
	var context=canvas.getContext("2d");

	canvas.width=WINDOW_WIDTH;
	canvas.height=WINDOW_HEIGHT;

	curShowTimeSeconds=getCurrentShowTimeSeconds();

	setInterval(function (){
          
      render(context);
      update();
	},50);

	
}

//获取当前时间
function getCurrentShowTimeSeconds () {
	var curTime= new Date();
	var ret=endTime.getTime()-curTime.getTime();
	ret=Math.round(ret/1000);

	return ret>=0?ret:0;
}

//对时间的更新
function update () {
	var nextShowTimeSeconds=getCurrentShowTimeSeconds();

	 var nextHours=parseInt(nextShowTimeSeconds/3600);
     var nextMinutes=parseInt((nextShowTimeSeconds-nextHours*3600)/60);
     var nextSeconds=nextShowTimeSeconds%60;

     var curHours=parseInt(curShowTimeSeconds/3600);
     var curMinutes=parseInt((curShowTimeSeconds-curHours*3600)/60);
     var curSeconds=curShowTimeSeconds%60;

    //检测时间的变化
     if (curSeconds!=nextSeconds) {
     	if(parseInt(curHours/10)!=parseInt(nextHours/10)){
     		addBalls(Marginleft+0,Margintop,parseInt(curHours/10));
     	}
     	if(parseInt(curHours%10)!=parseInt(nextHours%10)){
     		addBalls(Marginleft+15*(RADIUS+1),Margintop,parseInt(curHours%10));
     	}
     	if(parseInt(curMinutes/10)!=parseInt(nextMinutes/10)){
            addBalls(Marginleft+39*(RADIUS+1),Margintop,parseInt(curMinutes/10));
     	}
     	if(parseInt(curMinutes%10)!=parseInt(nextMinutes%10)){
     		addBalls(Marginleft+54*(RADIUS+1),Margintop,parseInt(curMinutes%10));
     	}
     	if(parseInt(curSeconds/10)!=parseInt(nextSeconds/10)){
     		addBalls(Marginleft+78*(RADIUS+1),Margintop,parseInt(curSeconds/10));
     	}
     	if(parseInt(curSeconds%10)!=parseInt(nextSeconds%10)){
     		addBalls(Marginleft+93*(RADIUS+1),Margintop,parseInt(curSeconds/10));
     	}
    
     	curShowTimeSeconds=nextShowTimeSeconds;
     }
     updateBalls();
}

//使小球位置发生变化，变成动画
function updateBalls () {
	for(var i=0;i<balls.length;i++){
		balls[i].x+=balls[i].vx;
		balls[i].y+=balls[i].vy;
		balls[i].vy+=balls[i].g
		if (balls[i].y>=WINDOW_HEIGHT-RADIUS){
			balls[i].y=WINDOW_HEIGHT-RADIUS;
			balls[i].vy=-balls[i].vy*0.75;
		}
	}

    //性能优化
    var count=0;
    for (var i=0;i<balls.length;i++){
        if(balls[i].x+RADIUS>0&&balls[i].x-RADIUS<WINDOW_WIDTH){
            balls[count++]=balls[i];
        }
     
    }
    while(balls.length>count){
        balls.pop();
     }
}

//选出要变化的小球
function addBalls(x,y,num) {
	for(var i=0;i<digit[num].length;i++)
		for(var j=0;j<digit[num][i].length;j++)
            if(digit[num][i][j]==1){
            	var aBall={
            		x:x+j*2*(RADIUS+1)+RADIUS+1,
            		y:y+i*2*(RADIUS+1)+RADIUS+1,
            		g:1.5+Math.random(),
            		vx:Math.pow(-1,Math.ceil(Math.random()*1000))*4,
            		vy:-5,
            		color:colors[Math.floor(Math.random()*10)]
            	}
            	balls.push(aBall);
            }
}

//使整个动画渲染出来
function render(cxt) {
	
     cxt.clearRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);

     var hours=parseInt(curShowTimeSeconds/3600);
     var minutes=parseInt((curShowTimeSeconds-hours*3600)/60);
     var seconds=curShowTimeSeconds%60;

     renderDigit(Marginleft,Margintop,parseInt(hours/10),cxt);
     renderDigit(Marginleft+15*(RADIUS+1),Margintop,hours%10,cxt);
     renderDigit(Marginleft+30*(RADIUS+1),Margintop,10,cxt);
     renderDigit(Marginleft+39*(RADIUS+1),Margintop,parseInt(minutes/10),cxt);
     renderDigit(Marginleft+54*(RADIUS+1),Margintop,minutes%10,cxt);
     renderDigit(Marginleft+69*(RADIUS+1),Margintop,10,cxt);
     renderDigit(Marginleft+78*(RADIUS+1),Margintop,parseInt(seconds/10),cxt);
     renderDigit(Marginleft+93*(RADIUS+1),Margintop,seconds%10,cxt);

     for(var i=0;i<balls.length;i++){
     	cxt.fillStyle=balls[i].color;

     	cxt.beginPath();
     	cxt.arc(balls[i].x,balls[i].y,RADIUS,0,2*Math.PI);
     	cxt.closePath;

     	cxt.fill();
     }
     
}

//制作单个的小球
function renderDigit(x,y,num,cxt) {
	cxt.fillStyle="red";

	for (var i=0; i<digit[num].length; i++)
	    for(var j=0; j<digit[num][j].length;j++){
              if (digit[num][i][j]==1){

              	cxt.beginPath();
              	cxt.arc(x+j*2*(RADIUS+1)+(RADIUS+1),y+i*2*(RADIUS+1)+(RADIUS+1), RADIUS, 0, 2*Math.PI);
              	cxt.closePath();

              	cxt.fill();
              }
	}
}

