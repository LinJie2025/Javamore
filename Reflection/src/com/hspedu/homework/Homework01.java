package com.hspedu.homework;//时间：2023/11/12 17:12

import java.lang.reflect.Field;

public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> ptcls = Class.forName("com.hspedu.homework.PrivateTest");
        Object o = ptcls.newInstance();
        Field name = ptcls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "喵");
        System.out.println(name.get(o));
    }
}

class PrivateTest{
    private String name = "HelloKitty";
    public String getName(){
        return name;
    }
}