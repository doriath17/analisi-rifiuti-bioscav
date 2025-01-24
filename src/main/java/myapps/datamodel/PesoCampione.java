package myapps.datamodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import myapps.gui.PositiveDoubleStringConverter;

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
        return (value / pesoCampione.getValue()) * 100;
    }

    public void setupControls(Label lblPesoCampione){
        lblPesoCampione.textProperty().bindBidirectional(pesoCampione, new PositiveDoubleStringConverter());
    }
}
