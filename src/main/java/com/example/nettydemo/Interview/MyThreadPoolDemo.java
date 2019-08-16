package com.example.nettydemo.Interview;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Classname MyThreadPoolDemo
 * @Description TODO
 * @Date 2019/7/24 15:37
 * @Author lyn
 * 第四种获取使用java多线程的方式 线程池
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //threadPoolInit();


    }

    private static void threadPoolInit() {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程
        //try {
        //    for (int i = 0; i < 10; i++) {
        //        threadPool.execute(()->{
        //            System.out.println(Thread.currentThread().getName()+"\t 办理业务");
        //        });
        //    }
        //    ThreadLocal
        //
        //}catch (Exception e){
        //    e.printStackTrace();
        //}finally {
        //    threadPool.shutdown();
        //}
    }
}
