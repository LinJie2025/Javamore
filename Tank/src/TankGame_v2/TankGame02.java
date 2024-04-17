package TankGame_v2;//时间：2023/8/3 9:53

import javax.swing.*;

public class TankGame02 extends JFrame {
    private MyPanel mp = null;


    public static void main(String[] args) {
        new TankGame02();

    }
    public TankGame02(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

