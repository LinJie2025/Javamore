package TankGame_v6;//时间：2023/8/3 9:53

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankGame06 extends JFrame {
    private MyPanel mp = null;


    public static void main(String[] args) {
        new TankGame06();

    }
    public TankGame06(){
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1300,900);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.Record();
                System.exit(0);
            }
        });
    }
}

