package myapps.gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import myapps.datamodel.AnagrafeAnalisi;
import myapps.datamodel.AnalisiTest;
import myapps.App;
import myapps.datamodel.Analisi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrimaryController {

    @FXML private Label lblPesoCampione;

    // categorie

    @FXML private Label lblPesoTotaleMonomateriale;
    @FXML private Label lblPesoPercentualeMonomateriale;

    @FXML private Label lblPesoTotaleTraccianti;
    @FXML private Label lblPesoPercentualeTraccianti;

    @FXML private Label lblPesoTotaleFrazioniEstranee;
    @FXML private Label lblPesoPercentualeFrazioniEstranee;

    // rifiuti

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

    @FXML private TextField txtPesoLordoInerti;
    @FXML private TextField txtPesoTaraInerti;
    @FXML private Label lblPesoNettoInerti;

    @FXML private TextField txtPesoLordoTessuti;
    @FXML private TextField txtPesoTaraTessuti;
    @FXML private Label lblPesoNettoTessuti;

    // final results
    @FXML private Label lblPesoMDiff;
    @FXML private Label lblPesoPercentualeMDiff;

    @FXML private Label lblPesoFE;
    @FXML private Label lblPesoPercentualeFE;

    // anagrafe
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





    Analisi currentAnalisi;

    // saving
    SavePDFController savePDFController;
    private final Stage savePDFStage;
    HashMap<String, String> anagrafe = new HashMap<>();

    public static final int NUM_ANAGRAFE_STRINGS = 13;
    public static final ArrayList<String> anagrafeStrings = new ArrayList<>(List.of(
            "Comune", "Numero Controllo", "Cer. rifiuto", "Data Analisi",
            "Numero Formulario", "Data Formulario", "Ora Inizio", "Ora Fine",
            "Sfuso/In Balle", "Flusso", "Materiale Conferito", "Analizzatore", "Supervisore"
    ));

    private void initAnagrafe(){
        for (String s : anagrafeStrings){
            anagrafe.put(s, "");
        }
    }

    public void updateAnagrafe(){
        int i=0;
        anagrafe.put(anagrafeStrings.get(i++), txtComune.getText());
        anagrafe.put(anagrafeStrings.get(i++), txtNumeroControllo.getText());
        anagrafe.put(anagrafeStrings.get(i++), txtCerRifiuto.getText());
        anagrafe.put(anagrafeStrings.get(i++), dtDataAnalisi.getAccessibleText());
        anagrafe.put(anagrafeStrings.get(i++), txtNumeroFormulario.getText());
        anagrafe.put(anagrafeStrings.get(i++), dtDataFormulario.getAccessibleText());
        anagrafe.put(anagrafeStrings.get(i++), txtOraInizio.getText());
        anagrafe.put(anagrafeStrings.get(i++), txtOraFine.getText());
        anagrafe.put(anagrafeStrings.get(i++), cboxSfusoInBalle.getAccessibleText());
        anagrafe.put(anagrafeStrings.get(i++), cboxFlusso.getAccessibleText());
        anagrafe.put(anagrafeStrings.get(i), txtMaterialeConferito.getText());
    }

    public PrimaryController() throws IOException {
        currentAnalisi = new AnalisiTest();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("SavePDF.fxml"));
        Parent savePDFRoot = fxmlLoader.load();
        savePDFController = fxmlLoader.getController();

        Scene savePDFScene = new Scene(savePDFRoot);
        savePDFStage = new Stage();
        savePDFStage.setScene(savePDFScene);
        savePDFStage.setAlwaysOnTop(true);

        initAnagrafe();
        savePDFController.setAnagrafe(anagrafe);
        savePDFController.setStage(savePDFStage);
        savePDFController.setCurrentAnalisi(currentAnalisi);
    }


    @FXML public void initialize() {
        currentAnalisi.getPesoCampione().setupControls(lblPesoCampione);

        // categorie

        currentAnalisi.getMonomateriale().setupControls(
                lblPesoTotaleMonomateriale, lblPesoPercentualeMonomateriale
        );

        currentAnalisi.getTraccianti().setupControls(
                lblPesoTotaleTraccianti, lblPesoPercentualeTraccianti
        );

        currentAnalisi.getFrazioniEstranee().setupControls(
                lblPesoTotaleFrazioniEstranee, lblPesoPercentualeFrazioniEstranee
        );

        // rifiuti

        currentAnalisi.getImballaggi().setupControls(
                txtPesoLordoImballaggi, txtPesoTaraImballaggi, lblPesoNettoImballaggi
        );

        currentAnalisi.getIndustriali().setupControls(
                txtPesoLordoIndustriali, txtPesoTaraIndustriali, lblPesoNettoIndustriali
        );

        currentAnalisi.getUmido().setupControls(
                txtPesoLordoUmido, txtPesoTaraUmido, lblPesoNettoUmido
        );

        currentAnalisi.getVetro().setupControls(
                txtPesoLordoVetro, txtPesoTaraVetro, lblPesoNettoVetro
        );

        currentAnalisi.getMedicinali().setupControls(
                txtPesoLordoMedicinali, txtPesoTaraMedicinali, lblPesoNettoMedicinali
        );

        currentAnalisi.getAlluminioAcciaio().setupControls(
                txtPesoLordoAlluminioAcciaio, txtPesoTaraAlluminioAcciaio, lblPesoNettoAlluminioAcciaio
        );

        currentAnalisi.getFrazioniFini2x2().setupControls(
                txtPesoLordoFrazioniFini2x2, txtPesoTaraFrazioniFini2x2, lblPesoNettoFrazioniFini2x2
        );

        currentAnalisi.getRaee().setupControls(
                txtPesoLordoRaee, txtPesoTaraRaee, lblPesoNettoRaee
        );

        currentAnalisi.getLegno().setupControls(
                txtPesoLordoLegno, txtPesoTaraLegno, lblPesoNettoLegno
        );

        currentAnalisi.getInerti().setupControls(
                txtPesoLordoInerti, txtPesoTaraInerti, lblPesoNettoInerti
        );

        currentAnalisi.getTessuti().setupControls(
                txtPesoLordoTessuti, txtPesoTaraTessuti, lblPesoNettoTessuti
        );

        // result
        currentAnalisi.getResult().setupControls(
                lblPesoMDiff, lblPesoPercentualeMDiff, lblPesoFE, lblPesoPercentualeFE
        );
    }


    public static TextFormatter<Double> getTextFormatterInstance(SimpleObjectProperty<Double> toBind){
        var textformatter = new TextFormatter<Double>(new PositiveDoubleStringConverter());
        textformatter.valueProperty().bindBidirectional(toBind);
        return textformatter;
    }

    @FXML private void openSavePDFStage(){
        updateAnagrafe();
        savePDFStage.show();
    }




}
