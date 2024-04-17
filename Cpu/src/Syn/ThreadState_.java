package Syn;//时间：2023/8/5 9:59

public class ThreadState_ {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
    }
}

class SellTicket extends Thread {
    private int TickNum = 100;
    private boolean loop = true;
    public synchronized void sell() {
        if (TickNum==0){
            System.out.println("票已卖完。。。");
            loop = false;
            return;
        }
        System.out.println(" 窗口 " + Thread.currentThread().getName() + " 售出一张票 " + " 剩余票数 = " + (--TickNum));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(loop){
            sell();

        }
    }
}