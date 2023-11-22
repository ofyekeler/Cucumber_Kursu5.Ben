package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        //dosyanın yolunu değişkene atalım
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // JavaDosya okuma işlemcisine dosyanın yolunu veriyoruz:
        // böylece program ile dosya arasında bağlantı oluştu
        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);
                // FileInputStream   ın üzerine gelip açılan pencerede "Add exception to method signature ye
                // ... tıklıyorum. Main in yanına "throws ..."u SIGNATURE ediyorum.

        //Dosya okuma işlemcisi üzerinden Çalışma Kitabını alıyorum
        // hafızada workbook u alıp oluşturdu
/*Workbook*/  Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantisi);
                // Excel in kendisinde değil, RAM de çalıştığım için "create"i kullanıyorum.

        //istediğim isimdeki çalışma sayfasını alıyorum
/*Sheet*/ Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1"); // getSheetAt(0); da diyebilirim.

        //istenen Satırı alıyorum
/*Row*/   Row satir=calismaSayfasi.getRow(0);

/*Cell*/  Cell hucre=satir.getCell(0);

        System.out.println(hucre);
    }
}
/* Lion [0][0] */