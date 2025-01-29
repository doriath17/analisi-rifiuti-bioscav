package myapps.analisibioscav.datamodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import myapps.analisibioscav.gui.PositiveDoubleStringConverter;

public class CategoriaRifiutoBase {
    protected ResultContainer resultContainer;

    // data
    protected final String name;
    protected SimpleObjectProperty<Double> pesoTotale = new SimpleObjectProperty<>(0.0);
    protected SimpleObjectProperty<Double> pesoPercentuale = new SimpleObjectProperty<>(0.0);

    public CategoriaRifiutoBase(String name, ResultContainer resultContainer){
        this.name = name;
        this.resultContainer = resultContainer;
    }

    public String getName() {
        return name;
    }

    public SimpleObjectProperty<Double> getPesoTotale() {
        return pesoTotale;
    }

    public SimpleObjectProperty<Double> getPesoPercentuale() {
        return pesoPercentuale;
    }

    public void updatePesoTotale(double delta){
        pesoTotale.setValue(pesoTotale.getValue() + delta);
    }

    public void updatePesoPercentuale(){
        pesoPercentuale.setValue(
                resultContainer.getPesoCampione().getPercentage(pesoTotale.getValue())
        );
    }

    public void setupControls(Label lblPesoTotale, Label lblPesoPercentuale){
        lblPesoTotale.textProperty().bindBidirectional(pesoTotale, new PositiveDoubleStringConverter());
        lblPesoPercentuale.textProperty().bindBidirectional(pesoPercentuale, new PositiveDoubleStringConverter());
    }
}
