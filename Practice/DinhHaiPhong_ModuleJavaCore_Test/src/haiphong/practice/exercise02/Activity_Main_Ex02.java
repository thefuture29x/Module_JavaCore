package haiphong.practice.exercise02;

import java.io.*;
import java.util.Scanner;

public class Activity_Main_Ex02 {
    public void copyFile(String src, String dst){
        InputStream is = null;
        OutputStream os = null;
        File source = new File(""+src);
        File dest = new File(""+dst);
        try {
            try {

                is = new FileInputStream(source);
                os = new FileOutputStream(dest);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            byte[] buffer = new byte[1024];
            int length = 0;
            while (true) {
                try {
                    if (!((length = is.read(buffer)) > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os.write(buffer, 0, length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        String dest = "/Users/admin/Desktop/DinhHaiPhong_ModuleJavaCore_Test/Picture/module_javacore_test.dat";
        Activity_Main_Ex02 ex2 = new Activity_Main_Ex02();

        System.out.println("Enter path of file want to copy");
        System.out.println("Suggest: /Users/admin/Desktop/DinhHaiPhong_ModuleJavaCore_Test/module_javacore_test.dat");
        Scanner scanner = new Scanner(System.in);
        String file_path = scanner.nextLine();
        ex2.copyFile(file_path,dest);
        System.out.println("The file has been copied to the directory : /Users/admin/Desktop/DinhHaiPhong_ModuleJavaCore_Test/Picture/");


    }

}
