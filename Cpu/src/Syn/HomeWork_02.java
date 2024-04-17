package Syn;//时间：2023/8/5 11:18

public class HomeWork_02 {
    public static void main(String[] args) {
        Person person = new Person();
        Thread thread1 = new Thread(person);
        Thread thread2 = new Thread(person);
        thread1.setName("用户一");
        thread2.setName("用户二");
        thread1.start();
        thread2.start();
    }
}

class Person implements Runnable{
    private int sum = 10000;
    private boolean loop = true;
//    Object object = new Object();
    public void spend(){
        synchronized(this) {
            System.out.println("用户 " + Thread.currentThread().getName() + " 正在取钱... " + " 余额 " + (sum -= 1000));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (sum == 0){
            loop = false;
            System.out.println("余额不足");
        }
    }
    @Override
    public void run() {
        while (loop) {
            spend();
        }
    }
}