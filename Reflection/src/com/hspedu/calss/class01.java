package com.hspedu.calss;//时间：2023/10/30 10:22

import com.hspedu.Cat.Cat;

import java.lang.reflect.Field;

public class class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllpath = "com.hspedu.Cat.Cat";
        Class<?> cls = Class.forName(classAllpath);
        Cat cat = (Cat)cls.newInstance();
        System.out.println(cat);
        Field name = cls.getField("name");
        System.out.println(name.get(cat));
    }
}
