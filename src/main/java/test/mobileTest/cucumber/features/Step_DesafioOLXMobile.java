package test.mobileTest.cucumber.features;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import test.mobileTest.appium.interactions.Interactions_TelaBusca;
import test.mobileTest.appium.interactions.Interactions_TelaInicial;
import test.mobileTest.appium.commonMethods.CommonPageObjects;
import test.mobileTest.appium.pageObjects.PageObjects_PaginaInicial;
import test.mobileTest.appium.pageObjects.PageObjects_TelaBusca;

import java.net.MalformedURLException;

public class Step_DesafioOLXMobile extends DriverInstanceMobile {

    public Step_DesafioOLXMobile() throws MalformedURLException {
    }

    private AndroidDriver driver = instanceMobile();
    CommonPageObjects common = new CommonPageObjects(driver);
    Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
    Interactions_TelaBusca paginabusca = PageFactory.initElements(driver, Interactions_TelaBusca.class);

    @Dado("^que o campo estado esteja visivel na tela inicial do aplicativo$")
    public void verificarExistenciaCampoEstado() {

        common.aguardarElementoById(PageObjects_PaginaInicial.IDSELECIONARESTADO);

    }

    @E("^eu pressione o botão estado$")
    public void pressionarBotaoEstado() {

        paginaInicial.pressionarBtnSelecionarEstado();

    }

    @Entao("^sou direcionato para a lista de estados$")
    public void validarDirecionamentoListaEstados() {

        common.aguardarElementoByXpath(PageObjects_PaginaInicial.XPATHLISTAREGIAO);

    }

    @Quando("^clico em Rio de Janeiro$")
    public void pressionarRiodeJaneiro() {

        common.aguardarElementoByXpath(PageObjects_PaginaInicial.XPATHRIODEJANEIRO);
        paginaInicial.pressionarBtnSelecionarEstadoRiodeJaneiro();

    }

    @Entao("^sou direcionado para a listagem de regioes e DDD$")
    public void validarDirecionamentoListagemDDDRegioes() throws InterruptedException {

        common.aguardarElementoByXpath(PageObjects_PaginaInicial.XPATHDDD21);

    }

    @Quando("^clico em DDD Rio de Janeiro e regiao$")
    public void pressionarDDDRiodeJaneiro() throws InterruptedException {


        paginaInicial.pressionarBtnSelecionarDDD21();

    }

    @Entao("^o sistema exibe a mensagem \"([^\"]*)\"$")
    public void verificarMensagemFiltro(String msg) throws Exception {

        common.aguardarElementoById(PageObjects_TelaBusca.IDMSGFILTRO);
        Assert.assertEquals(driver.findElement(By.id(PageObjects_TelaBusca.IDMSGFILTRO)).getText(), msg);

    }

    @Quando("^clico em OK$")
    public void pressionarBotaoOK() {

        common.aguardarElementoByXpath(PageObjects_TelaBusca.XPATHBTNOK);
        paginabusca.pressionarBtnOKEntendi();

    }

    @E("^clico na lupa de pesquisa$")
    public void pressionarLupadePesquisa() {

        common.aguardarElementoById(PageObjects_TelaBusca.IDBUSCAR);
        paginabusca.pressionarBtnBuscar();

    }

    @E("^digito o \"([^\"]*)\"$")
    public void digitarProduto(String produto) throws InterruptedException {

        common.aguardarElementoById(PageObjects_TelaBusca.IDCAIXATXT);
        paginabusca.digitarProdutoCaixaTxt(produto);

    }

    @Entao("^sou direcionado para a listagem de produtos$")
    public void validarDirecionamentoTelaProdutos() {

        //Aguardo a tela de busca renderizar
        common.aguardarElementoById(PageObjects_TelaBusca.IDTELABUSCA);

    }
}
