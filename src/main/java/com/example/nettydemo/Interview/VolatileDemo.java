package com.example.nettydemo.Interview;


import sun.rmi.runtime.NewThreadAction;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
    //number前已将加了volatile
    public  void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.验证 volatile的可见性
 *  1.1加入int number = 0； number变量之前根本没有添加volatile关键字修饰  没有可见性
 *  1.2 添加了volatile可以解决可见性问题
 * 2.验证volatile不保证原子性
 *  2.1 原子性什么意思：
 *      不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要整体完整
 *      要么同时成功，要么同时失败
 *  2.2 volatile不保证原子性演示
 */
public class VolatileDemo {

    public static void main(String[] args) { //main 是一切方法的入口
        MyData myData = new MyData();

        for (int i = 1; i<=20; i++){
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待20个线程计算完成后再用main线程取得最终的结果值看是多少
       while (Thread.activeCount()>2){
            Thread.yield();
       }
        System.out.println(Thread.currentThread().getName()+"\t int type finally number value:"+ myData.number);
        System.out.println(Thread.currentThread().getName()+"\t atomicInteger type finally number value:"+ myData.atomicInteger);

    }

    /**
     * volatile 可以保证可见性，及时通知其他线程，主物理内存的值已经改变
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData(); //资源类
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() +"\t updated number value: "+myData.number);
        },"AAA").start();

        //第二个线程是main线程
        while (myData.number == 0){
            //main一直等待 知道number值不在等于0

        }
        System.out.println(Thread.currentThread().getName() +"\t mission is over，main get value：" +myData.number);
    }
}
