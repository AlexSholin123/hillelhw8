package ua.ithillel;

import ua.ithillel.service.RandomHttpService;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        RandomHttpService randomHttpService = new RandomHttpService();
        System.out.println(randomHttpService.getNumber(1, 10));

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "1234";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection got");
            Statement stat = con.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                                rs.getLong("id") + "\t" +
                                rs.getString("name")  + "\t" +
                                rs.getLong("salary")  + "\t" +
                                rs.getLong("department_id") + "\t" +
                                rs.getLong("chief_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
