package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( // bu annotation'u (dipnot) ekliyorum.
        features = {"src/test/java/FeatureFiles/_01_Login.feature"},
        // buraya feature files ın path i verilecek.
// yani "ilgili feature -> sağ click -> copy path -> path from content root"
        glue = {"StepDefinitions"}
        // Step definitions ın klasörü yazılıyor.
        // Rename -> copy/paste
)
public class _01_TestRunner extends AbstractTestNGCucumberTests {
    // extend ettiğimiz ilgili class ıS ben oluşturmadım.
    // cucumber library de var.
}