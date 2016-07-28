package test.mobileTest.appium.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Arthur on 28/07/2016.
 */
public class PageObjects_TelaBusca {

    public static final String XPATHBTNOK = "//android.widget.Button[@text='OK, entendi']";
    public static final String IDBUSCAR = "com.schibsted.bomnegocio.androidApp:id/action_search";
    public static final String IDCAIXATXT = "com.schibsted.bomnegocio.androidApp:id/search_src_text";

    @FindBy(xpath = XPATHBTNOK)
    protected WebElement btnOKEntendi;

    @FindBy(id = IDBUSCAR)
    protected WebElement btnBuscar;

    @FindBy(id = IDCAIXATXT)
    protected WebElement campoCaixaTxt;
}
