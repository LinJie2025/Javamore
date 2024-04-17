package service;//时间：2023/9/17 16:20

import Common.User;

import java.util.HashMap;

public class ManageClientConnectService {
    //把多个线程放入HashMap中， key就是用户id， value就是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();
    public static void addClientConnectServerThread(String UserId, ClientConnectServerThread clientConnectServerThread){
        hm.put(UserId,clientConnectServerThread);
    }
    public static ClientConnectServerThread clientConnectServerThread(String UserId){
        return hm.get(UserId);
    }
}
