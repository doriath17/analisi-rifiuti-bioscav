package myapps.analisibioscav.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import myapps.analisibioscav.datamodel.CategoriaRifiuto;
import myapps.analisibioscav.datamodel.CategoriaRifiutoBase;
import myapps.analisibioscav.datamodel.ResultContainer;

public class ResultController extends ControllerBase {

    // UI bindings
    @FXML private Label lblPesoCampione;
    @FXML private Label lblQualityRange;

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

    @FXML private TextArea txtNote;

    @FXML public void initialize(){
        txtNote.setPrefColumnCount(100);
        txtNote.setPrefRowCount(3);
    }

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        setupControls(loader.getAnalisiDAO().getResultContainer());
    }

    private void setupControls(ResultContainer resultContainer){
        resultContainer.getPesoCampione().setupControls(lblPesoCampione);
        resultContainer.getQualityRange().setupControls(lblQualityRange);

        var map = resultContainer.getMap();
        map.get(CategoriaRifiuto.MDIFF_TOTALE).setupControls(lblMDiffKg, lblMDiffPer);
        map.get(CategoriaRifiuto.FE_TOTALE).setupControls(lblFEKg, lblFEPer);
        map.get(CategoriaRifiuto.MONOMATERIALE).setupControls(lblMonomaterialeKg, lblMonomaterialePer);
        map.get(CategoriaRifiuto.TRACCIANTI).setupControls(lblTracciantiKg, lblTracciantiPer);
        map.get(CategoriaRifiuto.FE_TOTALE).setupControls(lblFrazioniEstraneeKg, lblFrazioniEstraneePer);
    }

    @FXML private void openSavePDFStage(){
        loader.getAnalisiDAO().getResultContainer().setNote(txtNote.getText());
        loader.getSavePDFController().onShowing();
        loader.getSavePDFController().getStage().show();
    }
}
