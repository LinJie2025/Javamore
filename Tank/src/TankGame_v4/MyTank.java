package TankGame_v4;//时间：2023/8/3 9:51

import java.util.Vector;

public class MyTank extends Tank {
    Bullet bullet = null;

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shot() {
        switch (getDirect()) {
            case 0://子弹从炮筒打出
                bullet = new Bullet((int) getX() + 20, (int) getY() - 10, getDirect());
                break;
            case 1:
                bullet = new Bullet((int) getX() + 70, (int) getY() + 20, getDirect());
                break;
            case 2:
                bullet = new Bullet((int) getX() + 20, (int) getY() + 70, getDirect());
                break;
            case 3:
                bullet = new Bullet((int) getX() - 10, (int) getY() + 20, getDirect());
                break;
        }
        new Thread(bullet).start();
    }

}
