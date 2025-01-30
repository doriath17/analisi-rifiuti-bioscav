package myapps.analisibioscav.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import myapps.analisibioscav.datamodel.ResultContainer;

public class ResultController extends ControllerBase {

    // UI bindings
    @FXML private Label lblPesoCampione;
    @FXML private Label lblRangeQ;

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

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        setupControls(loader.getAnalisiDAO().getResultContainer());
    }

    private void setupControls(ResultContainer resultContainer){
        resultContainer.getPesoCampione().setupControls(lblPesoCampione);

        var map = resultContainer.getMap();
        map.get("Materiale Differenziato Totale").setupControls(lblMDiffKg, lblMDiffPer);
        map.get("Frazione Estranea Totale").setupControls(lblFEKg, lblFEPer);
        map.get("Monomateriale").setupControls(lblMonomaterialeKg, lblMonomaterialePer);
        map.get("Traccianti").setupControls(lblTracciantiKg, lblTracciantiPer);
        map.get("Frazioni Estranee").setupControls(lblFrazioniEstraneeKg, lblFrazioniEstraneePer);
    }

    @FXML private void openSavePDFStage(){
        loader.getSavePDFController().onShowing();
        loader.getSavePDFController().getStage().show();
    }
}
