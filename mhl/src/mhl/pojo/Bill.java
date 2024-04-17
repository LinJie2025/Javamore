package mhl.pojo;//时间：2024/1/24 17:04

import java.util.Date;

/*
(id int PRIMARY KEY auto_increment,
billId VARCHAR(50) not null DEFAULT '',
menuId int not null DEFAULT 0,
nums int not null DEFAULT 0,
money double not null DEFAULT 0,
tableId int not null DEFAULT 0,
billDate DATETIME not null,
billState VARCHAR(50) not null DEFAULT '');
 */
public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private double money;
    private Integer tableId;
    private Date billDate;
    private String billState;

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer menuId, Integer nums, double money, Integer tableId, Date billDate, String billState) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.tableId = tableId;
        this.billDate = billDate;
        this.billState = billState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillState() {
        return billState;
    }

    public void setBillState(String billState) {
        this.billState = billState;
    }

    @Override
    public String toString() {
        return id + "\t" + menuId + "\t" + nums + "\t\t" + money + "\t" + tableId + "\t\t" + billDate + "\t" + billState;
    }

}
