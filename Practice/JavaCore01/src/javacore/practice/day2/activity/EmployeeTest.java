package javacore.practice.day2.activity;

import javacore.practice.day2.model.BackendDevelopment;

import java.util.Scanner;

public class EmployeeTest extends BackendDevelopment {

    public void inputInformation(){
        BackendDevelopment backendDevelopment = new BackendDevelopment();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name:");
        backendDevelopment.setName(scanner.nextLine());
        System.out.println("Enter age:");
        backendDevelopment.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter mark of java:");
        backendDevelopment.setJava(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter mark of spring boot:");
        backendDevelopment.setSprintBoot(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter mark of web Programming:");
        backendDevelopment.setWebProgramming(Float.parseFloat(scanner.nextLine()));
        backendDevelopment.setAverage();

        backendDevelopment.SalaryAmount();
        backendDevelopment.DisplayDetail();
    }

    public static void main(String[] args) {
        EmployeeTest main_test = new EmployeeTest();
        main_test.inputInformation();
    }
}
