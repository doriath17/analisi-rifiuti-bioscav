package com.doriath.model;

import javafx.beans.property.SimpleObjectProperty;

public class PesoCampione {

    // hello
    private final SimpleObjectProperty<Double> pesoCampione = new SimpleObjectProperty<>(0.0);

    public SimpleObjectProperty<Double> getPesoCampione() {
        return pesoCampione;
    }

    public void updatePesoCampione(double delta){
        pesoCampione.setValue(pesoCampione.getValue() + delta);
    }

    public Double getPercentage(double value){
        if (pesoCampione.getValue() == 0.0){
            return 0.0;
        } else {
            return (value / pesoCampione.getValue()) * 100;
        }
    }
}
