package ru.javarush.tsebal;

import java.sql.*;

public class SqlDBTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", "jkliop33");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee LIMIT 1");
        ResultSetMetaData queryMetaData = resultSet.getMetaData();

        int columnCount = queryMetaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            String name = queryMetaData.getColumnName(column);
            String typeName = queryMetaData.getColumnTypeName(column);
            System.out.print(name + "(" + typeName + ") ");
        }

        statement.close();
        connection.close();
    }
}
