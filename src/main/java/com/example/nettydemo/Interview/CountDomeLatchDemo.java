package com.example.nettydemo.Interview;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname CountDomeLatchDemo
 * @Description 倒计时 减到0开始
 * @Date 2019/7/23 14:58
 * @Author lyn
 */
public class CountDomeLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//主线程等待其他线程全部完成再开始  countDownLatch减到0开始

        System.out.println(Thread.currentThread().getName()+"\t ****************秦帝国，一统华夏");



    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName()+"\t ****************班长最后关门走人");
    }
}
