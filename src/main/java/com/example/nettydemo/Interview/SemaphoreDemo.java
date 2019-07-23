package com.example.nettydemo.Interview;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Semaphore
 * @Description TODO
 * @Date 2019/7/23 15:43
 * @Author lyn
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开车位");

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
