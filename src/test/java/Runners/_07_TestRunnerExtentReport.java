package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class _07_TestRunnerExtentReport extends AbstractTestNGCucumberTests {
}
// test-output -> screenshots  klasöründen hata ekran görüntüsünü görürüz
// test-output -> SparkReport -> Spark.html   den de hata raporunu görürüz.
