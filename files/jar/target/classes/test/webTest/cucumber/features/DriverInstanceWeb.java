package test.webTest.cucumber.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.webTest.webdriver.utils.Constant;

import static test.webTest.webdriver.utils.Constant.getPathDriver;

/**
 * Created by Arthur on 29/07/2016.
 */
public class DriverInstanceWeb {

    private static WebDriver driver;

    public static WebDriver instance(){

        if (driver == null) {

            System.setProperty(getPathDriver(), Constant.GECKONAME);
            DesiredCapabilities dc = DesiredCapabilities.firefox();
            dc.setCapability("marionette", true);
            driver = new FirefoxDriver(dc);
            driver.manage().window().maximize();

            return driver;
        }

        return driver;
    }

}
