package com.yize.design;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadPrint {
    private ReentrantLock lock=new ReentrantLock();
    private Condition lock1=lock.newCondition();
    private Condition lock2=lock.newCondition();
    private Condition lock3=lock.newCondition();
    private int count=0;
    @Test
    public void test(){
        Thread thread1=new Thread(new Thread1());
        Thread thread2=new Thread(new Thread2());
        Thread thread3=new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
        while (true);


    }


    class Thread1 implements Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    Thread.sleep(300);

                    while (count%3!=0){
                        lock1.await();
                    }
                    System.out.println("A");
                    count++;
                }catch (Exception e){
                    System.out.println(e.getCause());
                }finally {
                    lock2.signal();
                    lock.unlock();
                }
            }
        }
    }

    class Thread2 implements Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    Thread.sleep(300);

                    while (count%3!=1){
                        lock2.await();
                    }
                    System.out.println("B");
                    count++;
                }catch (Exception e){
                    System.out.println(e.getCause());
                }finally {
                    lock3.signal();
                    lock.unlock();
                }
            }
        }
    }

    class Thread3 implements Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                   Thread.sleep(300);
                    while (count%3!=2){
                        lock3.await();
                    }
                    System.out.println("C");
                    count++;
                }catch (Exception e){
                    System.out.println(e.getCause());
                }finally {
                    lock1.signal();
                    lock.unlock();
                }
            }
        }
    }
}
