package com.example.nettydemo.Interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:compareAndSet  比较并交换
 */
public class CASDamo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data : "+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data : "+atomicInteger.get());
    }
}
