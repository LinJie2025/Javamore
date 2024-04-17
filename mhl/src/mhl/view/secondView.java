package mhl.view;//时间：2024/1/23 17:38

import mhl.pojo.Bill;
import mhl.pojo.Menu;
import mhl.pojo.diningTable;
import mhl.service.diningTableService;
import mhl.service.menuService;
import mhl.service.billService;
import mhl.utils.Utility;
import org.junit.jupiter.api.Test;

import java.util.List;

public class secondView {
    private diningTableService diningTableService= new diningTableService();
    private menuService menuService = new menuService();
    private billService billService = new billService();

    public void showDiningTable(){
        List<diningTable> tableState = diningTableService.getTableIdAndState();
        System.out.println("桌号\t状态");
        for (diningTable table: tableState) {
            Integer id = table.getId();
            String state = table.getState();
            System.out.println(id + "\t" + state);
        }
    }
     public void showAvailableDiningTable(){
        List<diningTable> tableState = diningTableService.getTableIdByState();
        System.out.println("可预定的桌号");
        for (diningTable table: tableState) {
            Integer id = table.getId();
            System.out.print(id + "\t");
//            String state = table.getState();
//            System.out.println(id + "\t" + state);
        }
         System.out.println();
    }
    public void bookDiningTable(){
        System.out.print("请选择要预定的餐桌编号(-1退出):");
        Integer bookId = Utility.readInt();
        if (bookId == -1 || diningTableService.getTableStateById(bookId).equals("预定")
                || diningTableService.getTableStateById(bookId).equals("就餐中")){
            return;
        }
        System.out.print("确认是否预定(Y/N):");
        String confirm = Utility.readString(50);
        if (confirm.equals("Y")){
            System.out.print("预定人姓名:");
            String bookName = Utility.readString(50);
            System.out.print("预定人电话号码:");
            String bookTel = Utility.readString(50);
            int bookState = diningTableService.setBookTableNameAndTel(bookId, bookName, bookTel);
            diningTableService.updateTableState(bookId, "预定");
            System.out.println(bookState > 0 ? "预定成功!" : "预定失败!请重新预定");
        }else {
            return;
        }
    }
    public void showFood(){
        List<Menu> menus = menuService.showAll();
        System.out.println("编号\t菜名\t\t类别\t\t价格");
        for(Menu menu : menus){
            System.out.println(menu);
        }
    }
    public void showAllBill(int tableId){
        List<Bill> bills = billService.showBillByTableId(tableId);
        System.out.println("编号\t菜名\t菜品量\t金额\t\t桌号\t\t日期\t\t\t\t\t\t状态");
        for (Bill bill : bills){
            System.out.println(bill);
        }
    }
    public void orderMenu(){
        showDiningTable();
        System.out.print("请选择要点餐的桌号(-1退出):");
        int bookID = Utility.readInt();
        showFood();
        System.out.print("请选择菜品编号(-1退出):");
        int menuID = Utility.readInt();
        System.out.print("请选择菜品数量(-1退出):");
        int nums = Utility.readInt();
        System.out.print("确认是否要点这个菜(Y/N):");
        String confirm = Utility.readString(50);
        if (confirm.equals("N")){
            return;
        }
        boolean b = billService.orderMenu(menuID, nums, bookID);
        if (b){
            System.out.print("点餐结果=1");
        }else {
            System.out.print("点餐结果=0");
        }
    }
    public void checkOut(){
        System.out.print("请选择要结账的餐桌编号(-1退出):");
        int tableId = Utility.readInt();
        if (billService.selectUnPayBill(tableId)){
            List<Bill> bills = billService.showBillByTableId(tableId);
            System.out.println("编号\t菜名\t菜品量\t金额\t\t桌号\t\t日期\t\t\t\t\t\t状态");
            for (Bill bill : bills){
                System.out.println(bill);
            }
            System.out.print("结账方式(现金/微信/支付宝):");
            String checkOutMethod = Utility.readString(50);
            System.out.print("是否确认结账(Y/N):");
            String confirm = Utility.readString(50);
            if (confirm.equals("N")){
                return;
            }
            billService.checkOut(checkOutMethod, tableId);
        }else {
            System.out.println("该餐桌已结账");
        }
    }
        public void view(){
            boolean loop = true;
            while(loop) {
                System.out.println("============满汉楼二级菜单============");
                System.out.println("\t\t\t1显示餐桌状态");
                System.out.println("\t\t\t2预定餐桌");
                System.out.println("\t\t\t3显示所有菜品");
                System.out.println("\t\t\t4点餐");
                System.out.println("\t\t\t5查看账单");
                System.out.println("\t\t\t6结账");
                System.out.println("\t\t\t0返回一级菜单");
                System.out.print("请输入你的选择:");
                int i = Utility.readInt();
                switch (i) {
                    case 1:
//                        System.out.println("1显示餐桌状态");
                        showDiningTable();
                        break;
                    case 2:
//                        System.out.println("2预定餐桌");
                        System.out.println("当前可预定的餐桌编号为:");
                        showAvailableDiningTable();
                        bookDiningTable();
                        break;
                    case 3:
//                        System.out.println("3显示所有菜品");
                            showFood();
                        break;
                    case 4:
//                        System.out.println("4点餐");
                        orderMenu();
                        break;
                    case 5:
//                        System.out.println("5查看账单");
                        showDiningTable();
                        System.out.print("请输入要查看账单的桌号(-1退出):");
                        int tableId = Utility.readInt();
                        showAllBill(tableId);
                        break;
                    case 6:
//                        System.out.println("6结账");
                        checkOut();
                        break;
                    case 0:
                        new mainView().View();
                        break;

                }
            }
        }
}
