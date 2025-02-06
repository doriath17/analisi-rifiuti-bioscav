package com.doriath.application.gui;

import com.doriath.application.configuration.ConfigOption;
import com.doriath.guicomponents.NumericKeyboard;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.doriath.application.datamodel.InputContainer;
import com.doriath.application.datamodel.Rifiuto;
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

        map.get(Rifiuto.IMBALLAGGI_COREPLA).setupControls(
                txtPesoLordoImballaggi, txtPesoTaraImballaggi, lblPesoNettoImballaggi
        );

        map.get(Rifiuto.INDUSTRIALI).setupControls(
                txtPesoLordoIndustriali, txtPesoTaraIndustriali, lblPesoNettoIndustriali
        );

        map.get(Rifiuto.ALLUMINIO_ACCIAIO).setupControls(
                txtPesoLordoAlluminioAcciaio, txtPesoTaraAlluminioAcciaio, lblPesoNettoAlluminioAcciaio
        );

        map.get(Rifiuto.UMIDO).setupControls(
                txtPesoLordoUmido, txtPesoTaraUmido, lblPesoNettoUmido
        );

        map.get(Rifiuto.VETRO).setupControls(
                txtPesoLordoVetro, txtPesoTaraVetro, lblPesoNettoVetro
        );

        map.get(Rifiuto.MEDICINALI).setupControls(
                txtPesoLordoMedicinali, txtPesoTaraMedicinali, lblPesoNettoMedicinali
        );

        map.get(Rifiuto.FRAZIONI_FINI_2X2).setupControls(
                txtPesoLordoFrazioniFini2x2, txtPesoTaraFrazioniFini2x2, lblPesoNettoFrazioniFini2x2
        );

        map.get(Rifiuto.RAEE).setupControls(
                txtPesoLordoRaee, txtPesoTaraRaee, lblPesoNettoRaee
        );

        map.get(Rifiuto.LEGNO).setupControls(
                txtPesoLordoLegno, txtPesoTaraLegno, lblPesoNettoLegno
        );

        map.get(Rifiuto.CARTA_TETRA_PAK).setupControls(
                txtPesoLordoCarta, txtPesoTaraCarta, lblPesoNettoCarta
        );

        map.get(Rifiuto.TESSUTI).setupControls(
                txtPesoLordoTessuti, txtPesoTaraTessuti, lblPesoNettoTessuti
        );

        map.get(Rifiuto.ALTRE_FE).setupControls(
                txtPesoLordoAltreFE, txtPesoTaraAltreFE, lblPesoNettoAltreFE);
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
