package test.mobileTest.cucumber.features;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import static test.mobileTest.appium.utils.Constant.getPathDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Arthur on 29/07/2016.
 */
public class DriverInstanceMobile {

    private static AndroidDriver driver;
    private static DesiredCapabilities capacidades;

    public static AndroidDriver instanceMobile() throws MalformedURLException {

        if (driver == null) {
            File diretorio = new File(getPathDriver());
            File app = new File(diretorio, "olx.apk");

            capacidades = new DesiredCapabilities();
            capacidades.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capacidades.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            capacidades.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        }
        return driver;
    }
}
