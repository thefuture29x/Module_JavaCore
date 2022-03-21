package haiphong.practice.exercise01;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Scanner;

public class Activity_Main_Ex01 {
    String FOLDER_NAME = "/Users/admin/Desktop/DinhHaiPhong_ModuleJavaCore_Test/Picture";

    public void downloadPicture(String picture_url){
        try (BufferedInputStream in = new BufferedInputStream(new URL(picture_url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(FOLDER_NAME+ getPictureName(picture_url))) {

            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {

        }
        System.out.println("Insert successful !");
    }
    public String getPictureName(String url_picture){
        String picture_name = "";
        for (int i = url_picture.lastIndexOf("/");i<url_picture.length();i++){
            picture_name = url_picture.substring(url_picture.lastIndexOf("/"));
        }
        return picture_name;
    }

    public static void main(String[] args) {
        Activity_Main_Ex01 ex01 = new Activity_Main_Ex01();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter picture URL: ");
        String url_picture = scanner.nextLine();
        ex01.downloadPicture(url_picture);

    }
}
