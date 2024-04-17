package TankGame_v6;//时间：2023/8/3 10:33

import java.util.Vector;

@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    Vector<Bullet> bullets = new Vector<>();

    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //敌人坦克随机移动
    @Override
    public void run() {
        while (true) {
            //限制敌人子弹数量
            if (isLive && bullets.size() == 0) {
                Bullet bullet = null;

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
                bullets.add(bullet);
                new Thread(bullet).start();
            }

            switch (getDirect()) {
                case 0: //向上
                    for (int i = 0; i < 30; i++) {
                        if (!isTouch()){
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1: //向右
                    for (int i = 0; i < 30; i++) {
                        if (!isTouch()){
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2: //向下
                    for (int i = 0; i < 30; i++) {
                        if (!isTouch())
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
                        if (!isTouch())
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
            if (!isLive) {
                break;
            }
        }
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks){
        this.enemyTanks = enemyTanks;
    }
    public boolean isTouch() {
        switch (getDirect()) {
            case 0: //上
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() > enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                            //当前坦克右上角坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 40 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 60 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }
                            //当前坦克右上角坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 60 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1: //右
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克右上角坐标[this.getX()+60,this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 40 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 40 &&
                                    this.getY() + 40 >= enemyTank.getY() &&
                                    this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克右上角坐标[this.getX()+60,this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 60 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 60 &&
                                    this.getY() + 40 >= enemyTank.getY() &&
                                    this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2: //下
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克左下角坐标[this.getX(),this.getY()+60]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 40 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克左下角坐标[this.getX(),this.getY()+60]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() < enemyTank.getX() + 60 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 60 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3: //左
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                            //当前坦克左下角坐标[this.getX(),this.getY()+40]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() + 40 >= enemyTank.getY() &&
                                    this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 60 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }
                            //当前坦克左下角坐标[this.getX(),this.getY()+40]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 60 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }
}


