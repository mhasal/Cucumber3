package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                "src/test/java/FeatureFiles/_02_Country.feature"
        }, // buraya feature files ın path i verilecek.
        glue = {"StepDefinitions"}, // Step definitions ın klasörü yazılıyor.
        dryRun = true // true olduğunda testi çalıştırma sadece feature lara ait steplerin varlığını kontrol
)

public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {

}
