package javacore.practice.day3.activity;

public class Activity_Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println("Thread test 2 :" + i);
            System.out.println("Thread test 2 :" + Thread.currentThread().getId() + " is running");
        }
        System.out.println("Thread test 2 :"+ Thread.currentThread().getId() + " is stop");
    }
}
