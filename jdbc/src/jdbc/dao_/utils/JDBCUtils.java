package jdbc.dao_.utils;//时间：2024/1/22 16:23

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static String user; //用户名
    public static String password; //密码
    public static String url; //数据库链接
    public static String driver; //驱动明

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\study\\Javamore\\jdbc\\src\\mysql.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
        driver = properties.getProperty("dirver");
    }

    //connect database
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //dml
//    public static void executeAdd(String sql, String id, String name){
//        Connection connection = getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, id);
//            preparedStatement.setString(2, name);
//            int i = preparedStatement.executeUpdate();
//            System.out.println(i > 0 ? "成功" : "失败");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static void executeUpdate(String sql, String id, String name){
//        Connection connection = getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, id);
//            int i = preparedStatement.executeUpdate();
//            System.out.println(i > 0 ? "成功" : "失败");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }



    //close sources
    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection){
        try {
        if (resultSet != null){
            resultSet.close();
            }
        if (statement != null){
            statement.close();
        }
        if (connection != null){
            connection.close();
        }}catch (SQLException e) {
            throw new RuntimeException(e);
            }
    }

}
