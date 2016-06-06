package com.nabivach.parse_data;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by grey3 on 06.06.2016.
 * separate Java app which should read files content, generate SQL, and execute it on concrete DB.
 */
public class parseDataFiles {

    public static void readFileByLine(String fileName) {
        try {
            File file = new File("C:/Users/grey3/Downloads/"+fileName);
            //File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
