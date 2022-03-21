package javacore.practice.day2.activity;

import javacore.practice.day2.model.Model_WaterMoney;
import javacore.practice.day2.validation.Valid_Input;

import java.util.*;

public class Main_WaterMoney {
    ArrayList<Model_WaterMoney> list_model = new ArrayList<>();
    Valid_Input valid_input = new Valid_Input();
    HashMap sum_modelWM = new HashMap();
    public void setSum_waterMoney(){
        int sum_useNumber = 0;
        int sum_waterMoney = 0;
        int sum_surcharge = 0;
        int sum_mustPay = 0;

        for (Model_WaterMoney md_wm: list_model) {
            sum_useNumber += md_wm.getUse_number();
            sum_waterMoney += md_wm.getWater_money();
            sum_surcharge += md_wm.getSurcharge();
            sum_mustPay += md_wm.getMust_pay();
        }
        sum_modelWM.put("sum_useNumber",sum_useNumber);
        sum_modelWM.put("sum_waterMoney",sum_waterMoney);
        sum_modelWM.put("sum_surcharge",sum_surcharge);
        sum_modelWM.put("sum_mustPay",sum_mustPay);


    }
    public void inputInformation(){
        System.out.println("----------------------------");
        System.out.println("Input information !");
        Scanner sc = new Scanner(System.in);
        int number_of_list = 0;
        boolean check_number = true;
        do {
            System.out.println("Enter number of list ");
            try{
                number_of_list = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException numberFormatException){
                System.out.println("Number format exception !");
                check_number = false;
            }
        }while (check_number == false);
        for (int i = 0; i<number_of_list;i++){
            setWaterMoney();
        }
    }
    public void setWaterMoney(){
        Model_WaterMoney md_money = new Model_WaterMoney();
        String owner = "";
        String old_number = "";
        String new_number = "";
        boolean check_owner = false;
        boolean check_oldNumber = false;
        boolean check_newNumber = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------");

        do {
            System.out.println("Input owner name: ");
            owner = scanner.nextLine();
            if (valid_input.validString(owner)){
                md_money.setOwner(owner);
                check_owner = true;
            }
        }while (check_owner == false);

        do {
            System.out.println("Input old number: ");
            old_number = scanner.nextLine();
            if (valid_input.validNumber(old_number)){
                md_money.setOld_number(Integer.parseInt(old_number));
                check_oldNumber = true;
            }
        }while (check_oldNumber == false);


        do {
            System.out.println("Input new number: ");
            new_number = scanner.nextLine();
            if (valid_input.validNumber(new_number)){
                if (Integer.parseInt(new_number) < Integer.parseInt(old_number)){
                    System.out.println("The new number must be greater than the old number !");
                }else {
                    md_money.setNew_number(Integer.parseInt(new_number));
                    check_newNumber = true;
                }
            }
        }while (check_newNumber == false);

        md_money.setUse_number(calculateUseNumber(md_money.getOld_number(),md_money.getNew_number()));
        md_money.setWater_money(calculateWaterMoney(md_money.getUse_number()));
        md_money.setSurcharge(calculateSurcharge(md_money.getWater_money()));
        md_money.setMust_pay(calculateMustPay(md_money.getUse_number()));

        list_model.add(md_money);


    }
    public void showListWaterMoney(){
        for (Model_WaterMoney md_wm: list_model) {
            md_wm.showInfor();
        }
    }
    public int calculateUseNumber(int old_number,int new_number){
        return new_number - old_number;
    }
    public int calculateWaterMoney(int use_number){
        if (use_number <= 50){
            return use_number*100;
        }else if (50 < use_number && use_number <= 100){

            return 5000 + (use_number - 50)*150;
        }else {
            return 12500 + (use_number - 100)*200;
        }
    }
    public int calculateSurcharge(int water_money){
        if (water_money <= 50){
            return water_money*2/100;
        }else if (50 < water_money && water_money <= 100){
            return water_money*3/100;
        }else {
            return water_money*5/100;
        }
    }
    public int calculateMustPay(int useNumber){
        return calculateWaterMoney(useNumber) + calculateSurcharge(calculateWaterMoney(useNumber));
    }
    public void menu(){
        boolean main_run = true;
        while (main_run){
            Scanner scanner_menu = new Scanner(System.in);
            boolean check_number = true;
            int number_of_list = 0;
            do {
                System.out.println("--------------------------------");
                System.out.println("1. Enter information of list WaterMoney ");
                System.out.println("2. Display information of list WaterMoney");
                System.out.println("3. Display the total of WaterMoney");
                System.out.println("4. Find the customer with the highest amount of money to pay");
                System.out.println("5. Find the customer with the least amount of money to pay");
                System.out.println("6. Exit !");
                try{
                    number_of_list = Integer.parseInt(scanner_menu.nextLine());
                    switch (number_of_list){
                        case 1:
                            inputInformation();
                            menu();
                            break;
                        case 2:
                            showListWaterMoney();
                            menu();
                            break;
                        case 3:
                            setSum_waterMoney();
                            System.out.println(sum_modelWM.toString());
                            break;
                        case 4:
                            Model_WaterMoney modelWaterMoney = list_model.stream().max(Comparator.comparing(Model_WaterMoney::getMust_pay)).get();
                            System.out.println(modelWaterMoney);
                            break;
                        case 5:
                            Model_WaterMoney modelWaterMoney2 = list_model.stream().min(Comparator.comparing(Model_WaterMoney::getMust_pay)).get();
                            System.out.println(modelWaterMoney2);
                            break;
                        case 6:
                            System.exit(0);
                            break;
                        default:
                            System.err.println("Invalid selection !");
                            break;


                    }
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Number format exception !");
                    check_number = false;
                }
            }while (check_number == false);
        }


    }

    public static void main(String[] args) {
        Main_WaterMoney main = new Main_WaterMoney();
        main.menu();
    }
}
