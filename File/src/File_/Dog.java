package File_;//时间：2023/8/11 14:30

import java.io.Serializable;

public class Dog implements Serializable {
    String name;
    String age;
    String color;

//    public Dog(String name, String age, String color) {
//        this.name = name;
//        this.age = age;
//        this.color = color;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
