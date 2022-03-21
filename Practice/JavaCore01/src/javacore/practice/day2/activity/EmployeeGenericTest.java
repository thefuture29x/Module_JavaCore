package javacore.practice.day2.activity;

import javacore.practice.day2.model.BackendDevelopment;
import javacore.practice.day2.model.Employee;

import java.util.Scanner;

public class EmployeeGenericTest extends Employee{
    public void inputInformation(){
        Employee employee = new Employee();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name:");
        employee.setName(scanner.nextLine());
        System.out.println("Enter age:");
        employee.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter mark of java:");
        employee.setJava(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter mark of spring boot:");
        employee.setSprintBoot(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter mark of web Programming:");
        employee.setWebProgramming(Float.parseFloat(scanner.nextLine()));
        employee.setAverage();

        employee.SalaryAmount();
        employee.DisplayDetail();
    }

    public static void main(String[] args) {
        EmployeeGenericTest genericTest = new EmployeeGenericTest();
        genericTest.inputInformation();
    }
}
