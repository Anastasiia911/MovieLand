package com.nabivach.parse_data_temp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by grey3 on 06.06.2016.
 * separate Java app which should read files content, generate SQL, and execute it on concrete DB.
 */
public class parseDataFiles {
    public static void main(String[] args) {
   // public static void readFileByLine(String fileName) {
        System.setProperty("file.encoding", "UTF-8");
        String file_location = "C:/Users/anabivach/Desktop/JAVA/PRACTICE MOVIE_LAND";
        File file = new File(file_location+"/genre.txt");
        File file1 = new File(file_location+"/movie.txt");
        File file2 = new File(file_location+"/review.txt");
        File file3 = new File(file_location+"/user.txt");
        System.out.println(file.exists() && file1.exists()&& file2.exists()&& file3.exists());


        try {

            Scanner scanner  = new Scanner(file,"UTF-8");
            Scanner scanner1 = new Scanner(file1,"UTF-8");
            Scanner scanner2 = new Scanner(file2,"UTF-8");
            Scanner scanner3 = new Scanner(file3,"UTF-8");
            System.out.println(scanner.hasNext());
            if (scanner.hasNextLine()) {
                scanner.useDelimiter("//n");
                String s1=scanner.next();
              // PERFORM INSERT INTO CORRESPONDING TABLES IN DB
              System.out.println(s1);
            }
            else System.out.println("Nothing to read");

            //  scanner.close();
            System.out.println("Start reading from file1");
           while (scanner1.hasNext()) {

                // PERFORM INSERT INTO CORRESPONDING TABLES IN DB
               System.out.println(scanner1.next());
            }
          //  scanner1.close();

            System.out.println("Start reading from file2");
            while (scanner2.hasNext()) {

                // PERFORM INSERT INTO CORRESPONDING TABLES IN DB
                System.out.println(scanner2.next());
            }
        //    scanner2.close();


            System.out.println("Start reading from file2");
            while (scanner2.hasNext()) {
                // PERFORM INSERT INTO CORRESPONDING TABLES IN DB
                System.out.println(scanner3.next());
            }
            scanner.close();
            scanner1.close();
            scanner2.close();
            scanner3.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
