package com.doriath.model;

import javafx.beans.property.SimpleObjectProperty;

public class InputRifiuto {
    private CategoriaRifiutoBase categoria;
    private ResultContainer resultContainer;

    // data
    private final SimpleObjectProperty<Double> pesoLordo = new SimpleObjectProperty<Double>(0.0);
    private final SimpleObjectProperty<Double> pesoTara = new SimpleObjectProperty<Double>(0.0);
    private final SimpleObjectProperty<Double> pesoNetto = new SimpleObjectProperty<Double>(0.0);
    private double delta = 0;

    public void setResults(ResultContainer resultContainer, CategoriaRifiutoBase categoria){
        this.resultContainer = resultContainer;
        this.categoria = categoria;
    }

    // getters

    public Double getPesoLordo(){
        return pesoLordo.getValue();
    }

    public Double getPesoTara() { return pesoTara.getValue(); }

    public Double getPesoNetto(){
        return pesoNetto.getValue();
    }

    public SimpleObjectProperty<Double> pesoLordoProperty() {
        return pesoLordo;
    }

    public SimpleObjectProperty<Double> pesoTaraProperty() {
        return pesoTara;
    }

    public SimpleObjectProperty<Double> pesoNettoProperty() {
        return pesoNetto;
    }

    public void loadValues(Double lordo, Double tara){
        pesoLordo.setValue(lordo);
        pesoTara.setValue(tara);
        updatePesoNetto();
    }

    public void updatePesoNetto(){
        double prev = pesoNetto.getValue();
        pesoNetto.setValue(pesoLordo.getValue() - pesoTara.getValue());
        delta = pesoNetto.getValue() - prev;
        resultContainer.getPesoCampione().updatePesoCampione(delta);
        categoria.updatePesoTotale(delta);
        resultContainer.updatePercentualiCategorie();
    }

    public void reset(){
        pesoLordo.setValue(0.0);
        pesoTara.setValue(0.0);
        pesoNetto.setValue(0.0);
    }

}
