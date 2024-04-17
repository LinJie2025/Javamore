package Service;//时间：2023/10/15 18:23

import Common.Message;
import Common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnectClientThread extends Thread{
    private Socket socket;

    private String UserId;//连接到服务器的用户Id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        UserId = userId;
    }

    public Socket getSocket(){
        return socket;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("服务端循环等待接受客户端发来的User对象");
            try {
                //创建对象输出流， 向客户端传输 message 对象
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();//等待客户端发来的Message对象

                //判断客户端传来的 message 对象类型
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_MEMBER)){
                    //哪一个用户需要拉去在线用户列表
                    System.out.println("用户：" + message.getSender() + "要在线用户列表");

                    //从线程集合管理中拉去在线用户
                    String onlineList = ManageServerConnectClient.getOnlineList();

                    //向客户端传输 message 对象
                    Message message1 = new Message();
                    //向客户端发送 message 类型
                    message1.setMesType(MessageType.MESSAGE_RETURN_ONLINE_MEMBER);
                    //设置 message1 对象的内容
                    message1.setContent(onlineList);
                    //设置客户端接收者
                    message1.setReceiver(message.getSender());
                    //创建输出流 向客户端发送 message 对象
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                }
                //客户端正常下线
                else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    //哪一个用户需要退出
                    System.out.println("用户：" + message.getSender() + "要下线");
                    ManageServerConnectClient.rmServerConnectClientThread(message.getSender());
                    socket.close();
                    System.out.println("用户：" + message.getSender() + "下线成功！");
                    break;
                }
                else if (message.getMesType().equals(MessageType.MESSAGE_COM_MES)){
                    System.out.println("用户：" + message.getSender() + "向用户：" + message.getReceiver() + "发送消息");
                    //拿到接收信息用户的socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            ManageServerConnectClient.serverConnectClientThread(message.getReceiver());
                    Socket socket1 = serverConnectClientThread.getSocket();
                    ObjectOutputStream oos
                            = new ObjectOutputStream(socket1.getOutputStream());
                    oos.writeObject(message);
                }else{
                    System.out.println("其他类型信息，暂时不做处理...");
                }
                //
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
