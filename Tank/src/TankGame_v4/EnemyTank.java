package TankGame_v4;//时间：2023/8/3 10:33

import TankGame_v4.Bullet;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Bullet> bullets = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
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

