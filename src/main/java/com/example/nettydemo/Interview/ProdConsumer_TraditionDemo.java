package com.example.nettydemo.Interview;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ProdConsumer_TraditionDemo
 * @Description TODO
 * @Date 2019/7/23 18:05
 * @Author lyn
 *
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 * 1 线程    操作（方法）   资源类
 * 2 判断    干活       通知
 * 3
 */

class ShareData{
    private int number =0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            //1 判断
            while (number != 0){
                //等待，不能生产
                condition.await();
            }
            //2 干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3 通知唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }


    }

    public void decrement() throws Exception{
        lock.lock();
        try {
            //1 判断
            while (number == 0){
                //等待，不能生产
                condition.await();
            }
            //2 干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3 通知唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }


    }


}

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"AAA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"BBB").start();
    }
}
