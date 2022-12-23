#include <stdio.h>
#include <dirent.h>
#include <string.h>
#include <sys/stat.h>
#include <unistd.h>
#include <sys/types.h>
#include <pwd.h>
#include <grp.h>
#include <time.h>
#include <stdlib.h>

int ls(char *str);
int ls_long(char *str, char *argv);
char getFileType(int st_mode);
char* getPower(int st_mode);
char* getUsername(int uid);
char* getGroupname(int gid);

int main(int argc, char *argv[]){
        if (argc == 1){
                // only ls
                int status;
                status = ls(".");
                if (status == -1)
                        printf("Error: file can't open\n");
                return 0;
        }

        if (argc == 2){
                // current dir & have parameter 
                if (argv[1][0] == '-'){
                        int status;
                        status = ls_long(".", argv[1]);
                        if (status == -1)
                                printf("Error: file can't open\n");
                        if (status == 0){
                                printf("Error: input parameter error\n");
                        }
                }else{// appoint dir
                        printf("apponit dir\n");
                        int status;
                        status = ls(argv[1]);
                        if (status == -1){
                                printf("Error: file can't open\n");
                        }
                }
                return 0;
        }

        // have parameter & appoint dir
        if (argc >= 3){
                int status;
                status = ls_long(argv[1], argv[2]);
                if (status == -1)
                        printf("Error: file can't open\n");
                if (status == 0)
                        printf("Error: input parameter error\n");
                return 0;
        }
        return 0;
}

int ls(char *str){
        DIR *dirp;
        struct dirent *dp;
        dirp = opendir(str);
        //int i = 0;

        if (readdir(dirp) == NULL){
                return -1;
        }

        while ((dp = readdir(dirp)) != NULL){
                printf("%s\n", dp -> d_name);
                /* ++i; if(i % 6 == 0) printf("\n");*/
        }
        //printf("\n");
        closedir(dirp);
        return 1;
}

int ls_long(char *str, char *argv){
        DIR *dirp;
        struct dirent *dp;
        dirp = opendir(str);

        if (readdir(dirp) == NULL){
                return -1;
        }

        int len;        
        len = strlen(argv);
        int i;
        int flag = 0;
        for(i = 1; i < len; i++){
                if (argv[i] == 'l')
                        flag = 1;
        }

        if (flag == 0)
                return 0;
        chdir(str);
        while ((dp = readdir(dirp)) != NULL){
                struct stat buf;
                int st;
                st = stat(dp -> d_name, &buf);
                if (st == -1)
                        return -1;
                char type;
                type = getFileType(buf.st_mode);
                char power[9];
                int j;
                char* p = getPower(buf.st_mode);
                for (j = 0; j < 9; j++){
                        power[j] = *(p + j);
                }
                char* username = getUsername(buf.st_uid);
                char* groupname = getGroupname(buf.st_gid);

                // get time
                struct tm* t;
                t = localtime(&buf.st_mtime);

                printf("%c%s\t%d\t%s\t%s\t%d\t%02d月 %02d %02d:%02d\t%s\n",type, power, buf.st_nlink, username, groupname, buf.st_size, t -> tm_mon + 1, t -> tm_mday, t -> tm_hour, t -> tm_min, dp -> d_name);
        }
        closedir(dirp);
        return 1;
}

char getFileType(int st_mode){
        if ((st_mode & S_IFREG) == S_IFREG){// Ordinary file
                return '-';
        }else if ((st_mode & S_IFDIR) == S_IFDIR){// directory
                return 'd';
        }
        else if ((st_mode & S_IFLNK) == S_IFLNK){// symbolic link
                return 'l';
        }else if ((st_mode & S_IFSOCK) == S_IFSOCK){// socket
                return 's';
        }else if ((st_mode & S_IFBLK) == S_IFBLK){// block device
                return 'b';
        }else {// character device
                return 'c';
        }
}

char* getPower(int st_mode){
        char *power = (char*)malloc(10);
        if ((st_mode & S_IRUSR) == S_IRUSR){// File owner
                power[0] = 'r';
        }else{
                power[0] = '-';
        }

        if ((st_mode & S_IWUSR) == S_IWUSR){
                power[1] = 'w';
        }else{
                power[1] = '-';
        }

        if ((st_mode & S_IXUSR) == S_IXUSR){
                power[2] = 'x';
        }else{
                power[2] = '-';
        }

        if ((st_mode & S_IRGRP) == S_IRGRP){// user group
                power[3] = 'r';
        }else{
                power[3] = '-';
        }

        if ((st_mode & S_IWGRP) == S_IWGRP){
                power[4] = 'w';
        }else{
                power[4] = '-';
        }

        if ((st_mode & S_IXGRP) == S_IXGRP){
                power[5] = 'x';
        }else{
                power[5] = '-';
        }

        if ((st_mode & S_IROTH) == S_IROTH){// other user
                power[6] = 'r';
        }else{
                power[6] = '-';
        }

        if ((st_mode & S_IWOTH) == S_IWOTH){
                power[7] = 'w';
        }else{
                power[7] = '-';
        }

        if((st_mode & S_IXOTH) == S_IXOTH){
                power[8] = 'x';
        }else{
                power[8] = '-';
        }
        power[9] = '\0';
        return power;
}

char* getUsername(int uid){
        struct passwd *my_info;
        my_info = getpwuid(uid);
        return (my_info -> pw_name);
}

char* getGroupname(int gid){
        struct group *group_info;
        group_info = getgrgid(gid);
        return (group_info -> gr_name);
}

