package socket;//时间：2023/9/9 15:57

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        /*
        * 思路
        * 1、连接服务端（IP，端口号）
        * 2、连接上后生成Socket，通过socket.getOutputStream()写入数据到数据通道
        * */
        //1连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端的socket=" + socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        outputStream.close();
        socket.close();
    }
}
