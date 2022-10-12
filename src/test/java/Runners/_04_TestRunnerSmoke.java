package Runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest or @Regression", // hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
       // plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
        plugin = { "html:target//cucumber-reports.html"}
)


public class _04_TestRunnerSmoke {
}
