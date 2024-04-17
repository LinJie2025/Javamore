package File_;//时间：2023/8/10 15:59

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

    }

    public void wirte(){
        String filePath = "d:\\note.txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
