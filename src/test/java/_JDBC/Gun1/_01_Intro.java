package _JDBC.Gun1;

import com.mysql.cj.protocol.Resultset;
import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {

        String hostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        // connection açılıyor. fileInputstream
        Connection connection = DriverManager.getConnection(hostUrl, username, password); // bağlantıya click

        Statement statement = connection.createStatement(); // sorguları çalıştırmak için sorgu gönderme ortamı

        // sorguyu yazdırdım ve çalıştırdım
        ResultSet rs = statement.executeQuery("select * from customer"); // sorgu çalıştı, sonuçları nerede?

        // ilk satırı mı istiyorsun, son satırı mı, 5. satırı mı?
        rs.next(); // sıradaki ilk satıra gitti

        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        System.out.println("1. Satırın müşteri adı ve soyadı =" + firstName + " " + lastName);

        rs.next(); // 2. sıradaki satıra gitti

        firstName = rs.getString("first_name");
        lastName = rs.getString("last_name");
        System.out.println("2. Satırın müşteri adı ve soyadı =" + firstName + " " + lastName);

        connection.close();
    }
}
