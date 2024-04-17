package udp;//时间：2023/9/11 15:10

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSenterB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        //发送
        byte[] bytes = "hello,Server".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.56.1"), 9999);
        socket.send(packet);

        //接收
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);

        byte[] data = packet1.getData();
        int len = packet1.getLength();
        String s = new String(data,0, len);
        System.out.println(s);

        //关闭流
        socket.close();
    }
}























//    //1、创建
//    DatagramSocket socket = new DatagramSocket(9998);
//    //2、发送信息
//    byte[] buf = "hello,去吃火锅".getBytes();
//    DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.56.1"), 9999);
//        socket.send(packet);
//
//                //3、接收信息
//
//                byte[] data = new byte[1024];
//                DatagramPacket packet1 = new DatagramPacket(data, data.length);
//                System.out.println("B等待信息的接收");
//                socket.receive(packet1);
//                byte[] buf1 = packet1.getData();
//                int length = packet1.getLength();
//                String s = new String(buf1, 0, length);
//                System.out.println(s);
//                //关闭源
//                socket.close();
//                System.out.println("B退出");