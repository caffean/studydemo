package com.example.nettydemo.Interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Classname BlockingQueueDemo
 * @Description
 * @Date 2019/7/23 16:20
 * @Author lyn
 *
 * 1.队列：
 * 2.阻塞队列：
 *  2.1：阻塞队列有没有好的一面
 *
 *  2.2：不得不阻塞，你如何管理
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //System.out.println(blockingQueue.add("a"));
        //System.out.println(blockingQueue.add("b"));
        //System.out.println(blockingQueue.add("c"));
        //
        //
        //System.out.println(blockingQueue.element());
        //
        //
        //System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());


        System.out.println(blockingQueue.offer("1"));
        System.out.println(blockingQueue.offer("2"));
        System.out.println(blockingQueue.offer("3"));
        System.out.println(blockingQueue.offer("4"));

    }
}
