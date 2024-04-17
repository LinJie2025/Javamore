package service;//时间：2023/10/18 0:08

import Common.Message;
import Common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageClientService {
    public void chatUser(String sender, String receiver, String content) {
        Message message = new Message();
        //设置发送者
        message.setSender(sender);
        //设置接收者
        message.setReceiver(receiver);
        //设置 message 对象类型
        message.setMesType(MessageType.MESSAGE_COM_MES);
        //键盘输入私聊内容
        message.setContent(content);
        //拿到发送者的socket对象
        ClientConnectServerThread clientConnectServerThread = ManageClientConnectService.clientConnectServerThread(sender);
        Socket socket = clientConnectServerThread.getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
