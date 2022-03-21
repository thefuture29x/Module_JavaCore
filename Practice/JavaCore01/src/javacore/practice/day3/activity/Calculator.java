package javacore.practice.day3.activity;

public class Calculator {
    private int a =1, b = 2;

    public void setAB(int a,int b){
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        this.a = a;
        this.b = b;
        System.out.println("set A " + a);
        System.out.println("set B " + b);
    }
    public int calculator(){
        System.out.println("calculator" + a+b);
        return a + b;
    }
}
