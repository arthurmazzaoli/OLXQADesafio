package test.mobileTest.cucumber.features;

import static test.mobileTest.appium.utils.Constant.getPathDriver;
import java.io.File;
import java.net.URL;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.support.PageFactory;
import test.mobileTest.appium.interactions.Interactions_TelaBusca;
import test.mobileTest.appium.interactions.Interactions_TelaInicial;
import test.mobileTest.appium.commonMethods.CommonPageObjects;
import test.mobileTest.appium.pageObjects.PageObjects_PaginaInicial;
import test.mobileTest.appium.pageObjects.PageObjects_TelaBusca;

public class Step_DesafioOLXMobile {

    private AndroidDriver driver;
    private DesiredCapabilities capacidades;

    @Before
    public void setUp() throws Exception {

        if (driver == null) {
            File diretorio = new File(getPathDriver());
            File app = new File(diretorio, "olx.apk");

            capacidades = new DesiredCapabilities();
            capacidades.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capacidades.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            capacidades.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        }
    }

    @Dado("^que o campo estado esteja visivel na tela inicial do aplicativo$")
    public void verificarExistenciaCampoEstado() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.aguardarElementoById(PageObjects_PaginaInicial.IDSELECIONARESTADO);

    }

    @E("^eu pressione o botão estado$")
    public void pressionarBotaoEstado() {

        Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
        paginaInicial.pressionarBtnSelecionarEstado();

    }

    @Entao("^sou direcionato para a lista de estados$")
    public void validarDirecionamentoListaEstados() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.aguardarElementoByXpath(PageObjects_PaginaInicial.XPATHLISTAREGIAO);

    }

    @Quando("^clico em Rio de Janeiro$")
    public void pressionarRiodeJaneiro() {

        CommonPageObjects common = new CommonPageObjects(driver);
        Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);

        common.aguardarElementoByXpath(PageObjects_PaginaInicial.XPATHRIODEJANEIRO);
        paginaInicial.pressionarBtnSelecionarEstadoRiodeJaneiro();

    }

    @Entao("^sou direcionado para a listagem de regioes e DDD$")
    public void validarDirecionamentoListagemDDDRegioes() throws InterruptedException {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.aguardarElementoByXpath(PageObjects_PaginaInicial.XPATHDDD21);

    }

    @Quando("^clico em DDD Rio de Janeiro e regiao$")
    public void pressionarDDDRiodeJaneiro() throws InterruptedException {

        Interactions_TelaInicial paginainicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
        paginainicial.pressionarBtnSelecionarDDD21();

    }

    @Entao("^o sistema exibe a mensagem \"([^\"]*)\"$")
    public void verificarMensagemFiltro(String msg) throws Exception {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.aguardarElementoById(PageObjects_TelaBusca.IDMSGFILTRO);
        Assert.assertEquals(driver.findElement(By.id(PageObjects_TelaBusca.IDMSGFILTRO)).getText(), msg);

    }

    @Quando("^clico em OK$")
    public void pressionarBotaoOK() {

        Interactions_TelaBusca paginabusca = PageFactory.initElements(driver, Interactions_TelaBusca.class);
        CommonPageObjects common = new CommonPageObjects(driver);

        common.aguardarElementoByXpath(PageObjects_TelaBusca.XPATHBTNOK);
        paginabusca.pressionarBtnOKEntendi();

    }

    @E("^clico na lupa de pesquisa$")
    public void pressionarLupadePesquisa() {

        Interactions_TelaBusca paginabusca = PageFactory.initElements(driver, Interactions_TelaBusca.class);
        CommonPageObjects common = new CommonPageObjects(driver);

        common.aguardarElementoById(PageObjects_TelaBusca.IDBUSCAR);
        paginabusca.pressionarBtnBuscar();

    }

    @E("^digito o \"([^\"]*)\"$")
    public void digitarProduto(String produto) throws InterruptedException {

        Interactions_TelaBusca paginabusca = PageFactory.initElements(driver, Interactions_TelaBusca.class);
        CommonPageObjects common = new CommonPageObjects(driver);

        common.aguardarElementoById(PageObjects_TelaBusca.IDCAIXATXT);
        paginabusca.digitarProdutoCaixaTxt(produto);

    }

    @Entao("^sou direcionado para a listagem de produtos$")
    public void validarDirecionamentoTelaProdutos() {

        CommonPageObjects common = new CommonPageObjects(driver);
        //Aguardo a tela de busca renderizar
        common.aguardarElementoById(PageObjects_TelaBusca.IDTELABUSCA);

    }
}
