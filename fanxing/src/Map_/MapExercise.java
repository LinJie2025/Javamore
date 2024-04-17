package Map_;//时间：2023/8/1 14:38

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("01",new Person("jack",01,15000));
        map.put("02",new Person("marry",02,20000));
        map.put("03",new Person("Mike",03,11000));
        map.put("04",new Person("jie",04,10000));
        map.put("05",new Person("john",05,15000));
        map.put("06",new Person("tom",06,19000));
        Set keyset  = map.keySet();
        for (Object key : keyset) {
            Person p = (Person) map.get(key);
            if(p.getSal() > 18000){
                System.out.println(p);
            }
        }
        System.out.println("------------");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator.next();
            Person p = (Person) entry.getValue();
            if(p.getSal()>18000){
                System.out.println(p);
            }
        }

    }
}
class Person{
    private String name;
    private int id;
    private double sal;

    public Person(String name, int id, double sal) {
        this.name = name;
        this.id = id;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sal=" + sal +
                '}';
    }
}