package test.webTest.webdriver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Arthur on 25/07/2016.
 */
public class PageObjects_TelaLogin {

    public static final String IdCampoLogin = "login_email";
    public static final String IdCampoSenha = "login_password";
    public static final String IdCampoBusca = "navbar_searchad";
    public static final String IdBotaoEntrar = "bt_submit_login";
    public static final String XpathUsuarioLogado = "//h2[contains(.,'Bem vindo(a), desafioolxqa!')]";

    @FindBy(id = IdCampoLogin)
    protected WebElement textLogin;

    @FindBy(id = IdCampoSenha)
    protected WebElement textSenha;

    @FindBy(id = IdCampoBusca)
    protected WebElement linkBuscar;

    @FindBy(id = IdBotaoEntrar)
    protected WebElement btnEntrar;

}
