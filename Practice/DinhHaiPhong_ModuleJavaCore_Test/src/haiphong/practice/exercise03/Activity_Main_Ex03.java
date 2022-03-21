package haiphong.practice.exercise03;

import haiphong.practice.exercise03.validation.Valid_Input;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity_Main_Ex03 {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> list_student = new ArrayList<>();
    String file_path = "/Users/admin/Desktop/DinhHaiPhong_ModuleJavaCore_Test/module_javacore_test.dat";
    public void saveToFile(){
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file_path);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            String test = "";
//
//            for (Model_Employee model_empl: list_empl) {
//                test += model_empl.getId_employee() +"\t"+
//                        model_empl.getName() +"\t"+
//                        model_empl.getPhone_number() +"\t"+
//                        model_empl.getAddress() +"\t";
//            }

            byte[] byte_list = list_student.toString().getBytes();
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
    }
    public Student createStudentInformation(int ID_std){
        Student student = new Student();
        Valid_Input valid_input = new Valid_Input();
        String student_id ="";
        String student_name ="";
        String student_score ="";
        boolean check_id = false;
        boolean check_name = false;
        boolean check_score = false;

        if (ID_std == 0){
            do {
                System.out.println("Enter student ID: ");
                student_id = scanner.nextLine();
                if (valid_input.validNumber(student_id)){

//                    for (int i = 0; i<list_student.size();i++){
//                        if (list_student.get(i).getId() == Integer.parseInt(student_id)){
//                            System.out.println("Duplicate id !");
//
//                        }else {
                            student.setId(Integer.parseInt(student_id));
                            check_id = true;
//                        }
//                    }


                }
            }while (check_id == false);
        }else {
            student.setId(ID_std);
        }


        do {
            System.out.println("Enter student name: ");
            student_name = scanner.nextLine();
            if (valid_input.validString(student_name)){
                student.setName(student_name);
                check_name = true;
            }
        }while (check_name == false);

        do {
            System.out.println("Enter student score: ");
            student_score = scanner.nextLine();
            if (valid_input.validNumber(student_score)){
                if (Integer.parseInt(student_score) >=1 &&Integer.parseInt(student_score) <= 10){
                    student.setScore(Integer.parseInt(student_score));
                    check_score = true;
                }else {
                    System.out.println("The score must less than 10 and greater than 1");
                }

            }
        }while (check_score == false);

        saveToFile();
        return student;
    }
    public void updateStudentWithID(){
        System.out.println("Enter ID student want update");
        boolean check = false;
        int id_input = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i<list_student.size();i++){
            if (list_student.get(i).getId() == id_input){
                list_student.set(i,createStudentInformation(id_input));
                check = true;
            }
        }
        if (check == false){
            System.out.println("Can not find the student ");
        }
        saveToFile();

    }
    public void deleteStudentWithID(){
        System.out.println("Enter ID student want delete");
        boolean check = false;
        int id_input = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i<list_student.size();i++){
            if (list_student.get(i).getId() == id_input){
                list_student.remove(i);
                check = true;
            }
        }
        if (check == false){
            System.out.println("Can not find the student ");
        }
        saveToFile();
    }
    public void findAndDisplayStudentWithID(){
        System.out.println("Enter ID student want find");
        boolean check = false;
        int id_input = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i<list_student.size();i++){
            if (list_student.get(i).getId() == id_input){
                System.out.println(list_student.toString());
                check = true;
            }
        }
        if (check == false){
            System.out.println("Can not find the student ");
        }
    }
    public void findStudentHasScoreGreateThan5(){
        for (int i = 0; i<list_student.size();i++){
            if (list_student.get(i).getScore() > 5){
                System.out.println(list_student.get(i).toString());
            }
        }

    }
    public void findStudentHasScoreGreateThan1AndLessThan10(){
        for (int i = 0; i<list_student.size();i++){
            if (list_student.get(i).getScore()>=1 && list_student.get(i).getScore() <= 5 ){
                System.out.println(list_student.get(i).toString());
            }
        }

    }
    public void menu(){
        boolean main_run = true;
        while (main_run) {
            int num_menu_choose = 0;
            boolean check_number = true;
            do {
                System.out.println("------------------------------");
                System.out.println("0. Show all Student information");
                System.out.println("1. Create new Student information");
                System.out.println("2. Update Student information with id student");
                System.out.println("3. Delete Student information with id student");
                System.out.println("4. Find and display Student information with id student");
                System.out.println("5. Find the Student with score greater than 5");
                System.out.println("6. Find the Student with score less than or equal to 5");
                System.out.println("7. Stop !");
                try {
                    num_menu_choose = Integer.parseInt(scanner.nextLine());
                    switch (num_menu_choose) {
                        case 0:
                            for (Student student : list_student) {
                                System.out.println(student.toString());
                            }
                            break;
                        case 1:
                            list_student.add(createStudentInformation(0));
                            break;
                        case 2:
                            updateStudentWithID();
                            break;
                        case 3:
                            deleteStudentWithID();
                            break;
                        case 4:
                            findAndDisplayStudentWithID();
                            break;
                        case 5:
                            findStudentHasScoreGreateThan5();
                            break;
                        case 6:
                            findStudentHasScoreGreateThan1AndLessThan10();
                            break;
                        case 7:
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Invalid selection !");
                            break;
                    }
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Number format exception !");
                    check_number = false;
                }

            } while (check_number = false);
        }
    }

    public static void main(String[] args) {
        Activity_Main_Ex03 ex02 = new Activity_Main_Ex03();
        ex02.menu();
    }

}
