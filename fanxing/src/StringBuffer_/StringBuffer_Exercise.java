package StringBuffer_;//时间：2023/7/27 11:37

public class StringBuffer_Exercise {
    public static void main(String[] args) {
        String s = null;
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        System.out.println(sb);
        System.out.println(sb.length());
        StringBuffer sb1 = new StringBuffer(s);
        System.out.println(sb1);
    }
}
