package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD_old { // General Web Driver
    private static WebDriver driver;

    public static WebDriver getDriver() // driver ı başlat, bana ver
    {
        // extend report türkçe bilgi çalışmaması sebebiyle "locate" kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        driver = new ChromeDriver(); // selenium 4.8.3 güncellemesinden sonra
                                    // aşağıyı pasif yaptım. Chrome artık normal çalışıyor.
//        if (driver == null) { // 1 kere çalışssın
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            driver = new ChromeDriver(options);
//        }
        return driver;
    }

    public static void quitDriver(){
        try { Thread.sleep(5000); }
        catch (InterruptedException e) {
            throw new RuntimeException(e); }

        if (driver != null) { // dolu ise, boş değilse
            driver.quit();
            driver=null;
        }
    }
}