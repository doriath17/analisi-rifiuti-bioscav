package com.doriath.application.controllers;

import com.doriath.model.*;
import com.doriath.model.stringconverter.PercentageStringConverter;
import com.doriath.model.stringconverter.PositiveIntegerStringConverter;
import com.doriath.model.stringconverter.WeightStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ResultController extends ControllerBase {

    // UI bindings
    @FXML private Label lblPesoCampione;
    @FXML private Label lblQualityRange;

    @FXML private Label lblMonomaterialeKg;
    @FXML private Label lblMonomaterialePer;

    @FXML private Label lblTracciantiKg;
    @FXML private Label lblTracciantiPer;

    @FXML private Label lblMDiffKg;
    @FXML private Label lblMDiffPer;

    @FXML private Label lblMDiffAllAccKg;
    @FXML private Label lblMDiffAllAccPer;

    @FXML private Label lblMDiffTotKg;
    @FXML private Label lblMDiffTotPer;

    @FXML private Label lblFETotKg;
    @FXML private Label lblFETotPer;

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
        setupControls(resultContainer.getPesoCampione(), lblPesoCampione);
        setupControls(resultContainer.getQualityRange(), lblQualityRange);

        var map = resultContainer.getMap();
        setupControls(map.get(CategoriaRifiuto.MONOMATERIALE), lblMonomaterialeKg, lblMonomaterialePer);
        setupControls(map.get(CategoriaRifiuto.TRACCIANTI), lblTracciantiKg, lblTracciantiPer);
        setupControls(map.get(CategoriaRifiuto.MDIFF_COREPLA),lblMDiffKg, lblMDiffPer);
        setupControls(map.get(CategoriaRifiuto.MDIFF_ALLUMINIO_ACCIAIO), lblMDiffAllAccKg, lblMDiffAllAccPer);
        setupControls(map.get(CategoriaRifiuto.MDIFF_TOTALE),lblMDiffTotKg, lblMDiffTotPer);
        setupControls(map.get(CategoriaRifiuto.FE_TOTALE), lblFETotKg, lblFETotPer);
    }

    public void setupControls(CategoriaRifiutoBase category, Label lblPesoTotale, Label lblPesoPercentuale){
        lblPesoTotale.textProperty().bindBidirectional(category.pesoTotaleProperty(), WeightStringConverter.instance);
        lblPesoPercentuale.textProperty().bindBidirectional(category.pesoPercentualeProperty(), PercentageStringConverter.instance);
    }

    public void setupControls(PesoCampione pesoCampione, Label lblPesoCampione){
        lblPesoCampione.textProperty().bindBidirectional(pesoCampione.getPesoCampione(), WeightStringConverter.instance);
    }

    public void setupControls(QualityRange qr, Label label){
        label.textProperty().bindBidirectional(qr, PositiveIntegerStringConverter.instance);
    }

    @FXML private void openSavePDFStage(){
        loader.getAnalisiDAO().getResultContainer().setNote(txtNote.getText());
        loader.getSavePDFController().onShowing();
        loader.getSavePDFController().getStage().show();
    }
}
