package properties_;//时间：2023/8/11 14:03

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //创建
        //如果没有key就是创建，有key就是修改
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","123789");
        properties.store(new FileOutputStream("File\\src\\mysql2.properties"),"数据库2的配置文件");
        System.out.println("保存成功");
    }
}
