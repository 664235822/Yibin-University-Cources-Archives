#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/sendfile.h>

int main(int argc, char* argv[]) {
    int fd, n = 10;
    if (argc == 2) {
        fd = open(argv[1], O_RDONLY);
    }
    else if(argc == 3) {
        fd = open(argv[2], O_RDONLY);
        n = atoi(argv[1] + 1);
    }

    off_t size = lseek(fd, 0, SEEK_END);
    off_t offset = 0;
    char ch;
    while (lseek(fd, -1, SEEK_CUR) >= 0 && n > 0) {
        read(fd, &ch, 1);
        offset = lseek(fd, -1, SEEK_CUR);
        if (ch == '\n') 
            --n;
    }
    if (n == 0) ++offset;
    sendfile(STDOUT_FILENO, fd, &offset, size - offset);

    close(fd);
    return 0;
}

