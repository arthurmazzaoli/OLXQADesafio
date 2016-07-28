package test.mobileTest.appium.interactions;

import org.openqa.selenium.By;
import test.mobileTest.appium.pageObjects.PageObjects_TelaBusca;
import static test.webTest.cucumber.features.Step_DesafioOLX.driver;

/**
 * Created by Arthur on 28/07/2016.
 */
public class Interactions_TelaBusca extends PageObjects_TelaBusca{

    public void pressionarBtnOKEntendi()
    {

        btnOKEntendi.click();

    }

    public void pressionarBtnBuscar()
    {

        btnBuscar.click();

    }

    public void digitarProdutoCaixaTxt(String produto)
    {

        //O \n serve para submeter a busca
        campoCaixaTxt.sendKeys(produto + "\n");

    }
}
