package myapps.analisibioscav.datamodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import myapps.analisibioscav.gui.PositiveDoubleStringConverter;

import java.util.List;

public class CategoriaRifiutoBase {
    private final PesoCampione pesoCampione;
    private final SimpleObjectProperty<Double> pesoTotale = new SimpleObjectProperty<>(0.0);
    private final SimpleObjectProperty<Double> pesoPercentuale = new SimpleObjectProperty<>(0.0);
    private final CategoriaRifiutoBase base;

    public CategoriaRifiutoBase(PesoCampione pesoCampione){
        this.pesoCampione = pesoCampione;
        base = null;
    }

    public CategoriaRifiutoBase(PesoCampione pesoCampione, CategoriaRifiutoBase base){
        this.pesoCampione = pesoCampione;
        this.base = base;
    }

    public Double getPesoTotale() {
        return pesoTotale.getValue();
    }

    public Double getPesoPercentuale() {
        return pesoPercentuale.getValue();
    }

    public void updatePesoTotale(double delta){
        pesoTotale.setValue(pesoTotale.getValue() + delta);
        if (base != null){
            base.updatePesoTotale(delta);
        }
    }

    public void updatePesoPercentuale(){
        pesoPercentuale.setValue(
                pesoCampione.getPercentage(pesoTotale.getValue())
        );
    }

    public void setupControls(Label lblPesoTotale, Label lblPesoPercentuale){
        lblPesoTotale.textProperty().bindBidirectional(pesoTotale, new PositiveDoubleStringConverter());
        lblPesoPercentuale.textProperty().bindBidirectional(pesoPercentuale, new PositiveDoubleStringConverter());
    }

    public void reset(){
        pesoTotale.setValue(0.0);
        pesoPercentuale.setValue(0.0);
    }
}
