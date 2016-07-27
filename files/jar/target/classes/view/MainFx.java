package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.FileSystems;

/**
 * Created by Arthur on 26/07/2016.
 */
public class MainFx extends Application {

    private FormFx formFx;

    @Override
    public void start(Stage primaryStage) throws Exception {

        formFx = new FormFx();

        Scene scene = new Scene(formFx.getPanelContent());

        primaryStage.setTitle("Desafio QA - OLX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(MainFx.class);

    }

}
