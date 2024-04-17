package HomeWork;//时间：2023/9/12 14:12

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Homework02Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] bytes = "四大名著是哪些".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.56.1"),9999);
        socket.send(packet);

        byte[] data = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data, data.length);
        socket.receive(packet1);
        byte[] buf = packet1.getData();
        int len = packet1.getLength();
        String s = new String(buf, 0, len);
        System.out.println(s);
        socket.close();
    }
}
