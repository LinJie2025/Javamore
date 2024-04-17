package HomeWork;//时间：2023/9/11 15:40

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        //创建服务端对象
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端等待连接。。");
        Socket socket = serverSocket.accept();
        //服务端接收信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
//        System.out.println(s);name
        //服务端判断接收的消息并回复
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String answer = "";
        if (s.equals("name")){
            answer = "我是nova";
        } else if (s.equals("hobby")) {
            answer = "编写Java程序";
        }else{
            answer = "你说啥呢";
        }

        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        //关闭流
        socket.close();
        bufferedReader.close();
        inputStream.close();
        bufferedWriter.close();
        outputStream.close();
    }
}
