package File_;//时间：2023/8/11 14:24

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\news.txt"));
        String line = "";
        int num = 0;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(++num + line);
        }
        bufferedReader.close();
    }
}
