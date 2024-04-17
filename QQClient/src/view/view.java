package view;//时间：2023/9/17 15:41

import Common.MessageType;
import service.MessageClientService;
import service.UserClientService;
import utilti.Utility;

import javax.swing.text.View;
import java.util.Scanner;

public class view {
    private UserClientService userClientService = new UserClientService();
    private MessageClientService messageClientService = new MessageClientService();
    public static void main(String[] args) {
        new view().View();
    }

    public void View() {
        while (true) {
            System.out.println("*************欢迎登陆网络通讯系统*************");
            System.out.println("              1登录系统");
            System.out.println("              9退出系统");
            Scanner scanner = new Scanner(System.in);
            int s = scanner.nextInt();
//        System.out.println(s);
            switch (s) {
                case 1:
                    System.out.println("请输入你的用户名：");
                    String userId = Utility.readString(50);
                    System.out.println("请输入你的密 码：");
                    String pwd = Utility.readString(50);
                    if (userClientService.Verify(userId,pwd)) {
                        while(true) {
                        System.out.println("======欢迎"+userId+"========");
                        System.out.println("*************网络通讯二级菜单*************");
                        System.out.println("\t\t1显示在线用户列表");
                        System.out.println("\t\t2群发消息");
                        System.out.println("\t\t3私聊消息");
                        System.out.println("\t\t4发送文件");
                        System.out.println("\t\t9退出系统");
                        System.out.println("请输入你的选择：");
                            int i = scanner.nextInt();
                            switch (i) {
                                case 1:
                                    //编写方法来实现 1显示在线用户列表
                                    System.out.println("1显示在线用户列表");
                                    userClientService.onlineMemberList();
                                    break;
                                case 2:
                                    System.out.println("2群发消息");
                                    break;
                                case 3:
                                    //方法实现私聊
                                    System.out.println("请输入想聊天的在线用户：");
                                    String receiver = Utility.readString(10);
                                    System.out.println("请输入想说的话：");
                                    String content = Utility.readString(50);
                                    messageClientService.chatUser(userId, receiver, content);
                                    System.out.println("3私聊消息");
                                    break;
                                case 4:
                                    System.out.println("4发送文件");
                                    break;
                                case 9:
                                    //编写一个方法来实现正常退出
                                    System.out.println("9退出系统");
                                    userClientService.cutConnect();
                                    System.exit(0);
                            }
                        }
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case 9:
                    System.out.println("欢迎下次登录");
                    System.exit(0);
                    break;
            }
        }
    }

}
