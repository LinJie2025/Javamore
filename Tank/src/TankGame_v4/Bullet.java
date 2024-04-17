package TankGame_v4;//时间：2023/8/5 14:19

public class Bullet implements Runnable {
    int x;//子弹x坐标
    int y;//子弹y坐标
    int direct;//子弹的方向
    int speed = 2;//子弹的速度
    boolean isLive = true;
    //构造器


    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            System.out.println("子弹 X "+ x +"Y " + y);
            if (!(x >= 0 && x < 1000 && y >= 0 && y < 750)) {
                isLive = false;
                break;
            }
        }
    }
}
