package com.doriath.application.gui;
//

import com.doriath.application.datamodel.AnagrafeItem;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import com.doriath.application.datamodel.AnagrafeAnalisi;
import com.doriath.application.datamodel.Updater;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class AnagrafeController extends ControllerBase {

    // UI bindings
    @FXML private TextField txtComune;
    @FXML private TextField txtCerRifiuto;
    @FXML private TextField txtNumeroFormulario;
    @FXML private TextField txtNumeroControllo;
    @FXML private DatePicker dateAnalisi;
    @FXML private DatePicker dateFormulario;
    @FXML private TextField txtOraInizio;
    @FXML private TextField txtOraFine;
    @FXML private ChoiceBox<String> cboxSfusoInBalle;
    @FXML private ChoiceBox<String> cboxFlusso;
    @FXML private TextField txtMaterialeConferito;
    @FXML private TextField txtAnalizzatore;
    @FXML private TextField txtSupervisore;

    private static StringConverter<LocalDate> getLocalDateConverter(){
        return new StringConverter<LocalDate>() {
            String pattern = "dd-MM-yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
    }

    @FXML public void initialize() {
        cboxFlusso.getItems().addAll("FLUSSO A", "FLUSSO B");
        cboxFlusso.setValue("FLUSSO A");
        cboxSfusoInBalle.getItems().addAll("SFUSO", "IN BALLE");
        cboxSfusoInBalle.setValue("SFUSO");
        dateAnalisi.setConverter(getLocalDateConverter());
        dateFormulario.setConverter(getLocalDateConverter());
    }

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        var anagrafe = loader.getAnalisiDAO().getAnagrafeAnalisi();
        anagrafe.setUpdater(new Updater() {

            @Override
            public void update(){
                anagrafe.put(AnagrafeItem.COMUNE, txtComune.getText());
                anagrafe.put(AnagrafeItem.NUM_CONTROLLO, txtNumeroControllo.getText());
                anagrafe.put(AnagrafeItem.CER_RIFIUTO, txtCerRifiuto.getText());
                anagrafe.put(AnagrafeItem.DATA_ANALISI, dateAnalisi.getConverter().toString(dateAnalisi.getValue()));
                anagrafe.put(AnagrafeItem.NUM_FORMULARIO, txtNumeroFormulario.getText());
                anagrafe.put(AnagrafeItem.DATA_FORMULARIO, dateFormulario.getConverter().toString(dateFormulario.getValue()));
                anagrafe.put(AnagrafeItem.SFUSO_IN_BALLE, cboxSfusoInBalle.getValue());
                anagrafe.put(AnagrafeItem.FLUSSO, cboxFlusso.getValue());
                anagrafe.put(AnagrafeItem.ORA_INIZIO, txtOraInizio.getText());
                anagrafe.put(AnagrafeItem.ORA_FINE, txtOraFine.getText());
                anagrafe.put(AnagrafeItem.ANALIZZATORE, txtAnalizzatore.getText());
                anagrafe.put(AnagrafeItem.SUPERVISORE, txtSupervisore.getText());
                anagrafe.put(AnagrafeItem.MATERIALE_CONFERITO, txtMaterialeConferito.getText());
            }
        });
    }
}
