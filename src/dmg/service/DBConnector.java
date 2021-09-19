/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 

/**
 *
 * @author b
 */
public class DBConnector {

    private static Connection conn = null;

    public static Connection getConnection()   {

        if (conn == null) {
            try {

                String url = "jdbc:mysql://localhost:3306/dms";
                String username = "root";
                String pass = "123456";

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, pass);
                System.out.println("connection successful");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

        return conn;

    }

    public static Connection getConnectionT()   {

        if (conn == null) {
            try {

                String url = "jdbc:mysql://localhost:3306/newsc";
                String username = "root";
                String pass = "123456";

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, pass);
                System.out.println("connection successful");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

        return conn;

    }
    
    public static void createDatabases(){
        String sql = "CREATE TABLE `newsc`.`companies` (\n"
                + "  `id` int NOT NULL AUTO_INCREMENT,\n"
                + "  `name` varchar(45) DEFAULT NULL,\n"
                + "  `address` varchar(45) DEFAULT NULL,\n"
                + "  `email` varchar(45) DEFAULT NULL,\n"
                + "  `ContactNo` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`id`),\n"
                + "  UNIQUE KEY `name_UNIQUE` (`name`)\n"
                + ");\n"
               
                + "CREATE TABLE `newsc`.`customers` (\n"
                + "  `id` int NOT NULL AUTO_INCREMENT,\n"
                + "  `name` varchar(45) DEFAULT NULL,\n"
                + "  `address` varchar(45) DEFAULT NULL,\n"
                + "  `contact` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ");"
                + "CREATE TABLE `newsc`.`drugin` (\n"
                + "  `billID` int NOT NULL AUTO_INCREMENT,\n"
                + "  `drugId` varchar(45) DEFAULT NULL,\n"
                + "  `buyprice` double DEFAULT NULL,\n"
                + "  `saleprice` double DEFAULT NULL,\n"
                + "  `quantity` int DEFAULT NULL,\n"
                + "  `batchNo` int DEFAULT NULL,\n"
                + "  `companyid` int DEFAULT NULL,\n"
                + "  `entrydate` date DEFAULT NULL,\n"
                + "  `expdate` date DEFAULT NULL,\n"
                + "  `mfgdate` date DEFAULT NULL,\n"
                + "  PRIMARY KEY (`billID`)\n"
                + ");"
                + "REATE TABLE `newsc`.`druginventory` (\n"
                + "  `id` int NOT NULL AUTO_INCREMENT,\n"
                + "  `drugid` int NOT NULL,\n"
                + "  `buyprice` double DEFAULT NULL,\n"
                + "  `saleprice` double DEFAULT NULL,\n"
                + "  `quantity` int DEFAULT '0',\n"
                + "  `batchNo` int DEFAULT NULL,\n"
                + "  `companyid` int DEFAULT NULL,\n"
                + "  `entrydate` date DEFAULT NULL,\n"
                + "  `expdate` date DEFAULT NULL,\n"
                + "  `mfgdate` date DEFAULT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ;"
                + "CREATE TABLE `newsc`.`druglist` (\n"
                + "  `id` int NOT NULL AUTO_INCREMENT,\n"
                + "  `name` varchar(45) DEFAULT NULL,\n"
                + "  `buyprice` double DEFAULT NULL,\n"
                + "  `saleprice` double DEFAULT NULL,\n"
                + "  `companyid` int DEFAULT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ");"
                + "CREATE TABLE `newsc`.`drugout` (\n"
                + "  `invoiceid` int NOT NULL AUTO_INCREMENT,\n"
                + "  `drugId` varchar(45) DEFAULT NULL,\n"
                + "  `buyprice` double DEFAULT NULL,\n"
                + "  `saleprice` double DEFAULT NULL,\n"
                + "  `quantity` int DEFAULT NULL,\n"
                + "  `batchNo` int DEFAULT NULL,\n"
                + "  `customerid` int DEFAULT NULL,\n"
                + "  `companyid` int DEFAULT NULL,\n"
                + "  `entrydate` date DEFAULT NULL,\n"
                + "  `expdate` date DEFAULT NULL,\n"
                + "  `mfgdate` date DEFAULT NULL,\n"
                + "  PRIMARY KEY (`invoiceid`)\n"
                + ");";
        
        try {
            
            PreparedStatement ps = getConnectionT().prepareCall(sql);
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

}
