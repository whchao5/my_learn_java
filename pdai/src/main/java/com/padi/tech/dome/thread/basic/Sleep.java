package com.padi.tech.dome.thread.basic;

public class Sleep {
    private int i = 10;
    private Object object = new Object();

    public class MyRunnable implements Runnable {
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)  {
        System.out.printf("Ok");
        Sleep sleep = new Sleep();
        MyRunnable instance =  sleep.new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();

        System.out.printf("Ok");

//        new Thread(() => {
//
//        })


//        MyThread thread1 = sleep.new MyThread();
//        MyThread thread2 = sleep.new MyThread();
//        thread1.start();
//        thread2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
            }
        }).start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }
}
