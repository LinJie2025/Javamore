package com.hspedu.reflection.question;//时间：2023/10/22 11:45

import com.hspedu.Cat.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        System.out.println(o.getClass());
    }
}
