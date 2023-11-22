package Runners;

import Utilities.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class _08_TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    // (alwaysRun = true) dememin sebebi, paralel testte biri diğerinin önüne geçtiği için çakışmalar olabiliyor.
    // Bu sebepten ötürü kendisini durduruyor ve çalışmıyor.
    // Ben burada demiş oluyorum ki "sen her zaman çalış". Böylelikle "BeforeClass" hatası almamış olurum.
    @Parameters("browserTipi")
    // paralel testte ki "name" ile yukarıdaki "browserTipi" text i birebir aynı olmalı!!
    public void beforClass(String browser){
        // browser tip şu an elimde
        GWD.threadBrowserSet(browser);
    }
}
