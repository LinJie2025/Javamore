package socket;//时间：2023/9/9 16:15

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //客户端发送消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,Server".getBytes());
        socket.shutdownOutput();

        //客户端接收消息
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int redlen = 0;
        while((redlen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, redlen));
        }

        //关闭流
        socket.close();
        outputStream.close();
        inputStream.close();
    }
}
