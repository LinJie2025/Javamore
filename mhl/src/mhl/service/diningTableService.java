package mhl.service;//时间：2024/1/23 20:19

import mhl.dao.diningTableDAO;
import mhl.pojo.diningTable;


import java.util.List;

public class diningTableService {
    private diningTableDAO diningTableDAO = new diningTableDAO();
    //拿到餐桌编号和状态, 用于显示餐桌状态功能
    public List<diningTable> getTableIdAndState(){
        List<diningTable> diningTables = diningTableDAO.queryMulti("select id, state from diningTable", diningTable.class);
        return diningTables;
    }
    // 通过餐桌状态得到餐桌编号, 用于显示空餐桌的编号
    public List<diningTable> getTableIdByState(){
        List<diningTable> diningTables = diningTableDAO.queryMulti("select id from diningTable where state = ?", diningTable.class, "空");
        return diningTables;
    }
    // 通过餐桌编号得到餐桌状态, 用于判断此餐桌是否可用于预定
    public Object getTableStateById(Integer id){
        Object state = diningTableDAO.queryScalar("select state from diningTable where id = ?", id);
        return state;
    }
    //设置预定餐桌的姓名和电话号码
    public int setBookTableNameAndTel(Integer bookId, String name, String tel){
        int update = diningTableDAO.update("update diningtable set ordername = ?, ordertel = ? where id = ?", name, tel, bookId);
        return update;
    }
    //的到预定餐桌通过姓名
//    public List<diningTable> getBookTableByName(String bookName){
//        List<diningTable> diningTables = diningTableDAO.queryMulti("select id, ordername, ordertel from diningTable where name = ?", diningTable.class, bookName);
//        return diningTables;
//    }
    //更新餐桌的状态
    public boolean updateTableState(int tableId, String state){
        int update = diningTableDAO.update("update diningTable set state = ? where id = ?", state, tableId);
        return update > 0;
    }
    public boolean updateTableStateToFree(int tableId, String state){
        int update = diningTableDAO.update("update diningTable set state = ? , orderName = '', orderTel = '' where id = ?", state, tableId);
        return update > 0;
    }

}
