package service;//时间：2023/9/17 16:20

import Common.Message;
import Common.MessageType;
import Common.User;
import utilti.Utility;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {
        private  User u = new User();
        private Socket socket;
        //验证登录方法
        public boolean Verify(String userId, String pwd){
            boolean b = false;
            u.setUserId(userId);
            u.setPasswd(pwd);
                try {
                        //创建socket对象 使用 ObjectOutputStream 来传输User对象
                        socket = new Socket(InetAddress.getByName("10.52.80.58"), 9999);
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(u);

                        //接收服务端发来的Message消息对象
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        Message message = (Message) ois.readObject();
                        if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                            //创建一个线程 ClientConnectServerThread 和向服务器获取Message对象
                            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                            clientConnectServerThread.start();
                            //为了方便管理 将线程放入到Hash Map集合中管理
                            ManageClientConnectService.addClientConnectServerThread(userId,clientConnectServerThread);
                            b = true;
                        }else {
                            //如果登录失败就切断于服务器的连接
                            System.out.println("id="+u.getUserId()+"pwd="+u.getPasswd()+"登陆失败");
                            socket.close();
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return b;
        }
        //拉取在线用户方法
        public void onlineMemberList(){
            //发送 Message 对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_GET_ONLINE_MEMBER);
            message.setSender(u.getUserId());

            //从线程集合中 拿到当前 UserId 对应的线程
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectService.clientConnectServerThread(u.getUserId());
            Socket socket = clientConnectServerThread.getSocket();
            try {
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //下线方法
        public void cutConnect(){
            //发送 message 对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
            message.setSender(u.getUserId());

            //从线程集合中 拿到当前 UserId 对应的线程
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectService.clientConnectServerThread(u.getUserId());
            Socket socket = clientConnectServerThread.getSocket();
            try {
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //私聊方法


        }

