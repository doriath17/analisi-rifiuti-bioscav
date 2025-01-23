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

    public final static String a1 = "Comune";
    public final static String a2 = "Numero Controllo";
    public final static String a3 = "CER rifiuto";
    public final static String a4 = "Data Analisi";
    public final static String a5 = "Numero Formulario";
    public final static String a6 = "Data Formulario";
    public final static String a7 = "Ora Inizio";
    public final static String a8 = "Ora Fine";
    public final static String a9 = "Sfuso/In Balle";
    public final static String a10 = "Flusso";
    public final static String a11 = "Materiale Conferito";
    public final static String a12 = "Analizzatore";
    public final static String a13 = "Supervisore";



    private void initAnagrafe(){
        anagrafe.put(a1, "");
        anagrafe.put(a2, "");
        anagrafe.put(a3, "");
        anagrafe.put(a4, "");
        anagrafe.put(a5, "");
        anagrafe.put(a6, "");
        anagrafe.put(a7, "");
        anagrafe.put(a8, "");
        anagrafe.put(a10, "");
        anagrafe.put(a11, "");
        anagrafe.put(a12, "");
        anagrafe.put(a13, "");
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

        lblPesoCampione.textProperty().bindBidirectional(
                currentAnalisi.getPesoCampione(), new PositiveDoubleStringConverter());

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

    public void updateAnagrafe(){
        anagrafe.put(a1, txtComune.getText());
        anagrafe.put(a2, txtNumeroControllo.getText());
        anagrafe.put(a3, txtCerRifiuto.getText());
        anagrafe.put(a4, dtDataAnalisi.getAccessibleText());
        anagrafe.put(a5, txtNumeroFormulario.getText());
        anagrafe.put(a6, dtDataFormulario.getAccessibleText());
        anagrafe.put(a7, txtOraInizio.getText());
        anagrafe.put(a8, txtOraFine.getText());
        anagrafe.put(a9, cboxSfusoInBalle.getAccessibleText());
        anagrafe.put(a10, cboxFlusso.getAccessibleText());
        anagrafe.put(a11, txtMaterialeConferito.getText());
    }


}
