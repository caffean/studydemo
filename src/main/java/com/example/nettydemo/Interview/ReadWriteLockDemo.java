package com.example.nettydemo.Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class myCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void put(String key , Object value){

        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (Exception e){e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成："+key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.writeLock().unlock();
        }

    }

    public void get(String key){
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取："+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (Exception e){e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }


    }
}

/**
 * @Classname ReadWriteLockDemo
 * @Description 读写锁
 * @Date 2019/7/23 10:53
 * @Author lyn
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        myCache myCache = new myCache();

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
