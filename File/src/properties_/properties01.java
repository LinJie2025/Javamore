package properties_;//时间：2023/8/11 13:55

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class properties01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("File\\src\\mysql.properties"));
//        properties.list(System.out);
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名是" + user);
        System.out.println("密码是" + pwd);
    }
}
