package Draw_;//时间：2023/8/3 9:28

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{
    private MyPanle mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        mp = new MyPanle();
        this.add(mp);
        this.setSize(400,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanle extends JPanel{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50,50,50,50);
    }


}