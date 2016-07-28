package test.mobileTest.appium.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Arthur on 25/07/2016.
 */
public class PageObjects_PaginaInicial {

    public static final String IDSELECIONARESTADO = "com.schibsted.bomnegocio.androidApp:id/fragment_automatic_" +
            "location_manual_button";
    public static final String XPATHRIODEJANEIRO = "//android.widget.TextView[@text='Rio de Janeiro']";
    public static final String XPATHDDD21 = "//android.widget.TextView[@text='DDD 21 - Rio de Janeiro e região']";

    @FindBy(id = IDSELECIONARESTADO)
    protected WebElement btnSelecionarEstado;

    @FindBy(xpath = XPATHRIODEJANEIRO)
    protected WebElement btnSelecionarEstadoRiodeJaneiro;

    @FindBy(xpath = XPATHDDD21)
    protected WebElement btnSelecionarDDD21;

}