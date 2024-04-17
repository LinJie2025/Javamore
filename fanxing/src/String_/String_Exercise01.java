package String_;//时间：2023/7/27 10:12
class Test1{
    String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};
    public void change(String str, char[] ch){
        str = "java";
        ch[0] = 'h';
    }
}
public class String_Exercise01 {
    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + "and");
        System.out.println(ex.ch);
    }
}
