package mhl.service;//时间：2024/1/23 19:07

import mhl.dao.EmployeeDAO;
import mhl.pojo.Employees;
import mhl.utils.JDBCUtils;

import java.sql.Connection;

public class employeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    public Employees getEmployeeByIdAndPwd(String empId, String passwd){
        Employees employees =
                employeeDAO.querySingle("select * from employees where empid = ? and password = md5(?)",
                        Employees.class, empId, passwd);
        return employees;
    }
//    public Object getPasswd(Integer id){
//        Connection connection = null;
//        connection = JDBCUtils.getConnection();
//        Object o = employeeDAO.queryScalar("select password from employees where empid = ?", id);
//        JDBCUtils.closeAll(null, null, connection);
//        return o;
//    }
//    public Object getName(Integer id){
//        Connection connection = null;
//        connection = JDBCUtils.getConnection();
//        Object o = employeeDAO.queryScalar("select name from employees where empid = ?", id);
//        JDBCUtils.closeAll(null, null, connection);
//        return o;
//    }
//    public Object getJob(Integer id){
//        Connection connection = null;
//        connection = JDBCUtils.getConnection();
//        Object o = employeeDAO.queryScalar("select job from employees where empid = ?", id);
//        JDBCUtils.closeAll(null, null, connection);
//        return o;
//    }
}
