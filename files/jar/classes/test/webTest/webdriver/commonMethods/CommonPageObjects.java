package test.webTest.webdriver.commonMethods;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Arthur on 25/07/2016.
 */
public class CommonPageObjects {

    private static WebDriver driver;

    public CommonPageObjects(WebDriver driver) {

        this.driver = driver;

    }

    public void VerificarPaginaAtualURL(String URL) throws Exception {

        try {

            URL = driver.getCurrentUrl();

        } catch (Exception e) {

            throw new Exception("URL atual não confere com a passada: " + URL + " Erro: " + e);

        }
    }

    public void VerificaExistenciaComponenteByCss(String locator) {

        waitElementByCssSelector(locator);
        fluentWait(driver.findElement(By.cssSelector(locator)));

    }

    public void VerificaExistenciaComponenteById(String locator) {

        waitElementById(locator);
        fluentWait(driver.findElement(By.id(locator)));

    }

    public void VerificaExistenciaComponenteByXpath(String locator) {

        waitElementById(locator);
        fluentWait(driver.findElement(By.xpath(locator)));

    }

    private WebElement fluentWait(WebElement button) {

        new FluentWait<WebElement>(button)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .until(new Function<WebElement, Boolean>() {
                    public Boolean apply(WebElement w) {
                        return w.isDisplayed();
                    }
                });
        return button;
    }

    private boolean waitElementByXpath(String locator) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean waitElementById(String locator) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean waitElementByCssSelector(String locate) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locate)));

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
