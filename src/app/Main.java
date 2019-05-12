package app;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.lang.Runtime;
import java.io.Console;

public class Main {
    final static String os = System.getProperty("os.name");

    public static void clearScreen() {
        try {
            if (os.contains("Windows"))
                Runtime.getRuntime().exec("cls");
            else
                Runtime.getRuntime().exec("clear");
        } catch (final Exception e) {
            // pass
        }
    }

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------- Checking Oracle JDBC Connection ------");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            // e.printStackTrace();
            sc.close();
            return;
        }
        System.out.println("Oracle JDBC Driver Registered!");

        // Login
        Connection connection = null;
        int login_count = 0;
        System.out.print("Username: ");
        String usr = sc.next();

        Console console = System.console();
        while (login_count < 3) {
            String pwd = new String(console.readPassword("Password: "));
            try {
                connection = DriverManager.getConnection("jdbc:oracle:thin:@50anhoi.ddns.net:1521:orcl", usr, pwd);
            } catch (SQLException e) {
                System.out.println("Connection Failed!");
                login_count++;
                // e.printStackTrace();
                // return;
            }
            if (login_count == 3) {
                sc.close();
                return;
            }
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection! Check again your Internet settings");
            sc.close();
            return;
        }

        // Query action
        Add_Search AddSearch = new Add_Search(connection, sc;

        while (true)
        {
            clearScreen();
            System.out.println("---------------- Query Options ----------------");
            System.out.println("1. Search patient information");
            System.out.println("2. Add information for new patient");
            System.out.println("3. Details of all patients treated by a Doctor");
            System.out.println("4. Report full payment information of a Patient");
            System.out.println("5. Logout");
            System.out.println("-----------------------------------------------");
            System.out.println("Action (1-5): ");
            int action = sc.nextInt();
            if (action == 1)
            {

            }
            else if (action == 2)
            {

            }
        }
    }
}