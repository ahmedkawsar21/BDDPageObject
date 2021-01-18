package cucumber.options;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/features", glue = "stepDefinations",
        plugin={"pretty","html:test-output","json:target/jsonReports/cucumber-report.json"},
        monochrome = false,
        dryRun = false

)

public class TestRunner {


}
