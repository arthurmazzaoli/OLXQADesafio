package test.mobileTest.cucumber.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Arthur on 26/07/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/Destination"},
                 features = {"target/classes/test/mobileTest/cucumber/features"})
public class RunCukesTestMobile {
}
