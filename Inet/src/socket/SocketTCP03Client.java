package socket;//时间：2023/9/9 16:37

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("10.52.80.58"), 8888);

        //客户端发送消息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,Server 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //客户端接收消息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //关闭流
        socket.close();
        inputStream.close();
        bufferedWriter.close();
        outputStream.close();
        bufferedReader.close();
        System.out.println("客户端退出...");
    }
}

//    Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        System.out.println("客户端的socket=" + socket);
//                //向服务端写入数据
//                OutputStream outputStream = socket.getOutputStream();
//                //使用 BufferWriter 把 outputStream 字节流 转换为 OutPutStreamWriter 字符流
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//                bufferedWriter.write("hello,server 字符流");
//                bufferedWriter.newLine();//使用换行符来标记结束， 注意，要求读取方使用readLine()方法接收！！！
//                bufferedWriter.flush();//使用字符流必须，要手动刷新， 如果不手动刷新数据不会写入数据通道
//                //向服务端接收数据
//                InputStream inputStream = socket.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String s = bufferedReader.readLine();
//                System.out.println(s);
//                //关闭io流和socket
//                bufferedWriter.close();
//                bufferedReader.close();
//                socket.close();





























