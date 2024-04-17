package mhl.pojo;//时间：2024/1/23 18:08

public class Employees {
    private Integer id; // 员工id
    private String empId;
    private String name; // 员工姓名
    private String password; // 员工的登录密码
    private String job;

    public Employees() {
    }

    public Employees(Integer id, String empId, String name, String password, String job) {
        this.id = id;
        this.empId = empId;
        this.name = name;
        this.password = password;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
