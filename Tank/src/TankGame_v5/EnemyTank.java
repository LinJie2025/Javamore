package TankGame_v5;//时间：2023/8/3 10:33

import java.util.Vector;
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    Vector<Bullet> bullets = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //敌人坦克随机移动
    @Override
    public void run() {
        while (true) {

            if (isLive && bullets.size() == 0){
                Bullet bullet = null;

                switch (getDirect()){
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
                bullets.add(bullet);
                new Thread(bullet).start();
            }

                switch (getDirect()) {
                    case 0: //向上
                        for (int i = 0; i < 30; i++) {
                            moveUp();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                            break;
                    case 1: //向右
                        for (int i = 0; i < 30; i++) {
                            moveRight();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                            break;
                    case 2: //向下
                        for (int i = 0; i < 30; i++) {
                            moveDown();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                            break;
                    case 3: //向左
                        for (int i = 0; i < 30; i++) {
                            moveLeft();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                            break;
                }
            setDirect((int) (Math.random() * 4));
                if (!isLive){
                    break;
                }
            }
        }
    }

