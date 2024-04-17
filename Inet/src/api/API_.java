package api;//时间：2023/9/9 15:21

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取主机名和IP地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-GUMMRRR/10.52.80.42
        //2、通过主机名获取IP地址
        InetAddress host1 = InetAddress.getByName("DESKTOP-GUMMRRR");
        System.out.println("host1=" + host1);
        //3、通过域名返回
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2=" + host2);
        String address = host2.getHostAddress();
        System.out.println("百度的IP地址=" + address);
    }
}
