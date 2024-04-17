package TankGame_v6;//时间：2023/8/11 17:19

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Recorder {
    //记录我方击毁的坦克数
    private static int Enemytanknum = 0;
    //定义IO对象
    private static BufferedWriter bw = null;
    private static String recordPath = "d:\\myRecord.txt";

    public static void Record(){
        try {
            bw = new BufferedWriter(new FileWriter(recordPath));
            bw.write(Enemytanknum + "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null)
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getEnemytanknum() {
        return Enemytanknum;
    }

    public static void setEnemytanknum(int enemytanknum) {
        Enemytanknum = enemytanknum;
    }
    //当我方击毁一个坦克就应该让 Enemytanknum++
    public static void addEnemytanknum(){
        Recorder.Enemytanknum++;
    }
}
