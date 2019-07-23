package com.example.nettydemo.Interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname Spin
 * @Description TODO
 * @Date 2019/7/23 10:05
 * @Author lyn
 */
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        //当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");

        while (!atomicReference.compareAndSet(null,thread)){
            //System.out.println(Thread.currentThread().getName()+"\t 11111");
        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnLock");
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);

            }catch (Exception e){
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"AA").start();
        try {
            TimeUnit.SECONDS.sleep(1);

        }catch (Exception e){
            e.printStackTrace();
        }
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);

            }catch (Exception e){
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"BB").start();
    }
}
