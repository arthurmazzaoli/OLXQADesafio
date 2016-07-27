package test.java.webTest.webdriver.interactions;

import test.java.webTest.webdriver.pageObjects.PageObjects_TelaLogin;

/**
 * Created by Arthur on 25/07/2016.
 */
public class Interactions_TelaLogin extends PageObjects_TelaLogin {

    public void clickLinkBuscar()
    {
        linkBuscar.click();
    }

    public void preencherEmail(String email)
    {

        textLogin.clear();
        textLogin.sendKeys(email);

    }

    public void preencherSenha(String senha)
    {

        textSenha.clear();
        textSenha.sendKeys(senha);

    }

    public void pressionarBotaoEntrar()
    {

        btnEntrar.click();

    }
}
