package javacore.practice.day3.model;

public class Model_Employee {
    private int id_employee;
    private String name;
    private String phone_number;
    private String address;

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Model_Employee(int id_employee, String name, String phone_number, String address) {
        this.id_employee = id_employee;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Model_Employee() {
    }
}
