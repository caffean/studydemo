package com.example.nettydemo.Interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname CallableDemo
 * @Description TODO
 * @Date 2019/7/24 14:17
 * @Author lyn
 */
//class MyThread implements Runnable{
//
//    @Override
//    public void run() {
//
//    }
//}

class MyThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"**************come in Callable");
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread());
        Thread t1 = new Thread(futureTask, "AA");
        Thread t2 = new Thread(futureTask1, "BB");
        t1.start();
        t2.start();
        int result1 = 100;
        while(!futureTask.isDone()){

        }
        int result2 = futureTask.get();//get方法如无比较建议放在最后  要求获得callable线程的最后结果，如果没有计算完成就获取结果，会导致阻塞，直到计算完成

        System.out.println("*********reslut" + (result1+result2));

    }
}
