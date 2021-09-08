package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"step_definitions"},
        plugin = {"pretty", "summary","json:target/cucumber.json"}
        //publish = true,
        //tags = "@positive_test or @negative_test",
        //tags = "@positive_test and @negative_test"
)
public class TestRunner {
}
