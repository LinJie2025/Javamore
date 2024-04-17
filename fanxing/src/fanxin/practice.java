package fanxin;//时间：2023/7/26 14:46

import java.util.ArrayList;
import java.util.Comparator;

public class practice {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom",10000,new MyDate(2000,4,8)));
        employees.add(new Employee("jack",20000,new MyDate(2004,7,18)));
        employees.add(new Employee("lin",30000,new MyDate(2001,6,9)));
        System.out.println("employees=" + employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return 0;
            }
        });
    }
}


class Employee{
    private String name;
    private int Sal;
    private MyDate birthday;


    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        Sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return Sal;
    }

    public void setSal(int sal) {
        Sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Sal=" + Sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparator<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compare(MyDate emp1, MyDate emp2) {
        return 0;
    }
}