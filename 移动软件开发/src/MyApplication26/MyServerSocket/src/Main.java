import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(30000);
        while (true){
            Socket socket = server.accept();
            //客户端连接上服务器了，服务器获取输出流，将一定的数据写入输出流中
            OutputStream os = socket.getOutputStream();
            os.write("恭喜，连接上了".getBytes());
            System.out.println("【MyServerSocket，main】执行了");
            os.close();
            socket.close();
        }
    }
}