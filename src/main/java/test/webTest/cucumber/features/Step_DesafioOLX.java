package test.webTest.cucumber.features;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import test.webTest.webdriver.commonMethods.*;
import test.webTest.webdriver.interactions.*;
import static test.webTest.webdriver.pageObjects.PageObjects_TelaInicial.*;
import static test.webTest.webdriver.pageObjects.PageObjects_TelaLogin.*;

/**
 * Created by Arthur on 25/07/2016.
 */
public class Step_DesafioOLX extends DriverInstanceWeb {

    private WebDriver driver = instance();
    CommonPageObjects common = new CommonPageObjects(driver);
    Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
    Interactions_TelaLogin paginaLogin = PageFactory.initElements(driver, Interactions_TelaLogin.class);

    @Dado("^que eu esteja na tela inicial \"([^\"]*)\"$")
    public void acessarTelaInicial(String URL) throws Throwable {

        driver.navigate().to(URL);

    }

    @Dado("^exista o campo Minha conta no inicio da pagina$")
    public void verificarExistenciaCampoMinhaConta() {

        common.aguardarElementoByCssSelector(CSSLINKLOGIN);

    }

    @Quando("^eu clico no botao Minha conta$")
    public void pressionarBotaoMinhaConta() {

        paginaInicial.pressionarBtnMinhaConta();

    }

    @Entao("^sou direcionado para a tela de login \"([^\"]*)\"$")
    public void validarDirecionamentoTelaLogin(String URL) throws Exception {

        common.verificarPaginaAtualURL(URL);

    }

    @Dado("^que na tela de login, os campos email e senha estejam visiveis$")
    public void VerificarExistenciaCampoLoginSenha() {

        common.aguardarElementoById(IDCAMPOLOGIN);
        common.aguardarElementoById(IDCAMPOSENHA);

    }

    @Quando("^eu preencho o \"([^\"]*)\" valido$")
    public void preencherEmail(String email) {

        paginaLogin.preencherEmail(email);

    }

    @E("^preencho a \"([^\"]*)\" valida$")
    public void preencherSenha(String senha) {

        paginaLogin.preencherSenha(senha);

    }

    @E("^Pressiono o botao Entrar$")
    public void PressionaBotaoEntrar() {

        common.aguardarElementoById(IDBOTAOENTRAR);
        paginaLogin.pressionarBotaoEntrar();

    }

    @Entao("^eu sou direcionado para tela incial do usuario OLX$")
    public void verificarDirecionamentoTelaUsuarioLogado() {

        common.aguardarElementByXpath(XPATHUSUARIOLOGADO);
        driver.close();
        driver.quit();

    }

}