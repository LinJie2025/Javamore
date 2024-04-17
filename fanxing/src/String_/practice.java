package String_;//时间：2023/7/27 9:36

public class practice {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";
        System.out.println(p1.name.equals(p2.name));    //T
        System.out.println(p1.name == p2.name);         //F
        System.out.println(p1.name == "hspedu");
        System.out.println(p1 == p2);

        String s1 = new String("abcd");

        String s2 = new String("abcd");
        System.out.println(s1 == s2);
    }
}
class Person {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}