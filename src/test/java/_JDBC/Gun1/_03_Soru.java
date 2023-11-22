package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_Soru extends JDBCParent {

    // city tablosundaki tüm satırlarda ki şehir isimlerini next ile yazdırınız

    @Test
    public void test1() throws SQLException {
        ResultSet rs= statement.executeQuery("select city from city");

        int rowCount=0; // satır sayısını almak için ...
        while ( rs.next()==true ){ // bir sonraki satır varsa yazdır.
            System.out.println(rs.getString("city"));
            rowCount++;
        }

        System.out.println("rowCount = " + rowCount);
    }

    // TODO : city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız
    // TODO : city tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız
}
