package javacore.practice.day3.activity;

public class Activity_Thread1 extends Thread{
    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println("Thread test 1 :" + i);
            System.out.println("Thread test 1 :" + Thread.currentThread().getId() + " is running");
        }
        System.out.println("Thread test 1 :"+ Thread.currentThread().getId() + " is stop");
    }
}
