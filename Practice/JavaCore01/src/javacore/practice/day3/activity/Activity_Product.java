package javacore.practice.day3.activity;

import javacore.practice.day3.model.Product;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Activity_Product {
    Scanner scanner = new Scanner(System.in);
//    final String FILE_URL = "http://upload.wikimedia.org/wikipedia/commons/9/9c/Image-Porkeri_001.jpg";
    String FILE_URL = "";
    String FOLDER_NAME = "/Users/admin/Documents/JAVA/JavaCore01/src/Image_Picture/";


    public void createProduct(){
        Product product = new Product();
        System.out.println("Enter product ID: ");
        product.setId_product(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter product name: ");
        product.setName(scanner.nextLine());
        System.out.println("Enter product price: ");
        product.setPrice(scanner.nextLine());
        System.out.println("Enter product picture: ");
        FILE_URL = scanner.nextLine();
        product.setPicture_url(FILE_URL);

        downloadPictureWithURL(FILE_URL,FOLDER_NAME);
        product.setPicture_name(FilenameUtils.getName(FILE_URL));

        product.toString();

    }

    public void downloadPictureWithURL(String file_url, String folder_name){
        try (BufferedInputStream in = new BufferedInputStream(new URL(file_url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(folder_name+FilenameUtils.getName(file_url))) {

            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
        }
        System.out.println("Insert successful !");
    }

    public void updatePicture(){

    }
    public void deletePicture(String picture_name){
        File myObj = new File(FOLDER_NAME+ picture_name);
        if (myObj.exists()){
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        }else{
            System.out.println("File not exists");
        }

    }

    public static void main(String[] args) {
        Activity_Product main_run = new Activity_Product();
//        main_run.createProduct();
        main_run.deletePicture("Image-Porkeri_001.jpg");
    }
}
