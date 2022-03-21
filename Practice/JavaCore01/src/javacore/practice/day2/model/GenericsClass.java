package javacore.practice.day2.model;

public class GenericsClass <T>{
    private T number_one;
    private T number_two;

    public GenericsClass(T number_one, T number_two) {
        this.number_one = number_one;
        this.number_two = number_two;
    }

    public T getNumber_one() {
        return number_one;
    }

    public void setNumber_one(T number_one) {
        this.number_one = number_one;
    }

    public T getNumber_two() {
        return number_two;
    }

    public void setNumber_two(T number_two) {
        this.number_two = number_two;
    }
}
