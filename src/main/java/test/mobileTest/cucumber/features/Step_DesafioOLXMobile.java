package test.mobileTest.cucumber.features;

import static test.mobileTest.appium.utils.Constant.getPathDriver;
import java.io.File;
import java.net.URL;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.support.PageFactory;
import test.mobileTest.appium.interactions.Interactions_TelaInicial;
import test.mobileTest.appium.commonMethods.CommonPageObjects;
import test.mobileTest.appium.pageObjects.PageObjects_PaginaInicial;

public class Step_DesafioOLXMobile {

    private AndroidDriver driver;
    private DesiredCapabilities capacidades;

    @Before
    public void setUp() throws Exception {

        if(driver == null) {
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
    public void que_o_campo_estado_esteja_visivel_na_tela_inicial_do_aplicativo() throws InterruptedException {

    }

    @E("^eu pressione o botão estado$")
    public void eu_pressione_o_botão_estado() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.VerificaExistenciaComponenteById(PageObjects_PaginaInicial.IDSELECIONARESTADO);

        Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
        paginaInicial.clickBtnSelecionarEstado();

    }

    @Entao("^sou direcionato para a lista de estados$")
    public void sou_direcionato_para_a_lista_de_estados() {


    }

    @Quando("^clico em Rio de Janeiro$")
    public void clico_em_Rio_de_Janeiro() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.VerificaExistenciaComponenteById(PageObjects_PaginaInicial.IDRIODEJANEIRO);

        Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
        paginaInicial.clickBtnSelecionarEstadoRiodeJaneiro();

    }

    @Entao("^sou direcionado para a listagem de regioes e DDD$")
    public void sou_direcionado_para_a_listagem_de_regioes_e_DDD() {

    }

    @Quando("^clico em DDD Rio de Janeiro e regiao$")
    public void clico_em_DDD_Rio_de_Janeiro_e_regiao() {

        CommonPageObjects common = new CommonPageObjects(driver);
        common.VerificaExistenciaComponenteById(PageObjects_PaginaInicial.IDDDD21);

        Interactions_TelaInicial paginaInicial = PageFactory.initElements(driver, Interactions_TelaInicial.class);
        paginaInicial.clickBtnSelecionarDDD21();

    }

    @Entao("^sou direcionado para a tela de ofertas$")
    public void sou_direcionado_para_a_tela_de_ofertas() {

    }

    @E("^digito o \"([^\"]*)\"$")
    public void digito_o(String arg1) {

    }

    @E("^pressiono o botao buscar$")
    public void pressiono_o_botao_buscar() {

    }

    @Entao("^sou direcionado para a listagem de produtos$")
    public void sou_direcionado_para_a_listagem_de_produtos() {

    }
}
