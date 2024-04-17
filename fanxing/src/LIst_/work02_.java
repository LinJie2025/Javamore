package LIst_;//时间：2023/8/1 16:54

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class work02_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);
        System.out.println("map" + map);
        System.out.println("修改jack的工资为2600元");
        map.put("jack",2600);
        System.out.println("map" + map);
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry next =  (Map.Entry) iterator.next();
//          System.out.println(next.getClass());
            map.put(next.getKey(),((int)next.getValue()) + 100);
//            System.out.println(next.getValue());
        }
        System.out.println("所有员工加薪100元");
        System.out.println("map" + map);
    }
}

