package TankGame_v5;//时间：2023/8/3 9:53

import javax.swing.*;

public class TankGame05 extends JFrame {
    private MyPanel mp = null;


    public static void main(String[] args) {
        new TankGame05();

    }
    public TankGame05(){
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

