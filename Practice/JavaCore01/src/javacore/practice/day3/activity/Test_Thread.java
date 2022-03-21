package javacore.practice.day3.activity;

public class Test_Thread {
    public static void main(String[] args) {
//        Activity_Thread1 activity_thread1 = new Activity_Thread1();
//        Thread thread1 = new Thread(activity_thread1);
//
//
//        Activity_Thread2 activity_thread2 = new Activity_Thread2();
//
//        thread1.start();
//        activity_thread2.run();


        Calculator calculator = new Calculator();
        Thread thread1 = new Thread(){

            @Override
            public void run() {
                super.run();
                synchronized (calculator){
                    calculator.setAB(10,20);
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (calculator){
                    System.out.println("Thread 2: "+calculator.calculator());
                }
            }
        };

        thread1.setPriority(1);
        thread1.setPriority(10);
        thread1.start();
        thread2.start();
    }
}
