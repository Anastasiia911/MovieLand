package com.nabivach.parse_data_temp;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by grey3 on 07.06.2016.
 */
public class dbCreateConnection {

    String userName = "postgres";
    String password = "root";
    String db = "movieland";
    String URL = "jdbc:postgresql://127.0.0.1:5432/movieland";
    String filename="genre.txt";
    Properties connectionProperties = new Properties();
    public Integer getConnection() throws Exception {

        //SET UP CONNECTION TO DB
        //Загружаем драйвер
        Class.forName("org.postgresql.Driver");
        System.out.println("Драйвер подключен");
        Connection con = DriverManager.getConnection(URL, userName, password);
        System.out.println("Соединение установлено");


        //EXECUTE INSERT
        Statement stmt = con.createStatement();
       // int rs = stmt.executeUpdate(parseDataFiles.getArrayofFileLines(filename));
        return 1;

    }


}





