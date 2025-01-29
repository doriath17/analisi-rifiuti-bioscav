package myapps.analisibioscav.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import myapps.analisibioscav.datamodel.InputContainer;

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

    @FXML private TextField txtPesoLordoInerti;
    @FXML private TextField txtPesoTaraInerti;
    @FXML private Label lblPesoNettoInerti;

    @FXML private TextField txtPesoLordoTessuti;
    @FXML private TextField txtPesoTaraTessuti;
    @FXML private Label lblPesoNettoTessuti;

    @FXML private TextField txtPesoLordoAltreFE;
    @FXML private TextField txtPesoTaraAltreFE;
    @FXML private Label lblPesoNettoAltreFE;

    // data model
    private InputContainer inputContainer = new InputContainer();


    @FXML public void initialize() {
        var map = inputContainer.getMap();

        map.get("Imballaggi COREPLA").setupControls(
                txtPesoLordoImballaggi, txtPesoTaraImballaggi, lblPesoNettoImballaggi
        );

        map.get("Industriali").setupControls(
                txtPesoLordoIndustriali, txtPesoTaraIndustriali, lblPesoNettoIndustriali
        );

        map.get("Umido").setupControls(
                txtPesoLordoUmido, txtPesoTaraUmido, lblPesoNettoUmido
        );

        map.get("Vetro").setupControls(
                txtPesoLordoVetro, txtPesoTaraVetro, lblPesoNettoVetro
        );

        map.get("Medicinali").setupControls(
                txtPesoLordoMedicinali, txtPesoTaraMedicinali, lblPesoNettoMedicinali
        );

        map.get("Alluminio/Acciaio").setupControls(
                txtPesoLordoAlluminioAcciaio, txtPesoTaraAlluminioAcciaio, lblPesoNettoAlluminioAcciaio
        );

        map.get("Frazioni Fini 2x2").setupControls(
                txtPesoLordoFrazioniFini2x2, txtPesoTaraFrazioniFini2x2, lblPesoNettoFrazioniFini2x2
        );

        map.get("RAEE").setupControls(
                txtPesoLordoRaee, txtPesoTaraRaee, lblPesoNettoRaee
        );

        map.get("Legno").setupControls(
                txtPesoLordoLegno, txtPesoTaraLegno, lblPesoNettoLegno
        );

        map.get("Inerti").setupControls(
                txtPesoLordoInerti, txtPesoTaraInerti, lblPesoNettoInerti
        );

        map.get("Tessuti").setupControls(
                txtPesoLordoTessuti, txtPesoTaraTessuti, lblPesoNettoTessuti
        );

        map.get("Altre FE").setupControls(txtPesoLordoAltreFE, txtPesoTaraAltreFE, lblPesoNettoAltreFE);
    }

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        inputContainer.setResultContainer(loader.getResultController().getResultContainer());
    }

    public InputContainer getInputContainer(){
        return this.inputContainer;
    }
}
