package Hash;//时间：2023/8/1 16:12

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                    return ((String)o).length() -((String)t1).length() ;
//                return ((String)o).compareTo((String)t1);
            }
        });
        treeMap.put("jack","杰克");
        treeMap.put("marry","玛丽");
        treeMap.put("smith","史密斯");
        treeMap.put("tom","汤姆");
        System.out.println(treeMap);
    }
}
