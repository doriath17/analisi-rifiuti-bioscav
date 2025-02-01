package com.doriath.application.gui;
//

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
                var map = anagrafe.getMap();
                Iterator<String> i = AnagrafeAnalisi.names.iterator();
                map.put("Comune",  txtComune.getText());
                map.put("Numero Controllo", txtNumeroControllo.getText());
                map.put("CER Rifiuto", txtCerRifiuto.getText());
                map.put("Data Analisi", dateAnalisi.getConverter().toString(dateAnalisi.getValue()));
                map.put("Formulario N°", txtNumeroFormulario.getText());
                map.put("Data Formulario", dateFormulario.getConverter().toString(dateFormulario.getValue()));
                map.put("Ora Inizio", txtOraInizio.getText());
                map.put("Ora Fine", txtOraFine.getText());
                map.put("Sfuso/In Balle", cboxSfusoInBalle.getValue());
                map.put("Flusso", cboxFlusso.getValue());
                map.put("Materiale Conferito", txtMaterialeConferito.getText());
                map.put("Analizzatore", txtAnalizzatore.getText());
                map.put("In presenza di: ", txtSupervisore.getText());
            }

        });
    }
}
