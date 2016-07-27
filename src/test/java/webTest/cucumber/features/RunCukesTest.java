package test.java.webTest.cucumber.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Arthur on 24/07/2016.
 */


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/Destination"},
         features = {"src/test/java/webTest/cucumber/features"})
public class RunCukesTest {
}

