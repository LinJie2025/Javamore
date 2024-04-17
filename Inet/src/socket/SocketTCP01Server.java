package socket;//时间：2023/9/9 15:52

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        /*思路
        1.在本机的9999端口监听，等待连接
        2.当没有客户端连接9999端口时，程序会阻塞，等待连接
          如果有客户连接，则会返回Socket对象，程序继续
        * */
        //1.等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //等待连接
        System.out.println("等待连接。。");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功！ 服务端的socket = " + socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int redlen = 0;
        while((redlen = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes ,0, redlen));
        }
        socket.close();
    }
}
