package com.doriath.application.controllers;

import com.doriath.application.configuration.ConfigOption;
import com.doriath.guicomponents.NumericKeyboard;
import com.doriath.model.InputContainer;
import com.doriath.model.InputRifiuto;
import com.doriath.model.Rifiuto;
import com.doriath.model.stringconverter.WeightStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InputController extends ControllerBase {

    // UI controls
    @FXML private TextField txtPesoLordoImballaggi;
    @FXML private TextField txtPesoTaraImballaggi;
    @FXML private Label lblPesoNettoImballaggi;

    @FXML private TextField txtPesoLordoIndustriali;
    @FXML private TextField txtPesoTaraIndustriali;
    @FXML private Label lblPesoNettoIndustriali;

    @FXML private TextField txtPesoLordoUmido;
    @FXML private TextField txtPesoTaraUmido;
    @FXML private Label lblPesoNettoUmido;

    @FXML private TextField txtPesoLordoVetro;
    @FXML private TextField txtPesoTaraVetro;
    @FXML private Label lblPesoNettoVetro;

    @FXML private TextField txtPesoLordoMedicinali;
    @FXML private TextField txtPesoTaraMedicinali;
    @FXML private Label lblPesoNettoMedicinali;

    @FXML private TextField txtPesoLordoAlluminioAcciaio;
    @FXML private TextField txtPesoTaraAlluminioAcciaio;
    @FXML private Label lblPesoNettoAlluminioAcciaio;

    @FXML private TextField txtPesoLordoFrazioniFini2x2;
    @FXML private TextField txtPesoTaraFrazioniFini2x2;
    @FXML private Label lblPesoNettoFrazioniFini2x2;

    @FXML private TextField txtPesoLordoRaee;
    @FXML private TextField txtPesoTaraRaee;
    @FXML private Label lblPesoNettoRaee;

    @FXML private TextField txtPesoLordoLegno;
    @FXML private TextField txtPesoTaraLegno;
    @FXML private Label lblPesoNettoLegno;

    @FXML private TextField txtPesoLordoCarta;
    @FXML private TextField txtPesoTaraCarta;
    @FXML private Label lblPesoNettoCarta;

    @FXML private TextField txtPesoLordoTessuti;
    @FXML private TextField txtPesoTaraTessuti;
    @FXML private Label lblPesoNettoTessuti;

    @FXML private TextField txtPesoLordoAltreFE;
    @FXML private TextField txtPesoTaraAltreFE;
    @FXML private Label lblPesoNettoAltreFE;

    @FXML private HBox hboxContent;
    @FXML private VBox numKbBox;
    @FXML private NumericKeyboard numKb;

    // data model
    private InputContainer inputContainer;

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        inputContainer = loader.getAnalisiDAO().getInputContainer();
        setupControls();
        configNumericKeyboard();
    }

    private void setupControls() {
        var map = inputContainer.getMap();

        setupControls(
                map.get(Rifiuto.IMBALLAGGI_COREPLA),
                txtPesoLordoImballaggi, txtPesoTaraImballaggi, lblPesoNettoImballaggi
        );

        setupControls(
                map.get(Rifiuto.INDUSTRIALI),
                txtPesoLordoIndustriali, txtPesoTaraIndustriali, lblPesoNettoIndustriali
        );

        setupControls(
                map.get(Rifiuto.ALLUMINIO_ACCIAIO),
                txtPesoLordoAlluminioAcciaio, txtPesoTaraAlluminioAcciaio, lblPesoNettoAlluminioAcciaio
        );

        setupControls(
                map.get(Rifiuto.UMIDO),
                txtPesoLordoUmido, txtPesoTaraUmido, lblPesoNettoUmido
        );

        setupControls(
                map.get(Rifiuto.VETRO),
                txtPesoLordoVetro, txtPesoTaraVetro, lblPesoNettoVetro
        );

        setupControls(
                map.get(Rifiuto.MEDICINALI),
                txtPesoLordoMedicinali, txtPesoTaraMedicinali, lblPesoNettoMedicinali
        );

        setupControls(
                map.get(Rifiuto.FRAZIONI_FINI_2X2),
                txtPesoLordoFrazioniFini2x2, txtPesoTaraFrazioniFini2x2, lblPesoNettoFrazioniFini2x2
        );

        setupControls(
                map.get(Rifiuto.RAEE),
                txtPesoLordoRaee, txtPesoTaraRaee, lblPesoNettoRaee
        );

        setupControls(
                map.get(Rifiuto.LEGNO),
                txtPesoLordoLegno, txtPesoTaraLegno, lblPesoNettoLegno
        );

        setupControls(
                map.get(Rifiuto.CARTA_TETRA_PAK),
                txtPesoLordoCarta, txtPesoTaraCarta, lblPesoNettoCarta
        );

        setupControls(
                map.get(Rifiuto.TESSUTI),
                txtPesoLordoTessuti, txtPesoTaraTessuti, lblPesoNettoTessuti
        );

        setupControls(
                map.get(Rifiuto.ALTRE_FE),
                txtPesoLordoAltreFE, txtPesoTaraAltreFE, lblPesoNettoAltreFE);
    }

    public void setupControls(InputRifiuto waste, TextField txtPesoLordo, TextField txtPesoTara, Label lblPesoNetto){
        txtPesoLordo.setTextFormatter(ControllerBase.getTextFormatterInstance(waste.pesoLordoProperty()));
        txtPesoLordo.setOnAction(event -> {
            waste.updatePesoNetto();
        });

        txtPesoTara.setTextFormatter(ControllerBase.getTextFormatterInstance(waste.pesoTaraProperty()));
        txtPesoTara.setOnAction(event -> {
            waste.updatePesoNetto();
        });

        lblPesoNetto.textProperty().bindBidirectional(waste.pesoNettoProperty(), WeightStringConverter.instance);
    }

    @FXML private void refreshInput(){
        inputContainer.refresh();
    }

    public void configNumericKeyboard(){
        if (config.get(ConfigOption.NUMERIC_KEYBOARD)){
            if (!hboxContent.getChildren().contains(numKbBox)){
                hboxContent.getChildren().add(numKbBox);
            }
        } else {
            hboxContent.getChildren().remove(numKbBox);
        }
    }
}
