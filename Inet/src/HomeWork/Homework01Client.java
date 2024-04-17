package HomeWork;//时间：2023/9/11 15:45

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        //客户端发送消息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//        bufferedWriter.write("name");
//        bufferedWriter.write("hobby");
        bufferedWriter.write("nme");
        bufferedWriter.newLine();//结束标记
        bufferedWriter.flush();
        //客户端接收消息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭流
        socket.close();
        bufferedWriter.close();
        outputStream.close();
        inputStream.close();
        bufferedReader.close();
    }
}
