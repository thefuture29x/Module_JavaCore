package javacore.practice.day2.model;

import javacore.practice.day2.impl.IEmployee;
import javacore.practice.wagu.Block;
import javacore.practice.wagu.Board;
import javacore.practice.wagu.Table;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Employee implements IEmployee<Float> {
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



    @Override
    public Float SalaryAmount() {
        if (this.average >=7 && this.average <8){
            return 1500000F;
        }else if (this.average >=8 && this.average <9){
            return 3000000F;
        }else if (this.average >=9){
            return 5000000F;
        }else {
            return 0F;
        }
    }

    @Override
    public void DisplayDetail() {
        List<String> headersList = Arrays.asList("NAME", "AGE", "JAVA", "SpringBoot","WebPrograming","AVERAGE", "SALARY(VND)");
        List<List<String>> rowsList = Arrays.asList(
                Arrays.asList(this.name,""+this.age,""+this.java,""+this.sprintBoot,""+this.webProgramming,""+this.average,""+SalaryAmount())
        );
        Board board = new Board(148);
        Table table = new Table(board, 148, headersList, rowsList);
        table.setGridMode(Table.GRID_COLUMN);
        //setting width and data-align of columns
        List<Integer> colWidthsList = Arrays.asList(20, 20, 20, 20, 20, 20, 20);
        List<Integer> colAlignList = Arrays.asList(Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER);
        table.setColWidthsList(colWidthsList);
        table.setColAlignsList(colAlignList);

        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        String tableString = board.getPreview();
        System.out.println(tableString);
        try {
            FileWriter new_fileWriter = new FileWriter("/Users/admin/Documents/JAVA/JavaCore01/day2_activity_EmployeeGenericTest.txt");
            new_fileWriter.write(tableString);
            new_fileWriter.close();
        }catch (IOException ioException){
            System.out.println("An error occurred.");
            ioException.printStackTrace();
        }

    }



}
