package jdbc.dao_.dao;//时间：2024/1/23 15:44

import jdbc.dao_.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    //dml语句
    public int update(String sql, Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            int affectedRows = qr.update(connection, sql, params);
            return affectedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeAll(null, null, connection);
        }
    }

    // 返回多个对象
    /**
     *
     * @param sql 传入的SQL语句
     * @param cls 传入的pojo类
     * @param params 传入要给 ? 赋值的字段
     * @return
     */
    public List<T> queryMulti(String sql, Class<T> cls, Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            List<T> list = qr.query(connection, sql, new BeanListHandler<T>(cls), params);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeAll(null, null, connection);
        }
    }

    // 返回单个对象
    public T querySingle(String sql, Class<T> cls, Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            T query = qr.query(connection, sql, new BeanHandler<T>(cls), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeAll(null, null, connection);
        }
    }

    // 返回单行单列
    public Object queryScalar(String sql, Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Object query = qr.query(connection, sql, new ScalarHandler<>(), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeAll(null, null, connection);
        }
    }

}
