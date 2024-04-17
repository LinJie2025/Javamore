package service;//时间：2023/9/17 16:19

import Common.Message;
import Common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//线程监听
public class ClientConnectServerThread extends Thread {
    private Socket socket;

    //构造器接收 Socket 对象
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("客户端线程，等待服务端发来的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();//如果服务器没有发送消息对象 线程就会阻塞在此
                //判断服务端发来的 Message 对象类型
                if (message.getMesType().equals(MessageType.MESSAGE_RETURN_ONLINE_MEMBER)){
                    //取出在线列表信息，并显示
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n" + "====在线用户列表====");
                    for (int i = 0; i < onlineUsers.length; i++){
                        System.out.println("用户：" + onlineUsers[i]);
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_COM_MES)){
                    System.out.println("\n" + "用户+" + message.getSender() + "对" + message.getReceiver() +"说" + message.getContent());
                    ClientConnectServerThread clientConnectServerThread = ManageClientConnectService.clientConnectServerThread(message.getReceiver());
                    Socket socket1 = clientConnectServerThread.getSocket();
                    ObjectOutputStream oos =
                            new ObjectOutputStream(socket1.getOutputStream());
                    oos.writeObject(message);
                }
                else{
                    System.out.println("是其他类型的message，暂时不处理...");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //为了更方便得到socket
    public Socket getSocket(){
        return socket;
    }
}
