package HomeWork;//时间：2023/9/12 14:09

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Homework02Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端等待连接");
        socket.receive(packet);

        byte[] data = packet.getData();
        int len = packet.getLength();
        String s = new String(data,0,  len);
        System.out.println(s);
        byte[] bytes;
        if (s.equals("四大名著是哪些")){
            bytes = "红楼梦".getBytes();
        }else {
            bytes = "what?".getBytes();
        }
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.56.1"), 8888);
        socket.send(packet1);
        socket.close();
    }
}
