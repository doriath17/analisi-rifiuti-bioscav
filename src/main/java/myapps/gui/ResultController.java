package myapps.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import myapps.datamodel.ResultContainer;

import java.io.IOException;
import java.util.HashMap;

public class ResultController extends ControllerBase {

    // UI bindings
    @FXML private Label lblPesoCampione;

    @FXML private Label lblMonomaterialeKg;
    @FXML private Label lblMonomaterialePer;

    @FXML private Label lblTracciantiKg;
    @FXML private Label lblTracciantiPer;

    @FXML private Label lblFrazioniEstraneeKg;
    @FXML private Label lblFrazioniEstraneePer;

    @FXML private Label lblMDiffKg;
    @FXML private Label lblMDiffPer;

    @FXML private Label lblFEKg;
    @FXML private Label lblFEPer;

    @FXML private Button btnSavePDF;

    // data model
    private ResultContainer resultContainer = new ResultContainer();

    public ResultController() throws IOException {
//        savePDFController.setAnagrafe(anagrafe);
//        savePDFController.setStage(savePDFStage);
//        savePDFController.setCurrentAnalisi(currentAnalisi);
    }

    @FXML public void initialize(){
        resultContainer.getPesoCampione().setupControls(lblPesoCampione);

        var map = resultContainer.getMap();
        map.get("Materiale Differenziato Totale").setupControls(lblMDiffKg, lblMDiffPer);
        map.get("Frazione Estranea Totale").setupControls(lblFEKg, lblFEPer);
        map.get("Monomateriale").setupControls(lblMonomaterialeKg, lblMonomaterialePer);
        map.get("Traccianti").setupControls(lblTracciantiKg, lblTracciantiPer);
        map.get("Frazioni Estranee").setupControls(lblFrazioniEstraneeKg, lblFrazioniEstraneePer);
    }

    public ResultContainer getResultContainer() {
        return resultContainer;
    }

    @FXML private void openSavePDFStage(){
        loader.getSavePDFController().getStage().show();
    }
}
