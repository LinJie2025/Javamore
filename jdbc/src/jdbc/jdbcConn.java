package jdbc;//时间：2024/1/22 14:16

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcConn {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\study\\Javamore\\jdbc\\src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select * from t3 where id = ? and name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "1' or");
        preparedStatement.setString(2, "or '1' = '1'");
//        Statement statement = connection.createStatement();
//        String sql = "INSERT INTO t3 VALUE(5, 'lily')";
//        int i = statement.executeUpdate(sql);
//        System.out.println(i > 0 ? "成功" : "失败");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(id + "\t" + name);
        }
        preparedStatement.close();
        connection.close();
    }
}
