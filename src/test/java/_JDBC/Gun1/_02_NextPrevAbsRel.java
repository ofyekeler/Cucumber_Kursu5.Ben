package _JDBC.Gun1;

import _JDBC.JDBCParent;
import com.mysql.cj.protocol.Resultset;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_NextPrevAbsRel extends JDBCParent {

    @Test
    public void NextPrev() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        rs.next(); // ilk satır 1. satır
        System.out.println("1. satır dilAdı= "+rs.getString(2)); // 2 column sırası English

        rs.next(); // 2. satır
        System.out.println("2. satır dilAdı= "+rs.getString(2)); // Italian

        rs.next(); // 3. satır
        System.out.println("3. satır dilAdı= "+rs.getString(2)); // Japanese

        rs.previous(); // 2. satıra döndü
        System.out.println("Bir geri satır dilAdı= "+rs.getString(2));
    }

    @Test
    public void AbsoluteRelative() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from film");

        // rs.next()       : sonraki satır
        // rs.previous     : önceki satır
        // rs.absolute(10) : baştan itibaren 10. satıra gider
        // rs.relative(10) : bulunduğu yerden 10 satır ileri gider
        // rs.absolute(-10): -(eksi) sondan demektir, sondan 10. satıra gider
        // rs.relative(-10): -(eksi) bulunduğu yerden 5 satır geri gider

        rs.absolute(10); // 10. satıra git
        System.out.println("10. Satır - title = "+ rs.getString("title"));

        rs.relative(5); // 15. satıra gider. Niye? Çünkü son bulunduğu yerden 5 satır ileri gider.
        System.out.println("15. satır  - title =" + rs.getString("title"));

        rs.absolute(-10); // sondan 10. satıra git
        System.out.println("Sondan 10. satır - title= "+rs.getString("title"));
    }
}
