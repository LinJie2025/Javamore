package File_;//时间：2023/8/11 14:29

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
//        properties.setProperty("name","tom");
//        properties.setProperty("age","5");
//        properties.setProperty("color","red");
//        properties.store(new FileWriter("File\\src\\Dog.properties"),null);
//        System.out.println("配置文件创建成功");
        properties.load(new FileReader("File\\src\\Dog.properties"));
        Dog dog = new Dog();
        dog.setAge(properties.getProperty("age"));
        dog.setName(properties.getProperty("name"));
        dog.setColor(properties.getProperty("color"));
        System.out.println(dog);

        String setFilePath = "d:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(setFilePath));
        objectOutputStream.writeObject(dog);
        System.out.println("dog序列化完成");
        objectOutputStream.close();
        m1();
    }
    public static void m1() throws IOException, ClassNotFoundException {
        String setFilePath = "d:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(setFilePath));
//        Dog dog = (Dog) objectInputStream.readObject();
        System.out.println("反序列化后");
        System.out.println(objectInputStream.readObject());
//        System.out.println(dog);
        objectInputStream.close();
    }
}
