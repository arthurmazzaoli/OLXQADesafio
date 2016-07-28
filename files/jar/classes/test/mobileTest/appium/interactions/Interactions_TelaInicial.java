package test.mobileTest.appium.interactions;


import org.openqa.selenium.WebElement;
import test.mobileTest.appium.pageObjects.PageObjects_PaginaInicial;

/**
 * Created by Arthur on 25/07/2016.
 */
public class Interactions_TelaInicial extends PageObjects_PaginaInicial{

    public void pressionarBtnSelecionarEstado()
    {
        btnSelecionarEstado.click();
    }

    public WebElement buscarBtnSelecionarEstado()
    {
        return btnSelecionarEstado;
    }

    public void pressionarBtnSelecionarEstadoRiodeJaneiro()
    {
        btnSelecionarEstadoRiodeJaneiro.click();
    }

    public WebElement buscarBtnSelecionarEstadoRiodeJaneiro()
    {
        return btnSelecionarEstadoRiodeJaneiro;
    }

    public void pressionarBtnSelecionarDDD21()
    {
        btnSelecionarDDD21.click();
    }

    public WebElement buscarBtnSelecionarDDD21() {
        return btnSelecionarDDD21;
    }

    public WebElement buscarCampoRegiaoEstado() {

        return lblRegiaoEstados;

    }

}
