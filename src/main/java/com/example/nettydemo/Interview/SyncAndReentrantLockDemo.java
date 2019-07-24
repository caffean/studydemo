package com.example.nettydemo.Interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname SyncAndReentrantLockDemo
 * @Description TODO
 * @Date 2019/7/24 11:14
 * @Author lyn
 *
 * 题目： 多线程之间按顺序调用 实现a》b》c 三个线程启动要求如下：
 * aa 打印5次 ，bb打印10次 ，cc打印15次
 * 。。。。。。
 * 来15轮
 */
class shareResource{
    private  int number = 1;// a:1,b:2,c:3
    
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print5(){
        lock.lock();
        try {
            //1.判断
            while (number !=1){
                c1.await();
            }
            //2.干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            number = 2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void print10(){
        lock.lock();
        try {
            //1.判断
            while (number !=2){
                c1.await();
            }
            //2.干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            number = 3;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void print15(){
        lock.lock();
        try {
            //1.判断
            while (number !=3){
                c1.await();
            }
            //2.干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            number = 1;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    

}

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        shareResource shareResource = new shareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"c").start();
    }
}
