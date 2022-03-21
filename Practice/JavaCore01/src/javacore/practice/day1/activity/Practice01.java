package javacore.practice.day1.activity;

import javacore.practice.day2.model.GenericsClass;

public class Practice01 {

    public static void main(String[] args) {
//        int[] numbers = {3,4,10,4,5,6,4,2,4,5,6};
//        for (int i = 0;i < numbers.length; i++){
//            for (int j = i+1; j<numbers.length; j++){
//                int tmp = 0;
//                if(numbers[i] >= numbers[j]){
//                    tmp = numbers[j];
//                    numbers[j] = numbers[i];
//                    numbers[i] = tmp;
//
//
//                }
//            }
//        }
//
//        for (int i = 0;i <numbers.length;i++){
//            System.out.println(numbers[i]);
//        }

//        List list = new ArrayList();
//        list.add("add");
//        list.add((5));
//
//        for (Object obj: list) {
//            String str = (String) obj;
//        }

        GenericsClass<Integer> sum_twoNumber = new GenericsClass<>(12,4);
        System.out.println("Sum: " + sum_twoNumber.getNumber_one() + sum_twoNumber.getNumber_two());

        GenericsClass<String> concat_twoNumber = new GenericsClass<>("hai","ba");
        System.out.println("Concat " + concat_twoNumber.getNumber_one() + concat_twoNumber.getNumber_two());
    }

}
