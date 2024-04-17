package Arrays_;//时间：2023/7/27 15:53

public class gc {
    public static void main(String[] args) {
        Car bme = new Car("宝马");
        bme = null;
        System.gc();
    }
}
class Car {
    String name;
    public Car (String name){
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收了");
    }
}