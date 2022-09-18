package com.padi.tech.dome.thread.key.juc.AtomicInteger;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Demo5 {

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[] { 0, 0 });
        System.out.println(array);
        System.out.println(array.getAndAdd(1, 2));
        System.out.println(array);
    }
}
