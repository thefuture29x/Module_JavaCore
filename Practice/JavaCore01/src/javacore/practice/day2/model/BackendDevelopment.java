package javacore.practice.day2.model;

public class BackendDevelopment extends Intership {
    private float plusMark = 0.1F;

    public BackendDevelopment() {
    }

    public BackendDevelopment(String name, int age, float java, float sprintBoot, float webProgramming, float plusMark) {
        super(name, age, java, sprintBoot, webProgramming);
        this.plusMark = plusMark;
    }

    public float getPlusMark() {
        return plusMark;
    }

    public void setPlusMark(float plusMark) {
        this.plusMark = plusMark;
    }

    @Override
    public double SalaryAmount() {
        return (super.SalaryAmount() + this.plusMark);
    }

    @Override
    public void DisplayDetail() {
        super.DisplayDetail();
        super.displayDetail.append("    plus mark:"+this.plusMark);
        System.out.println(displayDetail);
    }
}
