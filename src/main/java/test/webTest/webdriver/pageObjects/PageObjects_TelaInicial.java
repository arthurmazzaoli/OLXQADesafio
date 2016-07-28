package test.webTest.webdriver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Arthur on 25/07/2016.
 */
public class PageObjects_TelaInicial {

    public static final String CSSLINKLOGIN = "a[href=\"https://www3.olx.com.br/account/form_login\"]";

    @FindBy(css = CSSLINKLOGIN)
    protected WebElement BtnMinhaConta;

}
