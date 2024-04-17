package mhl.service;//时间：2024/1/24 17:08

import mhl.dao.billDAO;
import mhl.pojo.Bill;

import java.util.List;
import java.util.UUID;

public class billService {
    private billDAO billDAO = new billDAO();
    private menuService menuService = new menuService();
    private diningTableService diningTableService = new diningTableService();
    public List<Bill> showBillByTableId(int tableId){
        List<Bill> bills = billDAO.queryMulti("select * from bill where tableId = ?", Bill.class, tableId);
        return bills;
    }
    public boolean orderMenu(int menuId, int nums, int tableID){
        String billID = UUID.randomUUID().toString();
        int update = billDAO.update("insert into bill values(null, ?, ?, ?, ?, ?, now(), '未结账')",
                billID, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, tableID);
        if (update <= 0){
            return false;
        }
        return diningTableService.updateTableState(tableID, "就餐中");
    }
    public boolean checkOut(String checkMethod, int tableId){
        int update = billDAO.update("update bill set billState = ? where tableId = ?", checkMethod, tableId);
        if (update <= 0){
            return false;
        }
        return diningTableService.updateTableStateToFree(tableId, "空");
    }
    public boolean selectUnPayBill(int tableId){
        Bill bill = billDAO.querySingle("select * from bill where billState = '未结账' and tableId = ?", Bill.class, tableId);
        return bill != null;
    }
}
