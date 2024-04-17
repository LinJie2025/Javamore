package mhl.service;//时间：2024/1/23 19:17

import mhl.dao.EmployeeDAO;
import mhl.dao.diningTableDAO;
import mhl.pojo.Bill;
import mhl.pojo.Employees;
import mhl.pojo.diningTable;
import mhl.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Connection connection = null;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        diningTableDAO diningTableDAO = new diningTableDAO();
        connection = JDBCUtils.getConnection();
        billService billService = new billService();
//        Object o = employeeDAO.querySingle("select id from employees where id = ?", Employees.class, 001);
//        Object o1 = employeeDAO.queryScalar("select job, empid from employees where empid = ?", 666001);
//        List<diningTable> diningTables = diningTableDAO.queryMulti("select id from diningTable where state = ?", diningTable.class, "空");
//        for (diningTable dingtable: diningTables
//             ) {
//            Integer id = dingtable.getId();
//            System.out.println(id);
//        }
//        Object state = diningTableDAO.queryScalar("select state from diningTable where id = ?", 1);
////        System.out.println(state);
//        List<diningTable> diningTables = diningTableDAO.queryMulti("select id from diningTable where state = '就餐中'", diningTable.class);
//        for (diningTable diningTable : diningTables){
//            System.out.println(diningTable.getId());
//        }
//        diningTable diningTable = diningTableDAO.querySingle("select id from diningTable where state = '就餐中'", diningTable.class);
//        System.out.println(diningTable.getId());
        List<Bill> bills = billService.showBillByTableId(1);
        for (Bill bill : bills){
            System.out.println(bill);
        }
//        System.out.println(diningTables);
//        System.out.println(o1);
    }
}
