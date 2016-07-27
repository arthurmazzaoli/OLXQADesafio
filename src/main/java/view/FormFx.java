package main.java.view;

import javafx.concurrent.Task;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.java.mobileTest.cucumber.features.RunCukesTestMobile;
import test.java.webTest.cucumber.features.RunCukesTest;
import test.java.restTest.DesafioQAREST;

/**
 * Created by Arthur on 26/07/2016.
 */
public class FormFx {

    private AnchorPane panelContent;
    private TextArea txtAreaConsoleWeb;
    private TextArea txtAreaConsoleMob;
    private TextArea txtAreaConsoleRest;
    private Button btnExecutarWeb;
    private Button btnExecutarMob;
    private Button btnExecutarRest;

    public FormFx() {

        panelContent = new AnchorPane();
        panelContent.setPrefSize(480, 540);
        panelContent.getStyleClass().add("basePanel");
        BorderPane.setAlignment(panelContent, Pos.CENTER);

        criarFormPanel();

    }


    public void criarFormPanel(){

        BorderPane borderPane = new BorderPane();
        borderPane.setLayoutX(30);
        borderPane.setPrefSize(460, 530);
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 30.0);
        AnchorPane.setRightAnchor(borderPane, 29.0);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        panelContent.getChildren().add(borderPane);

        Label subTituloFuncaoLabel = new Label();
        subTituloFuncaoLabel.setLayoutX(25.0);
        subTituloFuncaoLabel.setLayoutY(8.0);
        subTituloFuncaoLabel.prefHeight(32.0);
        subTituloFuncaoLabel.prefWidth(192.0);
        subTituloFuncaoLabel.setText("Bem vindo ao programa Desafio QA-OLX - by Arthur Mazza");
        subTituloFuncaoLabel.getStyleClass().add("textoLabelSubTitulo");
        BorderPane.setAlignment(subTituloFuncaoLabel, Pos.TOP_CENTER);

        borderPane.setTop(subTituloFuncaoLabel);

        Label resultadoWebTest = new Label();
        resultadoWebTest.getStyleClass().add("textoLabel");
        BorderPane.setAlignment(resultadoWebTest, Pos.CENTER);

        borderPane.setCenter(resultadoWebTest);

        Label resultadoMobtest = new Label();
        resultadoWebTest.getStyleClass().add("textoLabel");
        BorderPane.setAlignment(resultadoMobtest, Pos.CENTER);

        borderPane.setCenter(resultadoMobtest);

        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(450, 520);
        gridPane.getStyleClass().add("basePanel");
        BorderPane.setAlignment(gridPane, Pos.CENTER);

        borderPane.setBottom(gridPane);

        ColumnConstraints ColumnConstraints = new ColumnConstraints(10, 100, Region.USE_COMPUTED_SIZE);
        ColumnConstraints.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().add(ColumnConstraints);

        RowConstraints linhaConsole = new RowConstraints(10, 148, 172);
        linhaConsole.setVgrow(Priority.SOMETIMES);
        RowConstraints rowConstraints = new RowConstraints(10, 50, 93);
        rowConstraints.setVgrow(Priority.SOMETIMES);

        gridPane.getRowConstraints().addAll(linhaConsole, rowConstraints);

        txtAreaConsoleWeb = new TextArea();
        txtAreaConsoleWeb.setPrefSize(385, 143);
        txtAreaConsoleWeb.setEditable(false);
        GridPane.setMargin(txtAreaConsoleWeb, new Insets(10, 0, 0, 0));

        txtAreaConsoleMob = new TextArea();
        txtAreaConsoleMob.setPrefSize(385, 143);
        txtAreaConsoleMob.setEditable(false);
        GridPane.setMargin(txtAreaConsoleMob, new Insets(10, 0, 0, 0));

        txtAreaConsoleRest = new TextArea();
        txtAreaConsoleRest.setPrefSize(385, 143);
        txtAreaConsoleRest.setEditable(false);
        GridPane.setMargin(txtAreaConsoleRest, new Insets(10, 0, 0, 0));

        btnExecutarWeb = new Button("Testes Web");
        btnExecutarWeb.setPrefSize(120, 25);
        btnExecutarWeb.setMnemonicParsing(false);
        btnExecutarWeb.setTextFill(Color.WHITE);
        btnExecutarWeb.setAlignment(Pos.CENTER);
        btnExecutarWeb.setStyle("-fx-base: #b6e7c9;");
        GridPane.setHalignment(btnExecutarWeb, HPos.CENTER);
        GridPane.setRowIndex(btnExecutarWeb, 1);

        btnExecutarMob = new Button("Testes Mobile");
        btnExecutarMob.setPrefSize(120, 25);
        btnExecutarMob.setMnemonicParsing(false);
        btnExecutarMob.setTextFill(Color.WHITE);
        btnExecutarMob.setAlignment(Pos.CENTER);
        btnExecutarMob.setStyle("-fx-base: #b6e7c9;");
        GridPane.setHalignment(btnExecutarMob, HPos.RIGHT);
        GridPane.setRowIndex(btnExecutarMob, 1);

        btnExecutarRest = new Button("Testes REST");
        btnExecutarRest.setPrefSize(120, 25);
        btnExecutarRest.setMnemonicParsing(false);
        btnExecutarRest.setTextFill(Color.WHITE);
        btnExecutarRest.setAlignment(Pos.CENTER);
        btnExecutarRest.setStyle("-fx-base: #b6e7c9;");
        GridPane.setHalignment(btnExecutarRest, HPos.LEFT);
        GridPane.setRowIndex(btnExecutarRest, 1);

        btnExecutarWeb.setOnAction(event -> {
            try {

                txtAreaConsoleWeb.visibleProperty().set(true);
                txtAreaConsoleMob.visibleProperty().set(false);
                txtAreaConsoleRest.visibleProperty().set(false);
                ConsoleLog.getInstance().iniciar(this, "Iniciando os Testes Web", 1);

                Task<String> task = new Task<String>() {
                    @Override
                    protected String call() throws Exception {

                        Result result = JUnitCore.runClasses(RunCukesTest.class);
                        for (Failure failure : result.getFailures()) {
                            ConsoleLog.getInstance().exibirMensagem(failure.toString(), 1);
                            System.out.println(failure.toString());
                        }
                        System.out.println(result.wasSuccessful());
                        ConsoleLog.getInstance().exibirMensagem("true", 1);

                        return "true";
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        resultadoWebTest.setText("Processo executado");
                        ConsoleLog.getInstance().exibirMensagem("Processo executado", 1);
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        Exception e = (Exception) getException();
                        e.printStackTrace();

                        resultadoWebTest.setText("Ocorreu um erro ao realizar a operação");
                        ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação", 1);
                        resultadoWebTest.setTextFill(Color.RED);
                    }

                };
                new Thread(task).start();

            }catch (Exception e){
                e.printStackTrace();

                resultadoWebTest.setText("Ocorreu um erro ao realizar a operação");
                ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação", 1);
                resultadoWebTest.setTextFill(Color.RED);
            }
        });

        gridPane.getChildren().addAll(txtAreaConsoleWeb, btnExecutarWeb);

        btnExecutarMob.setOnAction(event -> {
            try {

                txtAreaConsoleMob.visibleProperty().set(true);
                txtAreaConsoleWeb.visibleProperty().set(false);
                txtAreaConsoleRest.visibleProperty().set(false);
                ConsoleLog.getInstance().iniciar(this, "Iniciando os Testes Mobile", 2);

                Task<String> task = new Task<String>() {
                    @Override
                    protected String call() throws Exception {

                        Result result2 = JUnitCore.runClasses(RunCukesTestMobile.class);
                        for (Failure failure : result2.getFailures()) {
                            ConsoleLog.getInstance().exibirMensagem(failure.toString(), 2);
                            System.out.println(failure.toString());
                        }
                        System.out.println(result2.wasSuccessful());
                        ConsoleLog.getInstance().exibirMensagem("true", 2);

                        return "true";
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        resultadoMobtest.setText("Processo executado");
                        ConsoleLog.getInstance().exibirMensagem("Processo executado", 2);
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        Exception e = (Exception) getException();
                        e.printStackTrace();

                        resultadoMobtest.setText("Ocorreu um erro ao realizar a operação");
                        ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação", 2);
                        resultadoMobtest.setTextFill(Color.RED);
                    }

                };
                new Thread(task).start();

            }catch (Exception e){
                e.printStackTrace();

                resultadoMobtest.setText("Ocorreu um erro ao realizar a operação");
                ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação", 2);
                resultadoMobtest.setTextFill(Color.RED);
            }
        });

        gridPane.getChildren().addAll(txtAreaConsoleMob, btnExecutarMob);

        btnExecutarRest.setOnAction(event -> {
            try {

                txtAreaConsoleRest.visibleProperty().set(true);
                txtAreaConsoleWeb.visibleProperty().set(false);
                txtAreaConsoleMob.visibleProperty().set(false);
                ConsoleLog.getInstance().iniciar(this, "Iniciando os Testes REST", 3);

                Task<String> task = new Task<String>() {
                    @Override
                    protected String call() throws Exception {

//                        DesafioQAREST rest = new DesafioQAREST();
//                        rest.testGet();
//                        rest.testGet();
                        Result result = JUnitCore.runClasses(DesafioQAREST.class);

                        for (Failure failure : result.getFailures()) {
                            ConsoleLog.getInstance().exibirMensagem(failure.toString(), 3);
                            System.out.println(failure.toString());
                        }
                        System.out.println(result.wasSuccessful());
                        ConsoleLog.getInstance().exibirMensagem("true", 2);

                        return "true";
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        btnExecutarRest.setText("Processo executado");
                        ConsoleLog.getInstance().exibirMensagem("Processo executado", 3);
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        Exception e = (Exception) getException();
                        e.printStackTrace();

                        btnExecutarRest.setText("Ocorreu um erro ao realizar a operação");
                        ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação", 3);
                        btnExecutarRest.setTextFill(Color.RED);
                    }

                };
                new Thread(task).start();

            }catch (Exception e){
                e.printStackTrace();

                btnExecutarRest.setText("Ocorreu um erro ao realizar a operação");
                ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação", 3);
                btnExecutarRest.setTextFill(Color.RED);
            }
        });

        gridPane.getChildren().addAll(txtAreaConsoleRest, btnExecutarRest);

    }

    public void showMessagerTextArea(String message, int type) {

        int columnsOver = 0;

        switch (type) {

            case 1:

                this.getTxtAreaConsoleWeb().appendText(message + "\n");

                this.getTxtAreaConsoleWeb().setPrefRowCount(this.getTxtAreaConsoleWeb().prefRowCountProperty().get());

                if (message.length() > this.getTxtAreaConsoleWeb().getPrefColumnCount()) {
                    columnsOver = message.length();
                    this.getTxtAreaConsoleWeb().setPrefColumnCount(columnsOver);
                }

                this.getTxtAreaConsoleWeb().positionCaret(this.getTxtAreaConsoleWeb().getText().length());

                break;

            case 2:

                this.getTxtAreaConsoleMob().appendText(message + "\n");

                this.getTxtAreaConsoleMob().setPrefRowCount(this.getTxtAreaConsoleMob().prefRowCountProperty().get());

                if (message.length() > this.getTxtAreaConsoleMob().getPrefColumnCount()) {
                    columnsOver = message.length();
                    this.getTxtAreaConsoleWeb().setPrefColumnCount(columnsOver);
                }

                this.getTxtAreaConsoleMob().positionCaret(this.getTxtAreaConsoleMob().getText().length());

                break;

            case 3:

                this.getTxtAreaConsoleRest().appendText(message + "\n");

                this.getTxtAreaConsoleRest().setPrefRowCount(this.getTxtAreaConsoleRest().prefRowCountProperty().get());

                if (message.length() > this.getTxtAreaConsoleRest().getPrefColumnCount()) {
                    columnsOver = message.length();
                    this.getTxtAreaConsoleRest().setPrefColumnCount(columnsOver);
                }

                this.getTxtAreaConsoleRest().positionCaret(this.getTxtAreaConsoleRest().getText().length());

                break;
        }

    }


    public void limparConsole(){
        this.getTxtAreaConsoleWeb().setText("");

    }


    public AnchorPane getPanelContent() {
        return panelContent;
    }

    public void setPanelContent(AnchorPane panelContent) {
        this.panelContent = panelContent;
    }

    public Button getBtnExecutarWeb() {
        return btnExecutarWeb;
    }

    public void setBtnExecutarWeb(Button btnExecutarWeb) {
        this.btnExecutarWeb = btnExecutarWeb;
    }

    public TextArea getTxtAreaConsoleWeb() {
        return txtAreaConsoleWeb;
    }

    public void setTxtAreaConsoleWeb(TextArea txtAreaConsoleWeb) {
        this.txtAreaConsoleWeb = txtAreaConsoleWeb;
    }

    public TextArea getTxtAreaConsoleMob() {
        return txtAreaConsoleMob;
    }

    public TextArea getTxtAreaConsoleRest() {
        return txtAreaConsoleRest;
    }

    public void setTxtAreaConsoleMob(TextArea txtAreaConsoleWeb) {
        this.txtAreaConsoleMob = txtAreaConsoleWeb;
    }

}
