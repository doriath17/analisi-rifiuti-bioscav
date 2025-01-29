package myapps.analisibioscav.gui;
//

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import myapps.analisibioscav.datamodel.AnagrafeAnalisi;

import java.util.Iterator;

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
    private AnagrafeAnalisi anagrafe = new AnagrafeAnalisi();

    public AnagrafeAnalisi getAnagrafe() {
        return anagrafe;
    }

    public void updateAnagrafe(){
        var map = anagrafe.getMap();
        Iterator<String> i = AnagrafeAnalisi.names.iterator();
        map.put("Comune",  txtComune.getText());
        map.put("Numero Controllo", txtNumeroControllo.getText());
        map.put("CER Rifiuto", txtCerRifiuto.getText());
        map.put("Data Analisi", dtDataAnalisi.getAccessibleText());
        map.put("Formulario N°", txtNumeroFormulario.getText());
        map.put("Data Formulario", dtDataFormulario.getAccessibleText());
        map.put("Ora Inizio", txtOraInizio.getText());
        map.put("Ora Fine", txtOraFine.getText());
        map.put("Sfuso/In Balle", cboxSfusoInBalle.getAccessibleText());
        map.put("Flusso", cboxFlusso.getAccessibleText());
        map.put("Materiale Conferito", txtMaterialeConferito.getText());
    }
}
