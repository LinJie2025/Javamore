package TankGame_v1;//时间：2023/8/3 9:53

import javax.swing.*;

public class TankGame extends JFrame {
    private MyPanle mp = null;


    public static void main(String[] args) {
        new TankGame();

    }
    public TankGame(){
        mp = new MyPanle();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

