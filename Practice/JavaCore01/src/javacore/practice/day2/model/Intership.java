package javacore.practice.day2.model;

import javacore.practice.day2.impl.IIntership;

public class Intership implements IIntership {
    private String name;
    private int age;
    private float java;
    private float sprintBoot;
    private float webProgramming ;
    private float average;
    StringBuilder displayDetail = new StringBuilder();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getJava() {
        return java;
    }

    public void setJava(float java) {
        this.java = java;
    }

    public float getSprintBoot() {
        return sprintBoot;
    }

    public void setSprintBoot(float sprintBoot) {
        this.sprintBoot = sprintBoot;
    }

    public float getWebProgramming() {
        return webProgramming;
    }

    public void setWebProgramming(float webProgramming) {
        this.webProgramming = webProgramming;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage() {
        this.average = ((this.java + this.sprintBoot + this.webProgramming)/3);
    }

    public Intership(String name, int age, float java, float sprintBoot, float webProgramming) {
        this.name = name;
        this.age = age;
        this.java = java;
        this.sprintBoot = sprintBoot;
        this.webProgramming = webProgramming;
    }

    public Intership() {
    }

    @Override
    public double SalaryAmount() {
        if (this.average >=7 && this.average <8){
            return 1500000;
        }else if (this.average >=8 && this.average <9){
            return 3000000;
        }else if (this.average >=9){
            return 5000000;
        }else {
            return 0;
        }
    }

    @Override
    public void DisplayDetail() {
        displayDetail.append("  name:" + this.name);
        displayDetail.append("  age:" + this.age);
        displayDetail.append("  mark of java:" + this.java);
        displayDetail.append("  mark of spring boot:" + this.sprintBoot);
        displayDetail.append("  mark of web programing:" + this.webProgramming);
        displayDetail.append("  average:" + this.average);
        displayDetail.append("  salary:" + this.SalaryAmount());
    }

}
