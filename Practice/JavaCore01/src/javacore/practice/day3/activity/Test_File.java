package javacore.practice.day3.activity;

import javacore.practice.day3.model.Model_Employee;
import javacore.practice.wagu.Block;
import javacore.practice.wagu.Board;
import javacore.practice.wagu.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Test_File {
    ArrayList<Model_Employee> list_empl = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String file_path = "/Users/admin/Documents/JAVA/JavaCore01/day3_activity_employee.dat";

    public void addEmployee(){
        Model_Employee employee = new Model_Employee();
        System.out.println("Enter employee id");
        employee.setId_employee(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter employee name");
        employee.setName(scanner.nextLine());
        System.out.println("Enter employee phone number");
        employee.setPhone_number(scanner.nextLine());
        System.out.println("Enter employee address");
        employee.setAddress(scanner.nextLine());

        list_empl.add(employee);
        writeFile();
//        createFile();
    }
    public void createFile(){

        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file_path);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            String test = "";

            for (Model_Employee model_empl: list_empl) {
                test += model_empl.getId_employee() +"\t"+
                        model_empl.getName() +"\t"+
                        model_empl.getPhone_number() +"\t"+
                        model_empl.getAddress() +"\t";
            }
            byte[] byte_list = test.getBytes();
            try {
                bufferedOutputStream.write(byte_list);
                bufferedOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        readFile();

    }
    public void writeFile(){
        List<String> headersList = Arrays.asList("ID", "NAME", "PHONENUMBER", "ADDRESS");
        List<List<String>> rowsList = Arrays.asList(
//                Arrays.asList().forEach() ;
        );
        List<String> list_modle = Arrays.asList();

        for (Model_Employee model_employee :list_empl) {
            Arrays.asList(""+model_employee.getId_employee(),
                    ""+model_employee.getName(),
                    ""+model_employee.getPhone_number(),
                    ""+model_employee.getAddress());
        }

//                Arrays.asList(
//
////                Arrays.asList("Id test","Name test","Phone number","Address test")
////                Arrays.asList(list_empl.get(0).getId_employee(),""+this.age,""+this.java,""+this.sprintBoot),
//                Arrays.asList(list_empl.toString())
//
//
//        );
        Board board = new Board(85);
        Table table = new Table(board, 85, headersList, rowsList);
        table.setGridMode(Table.GRID_COLUMN);
        //setting width and data-align of columns
        List<Integer> colWidthsList = Arrays.asList(20, 20, 20, 20);
        List<Integer> colAlignList = Arrays.asList(Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER);
        table.setColWidthsList(colWidthsList);
        table.setColAlignsList(colAlignList);

        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        String tableString = board.getPreview();
//        System.out.println(tableString);

        readFile();
        try {
            FileWriter new_fileWriter = new FileWriter(file_path);
            new_fileWriter.write(tableString);
            new_fileWriter.close();
        }catch (IOException ioException){
            System.out.println("An error occurred.");
            ioException.printStackTrace();
        }
    }
    public void readFile(){
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file_path));
            int i = 0;
            while (true) {
                try {
                    if (!((i = bufferedInputStream.read()) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print((char)i);
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        Test_File test_file = new Test_File();
////        test_file.readFile();
//        for (int i = 0; i<1;i++){
//            test_file.addEmployee();
//        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(9);
        Consumer<Integer> consumer = n ->{
            System.out.println(n);
        };
        list.forEach(consumer);
    }
}
