package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //-->Test çalıştırıcı Notasyon(Cucumber ile JUnit i entegre olmasını sağlar)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",

        },
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},

        tags = "@Api1", //-->  and kulansaydık her iki tag'a sahip olan Scenario yu çalıştırır.

        dryRun = false, //-->true seçersek scenarioları kontrol eder browser'ı çalıştırmaz
        monochrome = false
)
public class RunnerApi {

}
