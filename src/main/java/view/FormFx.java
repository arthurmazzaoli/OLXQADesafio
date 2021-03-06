package view;

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
import test.mobileTest.cucumber.features.RunCukesTestMobile;
import test.webTest.cucumber.features.RunCukesTest;
import test.restTest.DesafioQAREST;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Arthur on 26/07/2016.
 */
public class FormFx {

    private AnchorPane panelContent;
    private TextArea txtAreaConsole;
    private Button btnExecutarWeb;
    private Button btnExecutarMob;
    private Button btnExecutarRest;
    private ByteArrayOutputStream baos;
    private PrintStream previous;
    private boolean capturing;


    public FormFx() {

        panelContent = new AnchorPane();
        panelContent.setPrefSize(480, 540);
        panelContent.getStyleClass().add("basePanel");
        BorderPane.setAlignment(panelContent, Pos.CENTER);
        criarFormPanel();

    }


    public void criarFormPanel() {

        BorderPane borderPane = new BorderPane();
        borderPane.setLayoutX(30);
        borderPane.setPrefSize(460, 530);
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 30.0);
        AnchorPane.setRightAnchor(borderPane, 29.0);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        panelContent.getChildren().add(borderPane);

        Label espacamentoInicial = new Label();
        BorderPane.setAlignment(espacamentoInicial, Pos.CENTER);
        borderPane.setTop(espacamentoInicial);

        Label subTituloFuncaoLabel = new Label();
        subTituloFuncaoLabel.setLayoutX(25.0);
        subTituloFuncaoLabel.setLayoutY(8.0);
        subTituloFuncaoLabel.prefHeight(32.0);
        subTituloFuncaoLabel.prefWidth(192.0);
        subTituloFuncaoLabel.setText("Bem vindo ao programa Desafio QA-OLX - by Arthur Mazza");
        subTituloFuncaoLabel.getStyleClass().add("textoLabelSubTitulo");
        BorderPane.setAlignment(subTituloFuncaoLabel, Pos.TOP_CENTER);
        borderPane.setCenter(subTituloFuncaoLabel);

        Label resultado = new Label();
        BorderPane.setAlignment(resultado, Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(450, 520);
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

        txtAreaConsole = new TextArea();
        txtAreaConsole.setPrefSize(385, 143);
        txtAreaConsole.setEditable(false);
        GridPane.setMargin(txtAreaConsole, new Insets(10, 0, 0, 0));

        gridPane.getChildren().addAll(txtAreaConsole);

        btnExecutarWeb = new Button("Testes Web");
        btnExecutarWeb.setPrefSize(120, 25);
        btnExecutarWeb.setMnemonicParsing(false);
        btnExecutarWeb.setTextFill(Color.BLACK);
        btnExecutarWeb.setAlignment(Pos.CENTER);
        btnExecutarWeb.setStyle("-fx-base: #b6e7c9;");
        GridPane.setHalignment(btnExecutarWeb, HPos.CENTER);
        GridPane.setRowIndex(btnExecutarWeb, 1);

        btnExecutarMob = new Button("Testes Mobile");
        btnExecutarMob.setPrefSize(120, 25);
        btnExecutarMob.setMnemonicParsing(false);
        btnExecutarMob.setTextFill(Color.BLACK);
        btnExecutarMob.setAlignment(Pos.CENTER);
        btnExecutarMob.setStyle("-fx-base: #b6e7c9;");
        GridPane.setHalignment(btnExecutarMob, HPos.RIGHT);
        GridPane.setRowIndex(btnExecutarMob, 1);

        btnExecutarRest = new Button("Testes REST");
        btnExecutarRest.setPrefSize(120, 25);
        btnExecutarRest.setMnemonicParsing(false);
        btnExecutarRest.setTextFill(Color.BLACK);
        btnExecutarRest.setAlignment(Pos.CENTER);
        btnExecutarRest.setStyle("-fx-base: #b6e7c9;");
        GridPane.setHalignment(btnExecutarRest, HPos.LEFT);
        GridPane.setRowIndex(btnExecutarRest, 1);

        btnExecutarWeb.setOnAction(event -> {
            try {

                limparConsole();

                start();

                ConsoleLog.getInstance().iniciar(this, "Iniciando os Testes Web");

                Task<String> task = new Task<String>() {
                    @Override
                    protected String call() throws Exception {

                        Result result = JUnitCore.runClasses(RunCukesTest.class);

                        String capturedValue = baos.toString();
                        ConsoleLog.getInstance().exibirMensagem(capturedValue);

                        for (Failure failure : result.getFailures()) {
                            ConsoleLog.getInstance().exibirMensagem(failure.toString());
                            System.out.println(failure.toString());
                        }
                        System.out.println(result.wasSuccessful());
                        ConsoleLog.getInstance().exibirMensagem("true");

                        return "true";
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        resultado.setText("Processo executado");
                        ConsoleLog.getInstance().exibirMensagem("Processo executado");
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        Exception e = (Exception) getException();
                        e.printStackTrace();

                        resultado.setText("Ocorreu um erro ao realizar a operação");
                        ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação");
                        resultado.setTextFill(Color.RED);
                    }

                };
                new Thread(task).start();

            } catch (Exception e) {
                e.printStackTrace();

                resultado.setText("Ocorreu um erro ao realizar a operação");
                ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação");
                resultado.setTextFill(Color.RED);
            }
        });

        gridPane.getChildren().addAll(btnExecutarWeb);

        btnExecutarMob.setOnAction(event -> {
            try {

                limparConsole();

                start();

                ConsoleLog.getInstance().iniciar(this, "Iniciando os Testes Mobile");

                Task<String> task = new Task<String>() {
                    @Override
                    protected String call() throws Exception {

                        Result result = JUnitCore.runClasses(RunCukesTestMobile.class);

                        String capturedValue = baos.toString();
                        ConsoleLog.getInstance().exibirMensagem(capturedValue);

                        for (Failure failure : result.getFailures()) {
                            ConsoleLog.getInstance().exibirMensagem(failure.toString());
                            System.out.println(failure.toString());
                        }
                        System.out.println(result.wasSuccessful());
                        ConsoleLog.getInstance().exibirMensagem("true");

                        return "true";
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        resultado.setText("Processo executado");
                        ConsoleLog.getInstance().exibirMensagem("Processo executado");
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        Exception e = (Exception) getException();
                        e.printStackTrace();

                        resultado.setText("Ocorreu um erro ao realizar a operação");
                        ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação");
                        resultado.setTextFill(Color.RED);
                    }

                };
                new Thread(task).start();

            } catch (Exception e) {
                e.printStackTrace();

                resultado.setText("Ocorreu um erro ao realizar a operação");
                ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação");
                resultado.setTextFill(Color.RED);
            }
        });

        gridPane.getChildren().addAll(btnExecutarMob);

        btnExecutarRest.setOnAction(event -> {
            try {

                limparConsole();

                start();

                ConsoleLog.getInstance().iniciar(this, "Iniciando os Testes REST");

                Task<String> task = new Task<String>() {
                    @Override
                    protected String call() throws Exception {

                        Result result = org.junit.runner.JUnitCore.runClasses(DesafioQAREST.class);

                        String capturedValue = baos.toString();
                        ConsoleLog.getInstance().exibirMensagem(capturedValue);

                        for (Failure failure : result.getFailures()) {
                            ConsoleLog.getInstance().exibirMensagem(failure.toString());
                            System.out.println(failure.toString());
                        }
                        System.out.println(result.wasSuccessful());
                        ConsoleLog.getInstance().exibirMensagem("true");

                        return "true";
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        resultado.setText("Processo executado");
                        ConsoleLog.getInstance().exibirMensagem("Processo executado");
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        Exception e = (Exception) getException();
                        e.printStackTrace();

                        resultado.setText("Ocorreu um erro ao realizar a operação");
                        ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação");
                        resultado.setTextFill(Color.RED);
                    }

                };
                new Thread(task).start();

            } catch (Exception e) {
                e.printStackTrace();

                resultado.setText("Ocorreu um erro ao realizar a operação");
                ConsoleLog.getInstance().exibirMensagem("Ocorreu um erro ao realizar a operação");
                resultado.setTextFill(Color.RED);
            }
        });

        gridPane.getChildren().addAll(btnExecutarRest);

    }

    public void showMessagerTextArea(String message) {

        int columnsOver = 0;

        this.getTxtAreaConsole().appendText(message + "\n");

        this.getTxtAreaConsole().setPrefRowCount(this.getTxtAreaConsole().prefRowCountProperty().get());

        if (message.length() > this.getTxtAreaConsole().getPrefColumnCount()) {
            columnsOver = message.length();
            this.getTxtAreaConsole().setPrefColumnCount(columnsOver);
        }

        this.getTxtAreaConsole().positionCaret(this.getTxtAreaConsole().getText().length());

    }

    public void limparConsole() {

        this.getTxtAreaConsole().setText("");

    }

    public AnchorPane getPanelContent() {

        return panelContent;
    }

    public TextArea getTxtAreaConsole() {

        return txtAreaConsole;
    }

    public void start() {

        if (capturing) {
            return;
        }

        capturing = true;
        previous = System.out;
        baos = new ByteArrayOutputStream();

        OutputStream outputStreamCombiner =
                new OutputStreamCombiner(Arrays.asList(previous, baos));
        PrintStream custom = new PrintStream(outputStreamCombiner);

        System.setOut(custom);
    }

    private static class OutputStreamCombiner extends OutputStream {

        private List<OutputStream> outputStreams;

        public OutputStreamCombiner(List<OutputStream> outputStreams) {
            this.outputStreams = outputStreams;
        }

        public void write(int b) throws IOException {
            for (OutputStream os : outputStreams) {
                os.write(b);
            }
        }

        public void flush() throws IOException {
            for (OutputStream os : outputStreams) {
                os.flush();
            }
        }

        public void close() throws IOException {
            for (OutputStream os : outputStreams) {
                os.close();
            }
        }
    }

}
