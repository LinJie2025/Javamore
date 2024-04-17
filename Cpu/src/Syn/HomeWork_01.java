package Syn;//时间：2023/8/5 10:48

import Thread_.ThreadExcercise;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.Scanner;

public class HomeWork_01 {
    public static void main(String[] args) {
        A sout = new A();
        B key = new B(sout);
        new Thread(sout).start();
        new Thread(key).start();
    }
}

class A extends Thread{
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
            System.out.println((int) (Math.random() * 100+1));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread{
    private A a;
    private Scanner scanner = new Scanner(System.in);
    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("输入Q退出");
            char key = scanner.next().toUpperCase().charAt(0);
            if(key == 'Q'){
                a.setLoop(false);
                System.out.println("b线程退出");
                break;
            }
        }
    }
}