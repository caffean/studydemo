package com.example.nettydemo.Interview;

public class SingletonDemo {

    private static volatile SingletonDemo instance=null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法 SingletonDemo()");
    }

    //DCL double check lock 双端检索机制
    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //
        //System.out.println();
        //System.out.println();
        //System.out.println();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
