package jdbc;//时间：2024/1/21 18:00

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class jdbc01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String url = "jdbc:mysql://localhost:3306/test";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "3467");
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver)aClass.newInstance();
//        DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url, properties);
        String sql = "INSERT INTO t3 VALUE(3, 'marry')";
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i > 0 ? "成功" : "失败");
        statement.close();
        connect.close();
    }
}
