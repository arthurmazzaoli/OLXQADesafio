package test.webTest.webdriver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Arthur on 25/07/2016.
 */
public class PageObjects_TelaLogin {

    public static final String IDCAMPOLOGIN = "login_email";
    public static final String IDCAMPOSENHA = "login_password";
    public static final String IDCAMPOBUSCA = "navbar_searchad";
    public static final String IDBOTAOENTRAR = "bt_submit_login";
    public static final String XPATHUSUARIOLOGADO = "//h2[contains(.,'Bem vindo(a), desafioolxqa!')]";

    @FindBy(id = IDCAMPOLOGIN)
    protected WebElement textLogin;

    @FindBy(id = IDCAMPOSENHA)
    protected WebElement textSenha;

    @FindBy(id = IDCAMPOBUSCA)
    protected WebElement linkBuscar;

    @FindBy(id = IDBOTAOENTRAR)
    protected WebElement btnEntrar;

}
