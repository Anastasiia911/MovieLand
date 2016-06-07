package com.nabivach.parse_data_temp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by grey3 on 06.06.2016.
 * separate Java app which should read files content, generate SQL, and execute it on concrete DB.
 */
public class parseDataFiles {
    public static void main(String[] args) throws Exception {
  //  public  String  getArrayofFileLines() {
        String fileName="genre.txt";
        String file_location = "C:/";
        String tableName = "GENRE";
       // ("genre.txt","movie.txt","review.txt","user.txt");

        dbCreateConnection statemnt = new dbCreateConnection();
        File file = new File(file_location+fileName);
        System.out.println(file.exists()); //&& file1.exists()&& file2.exists()&& file3.exists());
        List list = new ArrayList();

        try {

            Scanner scanner  = new Scanner(file,"UTF-8");
            System.out.println(scanner.hasNext());

                //GENERATE SET OF SQL QUERIES
                while (scanner.hasNextLine()){
                    scanner.useDelimiter("//n");
                    String s1 = scanner.next();

                    String query = "INSERT INTO " + tableName +" (genre)"+ " VALUES" + " (" + "'" + s1 + "'" + ");";

                    System.out.println(query);
            }

            scanner.close();
                } catch (Exception e) {
                    e.printStackTrace();

        }
    //return list;

    }}
//}


