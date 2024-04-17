package udp;//时间：2023/9/11 15:09

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        //接收
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        byte[] data = packet.getData();
        int len = packet.getLength();
        String s = new String(data,0, len);
        System.out.println(s);

        //发送
        byte[] bytes = "hello,Client".getBytes();
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.56.1"), 8888);
        socket.send(packet1);

        //关闭流
        socket.close();
    }
}












//
//    //1、创建
//    DatagramSocket socket = new DatagramSocket(9999);
//    //2、接收
//    byte[] buf = new byte[1024];
//    DatagramPacket packet = new DatagramPacket(buf,buf.length);
//        System.out.println("接收A等待接收信息");
//                socket.receive(packet);
//
//                int length = packet.getLength();
//                byte[] data = packet.getData();
//                String s = new String(data,0, length);
//                System.out.println(s);
//
//
//                //3、发送
//                byte[] bytes = "好的，明天见".getBytes();
//                DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.56.1"), 9998);
//                socket.send(packet1);
//
//                //关闭源
//                socket.close();
//                System.out.println("A退出");