package utils;

import java.sql.*;

public class SqlDbConnection {
    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        Connection connect = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/QaDbt","root","root");
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("select * from EmployeeInfo where name = 'sam' And age ='21'");
        String name = rs.getString("name");
        String age = rs.getString("age");
        while (rs.next()) {
            System.out.println(name);
            System.out.println(age);
        }
    }
}
