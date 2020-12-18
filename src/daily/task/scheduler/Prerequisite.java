/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily.task.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author urves
 */
public class Prerequisite
{

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

//    Enter your database username and password here.
    private final String username = "root";
    private final String password = "";

    private final String databaseName = "test_days_database";
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String[] days = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};

    private String createTable = "CREATE TABLE %s.%s ( `id` INT NOT NULL AUTO_INCREMENT , `tasks` VARCHAR(30) NOT NULL , `from_time` VARCHAR(5) NOT NULL , `to_time` VARCHAR(5) NOT NULL , PRIMARY KEY (`id`), UNIQUE (`tasks`, `from_time`, `to_time`)) ENGINE = InnoDB;";

    Prerequisite() {
        try {
            String query = "CREATE DATABASE " + databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Conneted with database.");
                pst = con.prepareStatement(query);
                pst.execute();
                System.out.println("Database is created.");
                try {
                    con = DriverManager.getConnection(url, username, password);
                    for (String day : days) {
                        pst = con.prepareStatement(String.format(createTable, databaseName, day));
                        pst.execute();
                    }
                    System.out.println("Tables are Created");
                }
                catch (Exception ex) {
                    System.out.println("Error to creating the tables.");
                }
            }
            catch (Exception ex) {
                System.out.println("Error to creating Database.");
            }

        }
        catch (Exception ex) {
            System.out.println("Error to connect the database.");
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
            catch (Exception e) {
                System.out.println("Database error.");
            }
        }
    }

    public static void main(String args[]) {
        new Prerequisite();
    }
}
