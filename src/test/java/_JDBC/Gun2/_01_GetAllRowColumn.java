package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class _01_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData(); // normal bilginin dışındaki bilgiler
        // Sonuçların haricindeki diğer bilgiler: colon sayısı, isimleri, tipleri

        int columnCount = rsmd.getColumnCount(); // kolon (sütun) sayısı
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            System.out.print("Column name=" + rsmd.getColumnName(i));
            System.out.println("\tColumn type=" + rsmd.getColumnTypeName(i));
        }
/*
columnCount = 3
Column name = language_id	Column type = TINYINT UNSIGNED
Column name = name	        Column type = CHAR
Column name = last_update	Column type = TIMESTAMP
*/
    }

    @Test
    public void test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = statement.executeQuery("select * from language"); // data + metdata
        ResultSetMetaData rsmd = rs.getMetaData(); // data dışındaki bilgileri: kolon sayısı,ismi,tipleri

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t"); // metdata yı yazdırır
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");  // data nın kendisini yazdırır
            }
            System.out.println();
        }
/*
language_id	name	last_update
1	English 	2006-02-15 05:02:19
2	Italian	    2006-02-15 05:02:19
3	Japanese	2006-02-15 05:02:19
4	Mandarin	2006-02-15 05:02:19
5	French	    2006-02-15 05:02:19
6	German	    2006-02-15 05:02:19
*/
    }

    @Test
    public void test3() throws SQLException {
        // bir metoda sorguyu("select * from language") gönderiniz,
        // metod size sorgunun datasını bir ArrayList olarak döndürsün

        String sql = "select * from language";
        ArrayList<ArrayList<String>> donenSonuc = getListData(sql);
        System.out.println("donenSonuc = " + donenSonuc);
    }

    public ArrayList<ArrayList<String>> getListData(String sql) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                ArrayList<String> satir = new ArrayList<>();

                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                {
                    satir.add(rs.getString(i)); // her satıra data ları ekleyeceğim.
                }
                tablo.add(satir);
            }
        }
        catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return tablo;
    }
/*
test3
donenSonuc = [[1, English,  2006-02-15 05:02:19],
              [2, Italian,  2006-02-15 05:02:19],
              [3, Japanese, 2006-02-15 05:02:19],
              [4, Mandarin, 2006-02-15 05:02:19],
              [5, French,   2006-02-15 05:02:19],
              [6, German,   2006-02-15 05:02:19]]
*/
}










