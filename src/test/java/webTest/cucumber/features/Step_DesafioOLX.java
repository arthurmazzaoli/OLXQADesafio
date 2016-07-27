package test.java.webTest.cucumber.features;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import test.java.webTest.webdriver.commonMethods.*;
import test.java.webTest.webdriver.pageObjects.PageObjects_TelaInicial;
import test.java.webTest.webdriver.pageObjects.PageObjects_TelaLogin;
import test.java.webTest.webdriver.utils.Constant;
import test.java.webTest.webdriver.interactions.*;

import static test.java.webTest.webdriver.pageObjects.PageObjects_TelaLogin.XpathUsuarioLogado;
import static test.java.webTest.webdriver.utils.Constant.getPathDriver;

/**
 * Created by Arthur on 25/07/2016.
 */
public class Step_DesafioOLX {

    public static WebDriver driver;

    @Before
    public void setUp() throws Exception {

        if (driver == null) {

            System.setProperty(getPathDriver(), Constant.GECKONAME);
            DesiredCapabilities dc = DesiredCapabilities.firefox();
            dc.setCapability("marionette", true);
            driver = new FirefoxDriver(dc);
            driver.manage().window().maximize();

        }
    }

    @Dado("^que eu esteja na tela inicial \"([^\"]*)\"$")
    public void acessarTelaInicial(String URL) throws Throwable {

        driver.navigate().to(URL);

    }

    @Dado("^exista o campo Minha conta no inicio da pagina$")
    public void verificarExistenciaCampoMinhaConta() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.VerificaExistenciaComponenteByCss(PageObjects_TelaInicial.CssLinkLogin);

    }

    @Quando("^eu clico no botao Minha conta$")
    public void pressionarBotaoMinhaConta() {

        Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
        paginaInicial.clickBtnMinhaConta();

    }

    @Entao("^sou direcionado para a tela de login \"([^\"]*)\"$")
    public void validarDirecionamentoTelaLogin(String URL) throws Exception {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.VerificarPaginaAtualURL(URL);

    }

    @Dado("^que na tela de login, os campos email e senha estejam visiveis$")
    public void VerificarExistenciaCampoLoginSenha() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.VerificaExistenciaComponenteById(PageObjects_TelaLogin.IdCampoLogin);
        common.VerificaExistenciaComponenteById(PageObjects_TelaLogin.IdCampoSenha);

    }

    @Quando("^eu preencho o <email> valido$")
    public void preencherEmailValido() {

        Interactions_TelaLogin paginaLogin = PageFactory.initElements(driver, Interactions_TelaLogin.class);
        paginaLogin.preencherEmail("desafioolxqa@gmail.com");

    }

    @E("^preencho a <senha> valida$")
    public void preencherSenhaValida() {

        Interactions_TelaLogin paginaLogin = PageFactory.initElements(driver, Interactions_TelaLogin.class);
        paginaLogin.preencherSenha("12344321");

    }

    @E("^Pressiono o botao Entrar$")
    public void PressionaBotaoEntrar() {

        Interactions_TelaLogin paginaLogin = PageFactory.initElements(driver, Interactions_TelaLogin.class);
        paginaLogin.pressionarBotaoEntrar();

    }

    @Entao("^eu sou direcionado para tela incial do usuario OLX$")
    public void verificarDirecionamentoTelaUsuarioLogado() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.VerificaExistenciaComponenteByXpath(XpathUsuarioLogado);
        driver.close();
        driver.quit();

    }

}