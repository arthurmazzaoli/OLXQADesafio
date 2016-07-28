package view;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Arthur on 26/07/2016.
 */
public class ConsoleLog {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private FormFx formFx;

    public void iniciar(FormFx controller, String mensagem){

        this.formFx = controller;

        formFx.limparConsole();

        exibirMensagem(mensagem);
    }

    public void exibirMensagem(String mensagem){

        formFx.showMessagerTextArea(dateFormat.format(new Date())+" : "+mensagem);

    }

    private static ConsoleLog instance = null;
    public static synchronized ConsoleLog  getInstance(){

        if(instance == null){
            instance = new ConsoleLog();
        }
        return instance;
    }

}
