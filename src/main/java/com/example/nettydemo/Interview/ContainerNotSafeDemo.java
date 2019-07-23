package com.example.nettydemo.Interview;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Classname ContainerNotSafeDome
 * @Description 集合类不安全的问题  ArrayList
 * @Date 2019/7/22 14:48
 * @Author lyn
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        //List<String> list = Arrays.asList();
        //list.forEach(System.out::println);
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();


        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
