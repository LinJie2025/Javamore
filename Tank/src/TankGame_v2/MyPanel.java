package TankGame_v2;//时间：2023/8/3 9:51

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    //初始化我方坦克
    MyTank mytank = null;
    //敌人的坦克，用Vector集合
    Vector<EnemyTank> etank = new Vector<>();
    //敌人坦克数量
    int EnemyTankSize = 3;

    public MyPanel() {
        //初始化我方坦克
        mytank = new MyTank(500, 500);
        for (int i = 0; i < EnemyTankSize; i++) {
            //创建敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            //设置敌人坦克方向
            enemyTank.setDirect(2);
            etank.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //背景板
        g.fillRect(0, 0, 1000, 750);
//        DrawTank(mytank.getX(), mytank.getY(),g,0,0);
        //绘制我方坦克
        DrawTank(mytank.getX(), mytank.getY(), g, mytank.getDirect(), 0);
        //绘制敌方坦克
        for (int i = 0; i < etank.size(); i++) {
            EnemyTank enemyTank = etank.get(i);
            DrawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }
    }

    public void DrawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0://  0代表我方坦克
                g.setColor(Color.cyan);
                break;
            case 1://  1代表敌方坦克
                g.setColor(Color.red);
                break;
        }
        // 0上 1右 2下 3左
        switch (direct) {
            case 0://  0代表方向向上
                g.fill3DRect(x, y, 10, 60, false);//坦克左轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中轮廓
                g.fillOval(x + 10, y + 20, 20, 20);//坦克中心圆
                g.drawLine(x + 20, y + 30, x + 20, y - 10);//炮筒
                break;
            case 2://  0代表方向向下
                g.fill3DRect(x, y, 10, 60, false);//坦克左轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中轮廓
                g.fillOval(x + 10, y + 20, 20, 20);//坦克中心圆
                g.drawLine(x + 20, y + 30, x + 20, y + 70);//炮筒
                break;
            case 3://  3代表方向向左
                g.fill3DRect(x, y, 60, 10, false);//坦克上轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克中轮廓
                g.fillOval(x + 20, y + 10, 20, 20);//坦克中心圆
                g.drawLine(x + 20, y + 20, x - 10, y + 20);//炮筒
                break;
            case 1://  1代表方向向右
                g.fill3DRect(x, y, 60, 10, false);//坦克上轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克中轮廓
                g.fillOval(x + 20, y + 10, 20, 20);//坦克中心圆
                g.drawLine(x + 20, y + 20, x + 70, y + 20);//炮筒
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    public void move(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
            mytank.setDirect(0);
            mytank.moveUp();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            mytank.setDirect(1);
            mytank.moveRight();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
            mytank.setDirect(2);
            mytank.moveDown();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
            mytank.setDirect(3);
            mytank.moveLeft();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //按下shift键加速
        move(keyEvent);
        if (keyEvent.getKeyCode() == KeyEvent.VK_SHIFT) {
            move(keyEvent);
            mytank.setSpeed(5);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        move(keyEvent);
        if (keyEvent.getKeyCode() == KeyEvent.VK_SHIFT) {
            mytank.setSpeed(1);
            move(keyEvent);
        }
        repaint();
    }
}
