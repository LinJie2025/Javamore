package Service;//时间：2023/10/15 18:12

import Common.Message;
import Common.MessageType;
import Common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import static Service.ManageServerConnectClient.addServerConnectClientThread;

//服务端接受发送客户端的消息
public class ServerService {
    private ServerSocket ss = null;

    private static HashMap<String,User> hm = new HashMap<>();
    static {
        hm.put("100",new User("100","123456"));
        hm.put("200",new User("200","123456"));
        hm.put("300",new User("300","123456"));
        hm.put("至尊宝",new User("至尊宝","123456"));
        hm.put("紫霞仙子",new User("紫霞仙子","123456"));
    }
    public boolean VerifyLogin(String userId, String passwd){
        User user = hm.get(userId);
        if (user == null){//说明userId不存在
            return false;
        }
        if (!user.getPasswd().equals(passwd)){
            return false;
        }
        return true;
    }
    public ServerService() {
        try {
            System.out.println("服务端在端口9999监听...");
            ss = new ServerSocket(9999);
            while(true){
                Socket socket = ss.accept();
                //创建对象输入流，接受客户端发来的User对象
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                User u = (User) ois.readObject();

                //创建服务端对象输出流，向客户端传输Message对象
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();

                if ( VerifyLogin(u.getUserId(),u.getPasswd()) ){//登录判定
                    System.out.println("UserId="+u.getUserId()+"pwd="+u.getPasswd()+"登陆成功！");
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);

                    //创建一个线程来与客户端保持通信
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket,u.getUserId());
                    serverConnectClientThread.start();

                    //将线程加入集合中进行管理
                    addServerConnectClientThread(u.getUserId(),serverConnectClientThread);
                }else{
                    //登陆失败
                    System.out.println("UserId="+u.getUserId()+"pwd="+u.getPasswd()+"登陆失败！");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务端退出while循环 则关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}