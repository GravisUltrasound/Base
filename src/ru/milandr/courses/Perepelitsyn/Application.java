package ru.milandr.courses.Perepelitsyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

import static ru.milandr.courses.Perepelitsyn.LoginDatabase.loginAndCompare;
import static ru.milandr.courses.Perepelitsyn.Scan.scan;

public class Application {
    public static void main(String[] args) throws SQLException {
        System.out.println("The first database name:");
        String firstDatabaseName = scan();
        System.out.println(firstDatabaseName + "|Username: ");
        String firstUsername = scan();
        System.out.println(firstDatabaseName + "|Password: ");
        String firstPassword = scan();

        System.out.println("The second database name:");
        String secondDatabaseName = scan();
        System.out.println(secondDatabaseName + "|Username: ");
        String secondUsername = scan();
        System.out.println(secondDatabaseName + "|Password: ");
        String secondPassword = scan();

        System.out.println("Fields for comparing:");
        String fields = scan();
        List<String> fieldsArray = Arrays.asList(fields.split("\\s*,\\s*"));
        loginAndCompare(firstDatabaseName, firstUsername, firstPassword, secondDatabaseName, secondUsername, secondPassword, fieldsArray);


    }
}