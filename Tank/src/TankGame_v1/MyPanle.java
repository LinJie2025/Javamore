package TankGame_v1;//时间：2023/8/3 9:51

import javax.swing.*;
import java.awt.*;

public class MyPanle extends JPanel  {
    MyTank mytank = null;
    EnemyTank etank = null;

    public MyPanle(){
        mytank = new MyTank(100,100);
//        etank = new EnemyTank(x,y + 400);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        DrawTank(mytank.getX(), mytank.getY(),g,0,0);
//        DrawTank(etank.getX(), etank.getY(),g,0,1);
    }

    public void DrawTank(int x, int y, Graphics g, int direct, int type){
        switch (type){
            case 0 ://  0代表我方坦克
                g.setColor(Color.cyan);
                break;
            case 1 ://  1代表敌方坦克
                g.setColor(Color.red);
                break;
        }
        switch (direct){
            case 0 ://  0代表方向向上
                g.fill3DRect(x,y,10,60,false);//坦克左轮子
                g.fill3DRect(x + 30,y,10,60,false);//坦克右轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//坦克中轮廓
                g.fillOval(x + 10,y + 20, 20,20);//坦克中心圆
                g.drawLine(x + 20, y + 30, x + 20,y - 10);
                break;
        }
    }

}
