package com.example.nettydemo.Interview;

import java.security.spec.ECParameterSpec;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Classname CyclicBarrierDemo
 * @Description 与countDownLatch 相反 数值达到一定值才开始
 * @Date 2019/7/23 15:30
 * @Author lyn
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()-> System.out.println("*******召唤神龙"));
        for (int i = 0; i < 7 ; i++) {
            final int tempInt = i;
            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"\t 收集到第："+ tempInt+"龙珠");
                try {
                    cyclicBarrier.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }catch (BrokenBarrierException e){
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
