package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname, port, db adını (user db)
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        Connection connection = DriverManager.getConnection(url,username,password); // connection

        Statement statement = connection.createStatement(); // sorguları çalıştırmak için page açıldı

        ResultSet rs = statement.executeQuery("select * from actor");

        rs.next();

        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // 2. satır
        rs.next();

        firstName = rs.getString("first_name");
        lastName = rs.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        connection.close();

    }


}
