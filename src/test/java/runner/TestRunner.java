package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features ="src/main/resources/feature",glue = "stepsdef",tags = "@Regression",plugin={"pretty","html:target/reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
