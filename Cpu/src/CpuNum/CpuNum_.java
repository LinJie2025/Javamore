package CpuNum;//时间：2023/8/3 16:19

public class CpuNum_ {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }
}
