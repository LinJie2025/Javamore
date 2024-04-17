package fanxin;//时间：2023/8/2 14:18

import javax.swing.plaf.synth.SynthGraphicsUtils;
import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("jack", 18));
        students.add(new Student("mike", 20));
        students.add(new Student("tom", 22));
        System.out.println(students);


        HashMap<String, Student> HashMap = new HashMap<>();
        HashMap.put("第一", new Student("jack", 18));
        HashMap.put("第二", new Student("mike", 20));
        HashMap.put("第三", new Student("tom", 22));
//        System.out.println(HashMap);
        Set<String> keySet = HashMap.keySet();
        for (String s : keySet) {
            Student st = (Student) HashMap.get(s);
            System.out.println(st);
        }
        System.out.println("--------------------------------");
        Set<Map.Entry<String, Student>> entries = HashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getValue());
        }
    }

}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}