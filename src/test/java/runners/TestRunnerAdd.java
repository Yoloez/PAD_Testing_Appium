package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/add_matkul.feature",
        glue = {"stepDef"},
        plugin = {
                "pretty",
                "html:target/cucumber-report-add.html",
                "json:target/cucumber-add.json"
        },
        monochrome = true
)
public class TestRunnerAdd {
}

