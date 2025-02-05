package com.doriath.application.gui;
//

import com.doriath.application.datamodel.AnagrafeItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public static final StringConverter<LocalDate> localDateStringConverter = getLocalDateConverter();

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
        txtComune.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.COMUNE));
        txtNumeroControllo.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.NUM_CONTROLLO));
        txtCerRifiuto.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.CER_RIFIUTO));
        txtNumeroFormulario.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.NUM_FORMULARIO));
        cboxSfusoInBalle.valueProperty().bindBidirectional(anagrafe.get(AnagrafeItem.SFUSO_IN_BALLE));
        cboxFlusso.valueProperty().bindBidirectional(anagrafe.get(AnagrafeItem.FLUSSO));
        txtOraInizio.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.ORA_INIZIO));
        txtOraFine.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.ORA_FINE));
        txtAnalizzatore.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.ANALIZZATORE));
        txtSupervisore.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.SUPERVISORE));
        txtMaterialeConferito.textProperty().bindBidirectional(anagrafe.get(AnagrafeItem.MATERIALE_CONFERITO));

        dateAnalisi.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                anagrafe.get(AnagrafeItem.DATA_ANALISI)
                        .setValue(localDateStringConverter.toString(dateAnalisi.getValue()));
            }
        });
        dateFormulario.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                anagrafe.get(AnagrafeItem.DATA_FORMULARIO)
                        .setValue(localDateStringConverter.toString(dateFormulario.getValue()));
            }
        });
        anagrafe.syncController(dateAnalisi.valueProperty(), dateFormulario.valueProperty());
    }
}
