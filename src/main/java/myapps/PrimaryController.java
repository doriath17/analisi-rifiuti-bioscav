package myapps;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class PrimaryController {
    Analisi currentAnalisi;

    @FXML private Label lblPesoCampione;

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


    public PrimaryController(){
        currentAnalisi = new Analisi();
    }


    @FXML public void initialize() {
        lblPesoCampione.textProperty().bindBidirectional(
                currentAnalisi.pesoCampioneProperty(), new PositiveDoubleStringConverter());

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
    }


    public static TextFormatter<Double> getTextFormatterInstance(SimpleObjectProperty<Double> toBind){
        var textformatter = new TextFormatter<Double>(new PositiveDoubleStringConverter());
        textformatter.valueProperty().bindBidirectional(toBind);
        return textformatter;
    }
}
