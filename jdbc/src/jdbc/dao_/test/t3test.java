package jdbc.dao_.test;//时间：2024/1/23 16:20

import jdbc.dao_.dao.t3DAO;
import jdbc.dao_.pojo.T3;

import java.util.List;

public class t3test {
    public static void main(String[] args) {
        t3DAO t3DAO = new t3DAO();
        List<T3> t = t3DAO.queryMulti("select * from t3", T3.class);
//            System.out.println(t);
//        Object o = t3DAO.querySingle("select * from t3 where id = ?", t3.class, 2);
        Object o = t3DAO.queryScalar("select name from t3 where id = ?", 2);
        System.out.println(o);
//        int smith = t3DAO.update("insert into t3 values(?, ?)", 7, "smith");
//        System.out.print(smith > 0 ? "成功" : "失败");


    }
}
