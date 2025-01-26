package myapps.gui;
//

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AnagrafeController extends ControllerBase {

    // UI bindings
    @FXML private TextField txtComune;
    @FXML private TextField txtCerRifiuto;
    @FXML private TextField txtNumeroFormulario;
    @FXML private TextField txtNumeroControllo;
    @FXML private DatePicker dtDataAnalisi;
    @FXML private DatePicker dtDataFormulario;
    @FXML private TextField txtOraInizio;
    @FXML private TextField txtOraFine;
    @FXML private ChoiceBox<String> cboxSfusoInBalle;
    @FXML private ChoiceBox<String> cboxFlusso;
    @FXML private TextField txtMaterialeConferito;

    // data model

}

//public class AnagrafeController {
//

//
//    HashMap<String, String> anagrafe = new HashMap<>();
//
//    public static final int NUM_ANAGRAFE_STRINGS = 13;
//    public static final ArrayList<String> anagrafeStrings = new ArrayList<>(List.of(
//            "Comune", "Numero Controllo", "Cer. rifiuto", "Data Analisi",
//            "Numero Formulario", "Data Formulario", "Ora Inizio", "Ora Fine",
//            "Sfuso/In Balle", "Flusso", "Materiale Conferito", "Analizzatore", "Supervisore"
//    ));
//
//    public AnagrafeController(){
//        initAnagrafe();
//    }
//
//    private void initAnagrafe(){
//        for (String s : anagrafeStrings){
//            anagrafe.put(s, "");
//        }
//    }
//
//    public void updateAnagrafe(){
//        int i=0;
//        anagrafe.put(anagrafeStrings.get(i++), txtComune.getText());
//        anagrafe.put(anagrafeStrings.get(i++), txtNumeroControllo.getText());
//        anagrafe.put(anagrafeStrings.get(i++), txtCerRifiuto.getText());
//        anagrafe.put(anagrafeStrings.get(i++), dtDataAnalisi.getAccessibleText());
//        anagrafe.put(anagrafeStrings.get(i++), txtNumeroFormulario.getText());
//        anagrafe.put(anagrafeStrings.get(i++), dtDataFormulario.getAccessibleText());
//        anagrafe.put(anagrafeStrings.get(i++), txtOraInizio.getText());
//        anagrafe.put(anagrafeStrings.get(i++), txtOraFine.getText());
//        anagrafe.put(anagrafeStrings.get(i++), cboxSfusoInBalle.getAccessibleText());
//        anagrafe.put(anagrafeStrings.get(i++), cboxFlusso.getAccessibleText());
//        anagrafe.put(anagrafeStrings.get(i), txtMaterialeConferito.getText());
//    }
//}
