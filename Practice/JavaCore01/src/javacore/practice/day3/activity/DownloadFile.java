package javacore.practice.day3.activity;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DownloadFile {
    public void downloadFile(){
        boolean run = true;
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        while (run){
            System.out.println("Enter url link: ");

            do {
                stringBuilder.append(scanner.next());
                if (!stringBuilder.toString().contains("http")){
                    System.out.println("Invalid image url!, please enter again");
                    stringBuilder.setLength(0);
                }
            }while (stringBuilder.length() == 0);
            String uploadImage = downloadFunction(stringBuilder.toString());

            if (uploadImage == null){
                System.out.println("Cannot download this image");
            }else {
                System.out.println("Downloaded Successfully ! \n Here is path :" +
                        new File(uploadImage).getAbsoluteFile());
            }
            System.out.println("Do you want exit ? (y/n)");
            stringBuilder.setLength(0);
            do {
                stringBuilder.append(scanner.next());
            }while (stringBuilder.length() == 0);
            if (!stringBuilder.toString().equalsIgnoreCase("n")){
                System.out.println("Exited successfully! code: 0");
                run = false;
            }
            scanner.close();
        }
    }
    public String downloadFunction(String imgUrl){
        StringBuilder sb = new StringBuilder();
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") +1);

        String imgFolderPath = "Image_Picture";
        File imgFolder = new File(imgFolderPath);
        if (!imgFolder.exists()){
            imgFolder.mkdir();
        }
        URL url = null;
        InputStream in = null;
        OutputStream out = null;


        try {
            url = new URI(imgUrl).toURL();
            URLConnection urlConnection = url.openConnection();
            if (urlConnection.getContentType().contains("text/plain")){
                return null;
            }
            sb.append(imgFolderPath).append("/").append(fileName);
            File fileImg = new File(sb.toString());

            if (fileImg.exists()){
                for (int i =0;;i++){
                    sb.setLength(0);
                    sb.append(imgFolderPath).append("/").append(fileName);
                    fileImg = new File(sb.toString());
                    if (!fileImg.exists()){
                        break;
                    }
                }
            }
            in = urlConnection.getInputStream();
            out = new FileOutputStream(fileImg);
            out.write(in.readAllBytes());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new DownloadFile().downloadFile();
    }

}
