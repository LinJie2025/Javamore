package Thread_;//时间：2023/8/4 10:07

public class ThreadExcercise {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);
        for (int i=0; i<10; i++){
            System.out.println("hi"+i);
            Thread.sleep(1000);
            if(i==4){
                thread.start();
                thread.join();
            }
        }
    }
}

class T implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}