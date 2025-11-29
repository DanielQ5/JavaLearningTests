package com.javalearningtests.intermediate.ridesharingapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnectionManager {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private String dbDriver;

    public DataBaseConnectionManager(String DATABASE_CONFIG_PATH) {
        loadDatabaseConfig(DATABASE_CONFIG_PATH);
    }

    private void loadDatabaseConfig(String DATABASE_CONFIG_PATH) {

        Properties properties = new Properties();

        try (FileInputStream fileinput = new FileInputStream(DATABASE_CONFIG_PATH)) {

            properties.load(fileinput);  // Use the Properties object

            // Extract and STORE in instance variables
            this.dbUrl = properties.getProperty("db.url");
            this.dbUsername = properties.getProperty("db.username");
            this.dbPassword = properties.getProperty("db.password");
            this.dbDriver = properties.getProperty("db.driver");

            System.out.println("Config loaded!");
        } catch (IOException e) {
            System.err.println("Error loading config file!");
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        // USE the stored values to create a connection

        try {
            Class.forName(this.dbDriver);
            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL Driver not found!", e);
        }

    }
}
