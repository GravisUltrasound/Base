package ru.milandr.courses.Perepelitsyn;


import java.sql.*;
import java.util.*;

import static ru.milandr.courses.Perepelitsyn.MakeList.makeList;

public class LoginDatabase {

    public static void loginAndCompare(String databaseName1, String username1, String password1, String databaseName2, String username2, String password2, List fieldsArray) throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");

            Connection conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databaseName1, username1, password1);
            Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databaseName2, username2, password2);
            Statement stmt1 = conn1.createStatement();
            Statement stmt2 = conn2.createStatement();
            String fields = String.join(",", fieldsArray);
            ResultSet rs1 = stmt1.executeQuery("SELECT " + fields + " FROM users");
            ResultSet rs2 = stmt2.executeQuery("SELECT " + fields + " FROM users");
            List list1 = makeList(rs1, fieldsArray);
            List list2 = makeList(rs2, fieldsArray);

            System.out.println(list1.equals(list2));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}