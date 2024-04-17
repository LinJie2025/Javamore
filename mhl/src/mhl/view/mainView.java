package mhl.view;//时间：2024/1/23 17:34

import mhl.pojo.Employees;
import mhl.service.employeeService;
import mhl.utils.Utility;

import javax.swing.text.View;

public class mainView {
    public static void main(String[] args) {
        new mainView().View();
    }

    employeeService employeeService = new employeeService();
    public void View() {
        boolean loop = true;
        while(loop) {
            System.out.println("===============满汉楼===============");
            System.out.println("\t\t\t1登录满汉楼");
            System.out.println("\t\t\t0退出满汉楼");
            System.out.print("请输入你的选择:");
            int i = Utility.readInt();
            switch (i) {
                case 1:
//                    System.out.println("满汉楼二级菜单");
                    System.out.println("请输入员工号");
                    String empId = Utility.readString(50);
                    System.out.println("请输入密码");
                    String password = Utility.readString(50);
//                    Object passwd = employee.getPasswd(id);
                    Employees employee = employeeService.getEmployeeByIdAndPwd(empId, password);
                    if (employee != null){// 判断员工账号和密码是否合法
                        String name = employee.getName();
                        String job = employee.getJob();
                        System.out.println("===========欢迎"+ name + job + "登录满汉楼系统===========");
                        new secondView().view();
                    }else{
                        System.out.println("账号或密码错误,请重新输入");
                    }
//                    loop = false;
                    break;
                case 0:
//                    loop = false;
                    System.exit(0);
            }
        }
    }
}
