package jdbc;//时间：2024/1/22 16:47

import jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
//        String sql = "delete from t3 where name = ?";
//        String query = "select * from t3";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                String id = resultSet.getString(1);
//                String name = resultSet.getString(2);
//                System.out.println(id + "\t" + name);
//            }} catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        String user = scanner.nextLine();
        String sql = "insert into t3 values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, user);
            int i = preparedStatement.executeUpdate();
            System.out.println(i > 0 ? "成功" : "失败");
            JDBCUtils.closeAll(null, preparedStatement, connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
