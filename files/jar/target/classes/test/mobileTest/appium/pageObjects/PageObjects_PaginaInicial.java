package test.mobileTest.appium.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Arthur on 25/07/2016.
 */
public class PageObjects_PaginaInicial {

    public static final String IDSELECIONARESTADO = "com.schibsted.bomnegocio.androidApp:id/fragment_automatic_location_manual_button";
    public static final String IDRIODEJANEIRO = "com.schibsted.bomnegocio.androidApp:id/Rio de Janeiro";
    public static final String IDDDD21 = "com.schibsted.bomnegocio.androidApp:id/DDD 21 - Rio de Janeiro e região";

    @FindBy(id = IDSELECIONARESTADO)
    protected WebElement btnSelecionarEstado;

    @FindBy(id = IDRIODEJANEIRO)
    protected WebElement btnSelecionarEstadoRiodeJaneiro;

    @FindBy(id = IDDDD21)
    protected WebElement btnSelecionarDDD21;

}