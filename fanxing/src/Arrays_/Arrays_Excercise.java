package Arrays_;//时间：2023/7/27 14:42

import java.util.Arrays;
import java.util.Comparator;

public class Arrays_Excercise {
    public static void main(String[] args) {
        Integer arr[] = {1,-1,7,8,90};
        System.out.println("===默认排序===");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("===自定义排序===");
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
