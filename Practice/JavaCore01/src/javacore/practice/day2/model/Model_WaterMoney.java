package javacore.practice.day2.model;

public class Model_WaterMoney {

    private String owner;
    private int old_number;
    private int new_number;
    private int use_number;
    private int water_money;
    private int surcharge;
    private int must_pay;

    public Model_WaterMoney() {
    }

    public Model_WaterMoney(String owner, int old_number, int new_number) {
        this.owner = owner;
        this.old_number = old_number;
        this.new_number = new_number;
    }

    public int getUse_number() {
        return use_number;
    }

    public void setUse_number(int use_number) {
        this.use_number = use_number;
    }

    public int getWater_money() {
        return water_money;
    }

    public void setWater_money(int water_money) {
        this.water_money = water_money;
    }

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    public int getMust_pay() {
        return must_pay;
    }

    public void setMust_pay(int must_pay) {
        this.must_pay = must_pay;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getOld_number() {
        return old_number;
    }

    public void setOld_number(int old_number) {
        this.old_number = old_number;
    }

    public int getNew_number() {
        return new_number;
    }

    public void setNew_number(int new_number) {
        this.new_number = new_number;
    }

    @Override
    public String toString() {
        return "Model_WaterMoney{" +
                "owner='" + owner + '\'' +
                ", old_number=" + old_number +
                ", new_number=" + new_number +
                ", use_number=" + use_number +
                ", water_money=" + water_money +
                ", surcharge=" + surcharge +
                ", must_pay=" + must_pay +
                '}';
    }
    public void showInfor(){
        System.out.println(toString());
    }
}
