package myapps;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class PrimaryController {
    Analisi currentAnalisi;

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
//    @FXML private TextField txtDataAnalisi;
    @FXML private TextField txtDataFormulario;
    @FXML private TextField txtOraInizio;
    @FXML private TextField txtOraFine;
    @FXML private TextField txtMaterialeConferito;

    // salataggio
    Stage stage2;


    public PrimaryController() throws IOException {
        currentAnalisi = new Analisi();
        Parent root2 = new VBox(new Label("Hello, world!"));
        Scene scene2 = null;
        try {
            scene2 = new Scene(App.loadFXML("SalvaPDF"));
        } catch (Exception e) {}
        stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.setAlwaysOnTop(true);
    }

    @FXML private void openSalvaPDFStage(){
        stage2.show();
    }


    @FXML public void initialize() {

//        btnSalvaPDF.setOnAction(event -> {
//            stage2.show();
//        });

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
}
