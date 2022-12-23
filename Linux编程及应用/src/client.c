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
char* IP = "120.53.241.114";
short PORT = 2000;
typedef struct sockaddr SA;
char name[20];

void init()
{
printf("聊天室客户端开始启动\n");
sockfd = socket(AF_INET,SOCK_STREAM,0);
struct sockaddr_in addr;
addr.sin_family = AF_INET;
addr.sin_port = htons(PORT);
addr.sin_addr.s_addr = inet_addr(IP);
if(connect(sockfd,(SA*)&addr,sizeof(addr))==-1)
{
perror("无法连接到服务器");
printf("客户端启动失败\n");
exit(-1);
}
printf("客户端启动成功\n");
}
void* recv_thread(void* p)
{
while(1)
{
char buf[100] = {0};
if(recv(sockfd,buf,sizeof(buf),0)<=0)
{
return NULL;
}
printf("%s\n",buf);
}
}
void start()
{
pthread_t pid;
pthread_create(&pid,0,recv_thread,0);
while(1)
{
char buf[100] = {};
scanf(" %s",buf);
send(sockfd,buf,strlen(buf),0);
}
}
void sig_close()
{
close(sockfd);
exit(0);
}
int main()
{
signal(SIGINT,sig_close);
printf("请输入您的昵称:");
scanf("%s",name);
init();
send(sockfd,name,strlen(name),0);
start();
return 0;
}
