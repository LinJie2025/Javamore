package TankGame_v6;//时间：2023/8/3 9:50

public class Tank {
    int life = 9;
    int x;
    int y;
    int direct;
    int speed = 1;
    boolean isLive = true;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        if (getY() - 10> 0)
            y -= speed;
    }

    public void moveDown() {
        if (getY() + 110 < 750)
            y += speed;
    }

    public void moveRight() {
        if (getX() + 80 < 1000)
            x += speed;
    }

    public void moveLeft() {
        if (getX() - 10 > 0)
            x -= speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
