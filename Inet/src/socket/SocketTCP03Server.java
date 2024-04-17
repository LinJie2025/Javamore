package socket;//时间：2023/9/9 16:36

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端等待连接...");
        Socket socket = serverSocket.accept();

        //服务端接收消息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //服务端发送消息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,Client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //关闭流
        serverSocket.close();
        socket.close();
        inputStream.close();
        bufferedWriter.close();
        outputStream.close();
        bufferedReader.close();
        System.out.println("服务端退出...");
    }
}
//    ServerSocket serverSocket = new ServerSocket(9999);
//        System.out.println("等待连接。。。");
//                Socket socket = serverSocket.accept();
//                System.out.println("连接成功！ 服务端的socket=" + socket);
//                //接收客户端发来的消息
//                InputStream inputStream = socket.getInputStream();
//                //使用 BufferReader 把 intputStream 字节流 转换为 IntPutStreamWriter 字符流
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                //接收方用readLine()方法读取
//                String s = bufferedReader.readLine();
//                System.out.println(s);
//                //向客户端发送消息
//                OutputStream outputStream = socket.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//                bufferedWriter.write("hello,client 字符流");
//                bufferedWriter.newLine();//用换行符代表写入结束
//                bufferedWriter.flush();//使用字符流必须手动刷新，不然数据不会写入数据通道
//                //关闭io流和socket
//                bufferedWriter.close();
//                bufferedReader.close();
//                socket.close();
//                serverSocket.close();