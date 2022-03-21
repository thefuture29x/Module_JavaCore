package javacore.practice.day2.activity;

import javacore.practice.day2.model.Model_ProductsTest;

public class Demo_Exceptions {
    Model_ProductsTest md_prTest = new Model_ProductsTest();

    public void demo_Execptions() {
        try {
            md_prTest.setPrice(5);
        }catch (NumberFormatException numberFormatException){
            System.out.println("Number format exception");
        }catch (RuntimeException runtimeException){
            System.out.println("Runtime exception");
        }
    }
}
