package File_;//时间：2023/8/11 14:11

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\mytemp";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdir();
            System.out.println("文件夹创建成功");
        }
        String filePath2 = "d:\\mytemp\\hello.txt";
        File file1 = new File(filePath2);
        if(file1.exists()){
            System.out.println("该文件已存在");
        }else{
            file1.createNewFile();
            System.out.println("文件创建成功");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
            bufferedWriter.write("helloworld");
            bufferedWriter.close();
        }
    }
}
