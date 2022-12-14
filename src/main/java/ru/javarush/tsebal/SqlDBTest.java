package ru.javarush.tsebal;

import java.sql.*;

public class SqlDBTest {
    public static void main(String[] args) throws SQLException {
        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/space",
                "root", "root");
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM object");

        while (results.next()) {
            Integer id = results.getInt(1);
            String name = results.getString(2);
            System.out.println(results.getRow() + ". " + id + "\t"+ name);
        }
        statement.close();
        connection.close();
    }
}
