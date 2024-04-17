package File_;//时间：2023/8/10 14:18

import jdk.jfr.StackTrace;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
//        create01();
//        create02();
        create03();
    }
    //方式一：new File(String filePath)
    public static void create01(){
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式二：new File(String parent, String child)
    public static void create02(){
        String parent = "d:\\";
        String child = "news2.txt";
        try {
            new File(parent,child).createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式三：new File(File parent, String child)
    public static void create03(){
        File file = new File("d:\\");
        String child = "news3.txt";
        try {
            new File(file,child).createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
