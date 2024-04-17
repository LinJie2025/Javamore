package socket;//时间：2023/9/9 16:14

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("服务端等待连接...");

        //接收客户端的的数据
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int redlen = 0;
        while((redlen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, redlen));
        }

        //回复客户端消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,Client".getBytes());
        socket.shutdownOutput();

        //关闭流
        socket.close();
        serverSocket.close();
        inputStream.close();
        outputStream.close();

        System.out.println("服务端退出");
    }
}
