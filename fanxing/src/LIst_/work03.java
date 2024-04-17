package LIst_;//时间：2023/8/1 17:14


import java.util.HashSet;
import java.util.Objects;

public class work03 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        hashSet.add(p1);
        hashSet.add(p2);
        p1.name = "CC";
        hashSet.remove(p1);
        System.out.println(hashSet);
        hashSet.add(new Person(1001,"CC"));
        System.out.println(hashSet);
    }
}

class Person{
     String name;
     int id;

    public Person(int id,String name ) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id +'\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}