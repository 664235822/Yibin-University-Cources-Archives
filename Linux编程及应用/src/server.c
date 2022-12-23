#include <stdio.h>
#include <pthread.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <signal.h>

int sockfd;
char* IP = "10.0.24.11";
short PORT = 2000;
typedef struct sockaddr SA;
struct client
{
char name[20];
int fds;
};
struct client c[100] = {0};
int size = 0;

void init()
{
printf("聊天室服务器开始启动..\n");
sockfd = socket(AF_INET,SOCK_STREAM,0);
if(sockfd == -1)
{
perror("创建socket失败");
printf("服务器启动失败\n");
exit(-1);
}

struct sockaddr_in addr;
addr.sin_family = AF_INET;
addr.sin_port = htons(PORT);
addr.sin_addr.s_addr = inet_addr(IP);
if(bind(sockfd,(SA*)&addr,sizeof(addr))==-1)
{
perror("绑定失败");
printf("服务器启动失败\n");
exit(-1);
}
printf("成功绑定\n");

if(listen(sockfd,10)==-1)
{
perror("设置监听失败");
printf("服务器启动失败\n");
exit(-1);
}
printf("设置监听成功\n");
printf("初始化服务器成功\n");

}

void sendMsgToAll(char* msg)
{
int i = 0;
for(;i<size;i++)
{
printf("sendto%d\n",c[i].fds);
send(c[i].fds,msg,strlen(msg),0);
}
}
void* service_thread(void* p)
{
int fd = *(int*)p;
printf("pthread=%d\n",fd);

c[size].fds = fd;
char name[20] = {0};
if(recv(fd,name,sizeof(name),0)>0)
{
strcpy(c[size].name,name);
}
size++;
char tishi[100] = {0};

sprintf(tishi,"热烈欢迎 %s 登录聊天室..",name);

sendMsgToAll(tishi);
while(1)
{
char buf[100] = {0};
if(recv(fd,buf,sizeof(buf),0)==0)
{
printf("fd=%dquit\n",fd);
int i;
char name[20] = {0};
for(i=0;i<size;i++)
{
if(c[i].fds == fd)
{
strcpy(name,c[i].name);
c[i].fds = c[size-1].fds;
strcpy(c[i].name,c[size-1].name);
}
}
size--;
printf("quit->fd=%dquit\n",fd);
char msg[100] = {0};
sprintf(msg,"欢送 %s 离开聊天室,再见!",name);
sendMsgToAll(msg);
close(fd);
return;
}
sendMsgToAll(buf);
}
}
void service()
{
printf("服务器开始服务\n");
while(1)
{
struct sockaddr_in fromaddr;
socklen_t len = sizeof(fromaddr);
int fd = accept(sockfd,(SA*)&fromaddr,&len);
if(fd == -1)
{
printf("客户端链接出错\n");
continue;
}
printf("fd=%d\n",fd);

pthread_t pid;
pthread_create(&pid,0,service_thread,&fd);
}
}
void sig_close()
{
close(sockfd);
printf("服务器已经关闭\n");
exit(0);
}
int main()
{
signal(SIGINT,sig_close);
init();
service();
return 0;
}
