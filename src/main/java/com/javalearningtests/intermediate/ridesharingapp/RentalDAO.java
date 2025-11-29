package com.javalearningtests.intermediate.ridesharingapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalDAO {

    private DataBaseConnectionManager dataBaseConnectionManager;

    public RentalDAO(DataBaseConnectionManager dataBaseConnectionManager) {
        this.dataBaseConnectionManager = dataBaseConnectionManager;
    }

    public boolean insertRental(String customerId, String customerName, String vehicleType, int rentalTime, float rentalFare) {

        String insertToRentalLogs = "INSERT INTO rental_logs (customer_id, customer_name, vehicle_type, rental_time, rental_fare) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataBaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertToRentalLogs)) {

            preparedStatement.setString(1, customerId);
            preparedStatement.setString(2, customerName);
            preparedStatement.setString(3, vehicleType);
            preparedStatement.setInt(4, rentalTime);
            preparedStatement.setFloat(5, rentalFare);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.err.println("Error inserting rental info.");
            e.printStackTrace();
            return false;
        }

    }
}
