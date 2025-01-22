package myapps.datamodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import myapps.gui.PositiveDoubleStringConverter;
import myapps.gui.PrimaryController;

public class Rifiuto {
    private CategoriaRifiuto categoria;
    private Analisi currentAnalisi;

    // data
    private SimpleObjectProperty<Double> pesoLordo;
    private SimpleObjectProperty<Double> pesoTara;
    private SimpleObjectProperty<Double> pesoNetto;
    double delta;


    public Rifiuto(Analisi currentAnalisi, CategoriaRifiuto categoria){
        pesoLordo = new SimpleObjectProperty<Double>(0.0);
        pesoTara = new SimpleObjectProperty<Double>(0.0);
        pesoNetto = new SimpleObjectProperty<Double>(0.0);
        delta = 0;

        this.categoria = categoria;
        this.currentAnalisi = currentAnalisi;
    }

    // getters

    public SimpleObjectProperty<Double> getPesoLordo(){
        return pesoLordo;
    }

    public SimpleObjectProperty<Double> getPesoTara() { return pesoTara; }

    public SimpleObjectProperty<Double> getPesoNetto(){
        return pesoNetto;
    }

    private void updateResult(double delta){
        if (categoria.equals(currentAnalisi.getMonomateriale()) ||
                categoria.equals(currentAnalisi.getTraccianti())){
            currentAnalisi.getResult().updatePesoMDiff(delta);
        } else {
            currentAnalisi.getResult().updatePesoFE(delta);
        }
    }

    public void updatePesoNetto(){
        double prev = pesoNetto.getValue();
        pesoNetto.setValue(pesoLordo.getValue() - pesoTara.getValue());
        delta = pesoNetto.getValue() - prev;
        categoria.updatePesoTotale(delta);
        currentAnalisi.updatePesoCampione(delta);
        updateResult(delta);
    }


    public void setupControls(TextField txtPesoLordo, TextField txtPesoTara, Label lblPesoNetto){
        txtPesoLordo.setTextFormatter(PrimaryController.getTextFormatterInstance(pesoLordo));
        txtPesoLordo.setOnAction(event -> {
            updatePesoNetto();
        });

        txtPesoTara.setTextFormatter(PrimaryController.getTextFormatterInstance(pesoTara));
        txtPesoTara.setOnAction(event -> {
            updatePesoNetto();
        });

        lblPesoNetto.textProperty().bindBidirectional(pesoNetto, new PositiveDoubleStringConverter());
    }

}
