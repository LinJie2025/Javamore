package Service;//时间：2023/10/15 18:38

import java.util.HashMap;
import java.util.Iterator;

public class ManageServerConnectClient {
    private static HashMap<String,ServerConnectClientThread> hm= new HashMap<>();

    //以UserId为索引将 serverConnectClientThread 添加到HashMap集合中
    public static void addServerConnectClientThread(String UserId, ServerConnectClientThread serverConnectClientThread){
        hm.put(UserId,serverConnectClientThread);
    }


    public static ServerConnectClientThread serverConnectClientThread(String UserId){
        return hm.get(UserId);
    }

    public static void rmServerConnectClientThread(String UserId){
        hm.remove(UserId);
    }

    //编写一个方法，返回在线用户列表
    public static String getOnlineList(){
        //遍历集合 ， 遍历 hashmap 的 key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUsers = "";
        while (iterator.hasNext()){
            onlineUsers += iterator.next().toString() + " ";
        }
        return onlineUsers;
    }
}
