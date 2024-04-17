package TankGame_v4;//时间：2023/8/3 9:51

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    //初始化我方坦克
    MyTank mytank = null;
    //敌人的坦克，用Vector集合
    Vector<EnemyTank> etank = new Vector<>();
    //敌人坦克数量
    int EnemyTankSize = 3;

    public MyPanel() {
        //初始化我方坦克
        mytank = new MyTank(200, 200);
        for (int i = 0; i < EnemyTankSize; i++) {
            //创建敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            //设置敌人坦克方向
            enemyTank.setDirect(2);
            //让敌方坦克自由移动
            new Thread(enemyTank).start();
            //创建敌人子弹对象
            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //加入到敌人子弹对象的Vector中
            enemyTank.bullets.add(bullet);
//            new Thread(bullet).start();
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
            //从Vector集合中获取敌方坦克对象
            EnemyTank enemyTank = etank.get(i);
            //敌方坦克存活才绘制敌方坦克，如果死亡则删除敌方坦克
            if (enemyTank.isLive) {
                DrawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
            } else {
                //坦克爆炸效果
                Bomb(enemyTank, g);
                //敌方坦克死亡从Vector集合中删除敌方坦克
                etank.remove(enemyTank);
            }
            //循环遍历绘制出敌方坦克射出的子弹
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                //从Vector集合中获取敌方子弹对象
                Bullet bullet = enemyTank.bullets.get(j);
                //子弹存活才绘制
                if (bullet.isLive) {
                    g.setColor(Color.red);
                    g.fillOval(bullet.x, bullet.y, 2, 2);
                } else {
                    //从Bullet Vector集合中删除子弹
                    enemyTank.bullets.remove(bullet);
                    System.out.println("敌人子弹线程退出");
                }
            }
        }
        //我方坦克子弹射出

            if (mytank.bullet != null && mytank.bullet.isLive) {
                g.setColor(Color.cyan);
                g.fillOval(mytank.bullet.x, mytank.bullet.y, 2, 2);
            }

    }

    //绘制坦克的爆炸效果
    public void Bomb(Tank tank, Graphics g) {
        g.setColor(Color.red);
        while (!tank.isLive) {
            if (tank.life > 0) {
                tank.life--;
                switch (tank.getDirect()) {
                    case 0:
                    case 2:
                        if (tank.life > 6) {
                            g.fillOval(tank.getX(), tank.getY(), 60, 60);
                            System.out.println("坦克爆炸");
                        } else if (tank.life > 3) {
                            g.fillOval(tank.getX() + 10, tank.getY() + 20, 30, 30);
                            System.out.println("坦克爆炸");
                        }
                        break;
                    case 1:
                    case 3:
                        if (tank.life > 6) {
                            g.fillOval(tank.getX() + 20, tank.getY() + 10, 60, 60);
                            System.out.println("坦克爆炸");
                        } else if (tank.life > 3) {
                            g.fillOval(tank.getX() + 20, tank.getY() + 10, 30, 30);
                            System.out.println("坦克爆炸");
                        }
                        break;
                }
            } else {
                break;
            }
        }
    }

    //绘制坦克
    public void DrawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0://  0代表我方坦克
                g.setColor(Color.cyan);
                g.drawLine(1, 1, 1, 1);
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

    //击中坦克
    public void hitTank(Bullet bullet, Tank tank) {
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (bullet.x > tank.getX() && bullet.x < tank.getX() + 40 && bullet.y > tank.getY() && bullet.y < tank.getY() + 60) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    System.out.println("子弹击中敌人坦克");
                }
                break;
            case 1:
            case 3:
                if (bullet.x > tank.getX() && bullet.x < tank.getX() + 60 && bullet.y > tank.getY() && bullet.y < tank.getY() + 40) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    System.out.println("子弹击中敌人坦克");
                }
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
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_J) {
//            System.out.println("");
            mytank.shot();
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

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断何时击中敌方坦克
            if (mytank.bullet != null && mytank.bullet.isLive) {
                for (int i = 0; i < etank.size(); i++) {
                    EnemyTank enemyTank = etank.get(i);
                    hitTank(mytank.bullet, enemyTank);
                }
            }
            repaint();
        }
    }
}
