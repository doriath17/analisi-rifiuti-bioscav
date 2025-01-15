package myapps;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;

public class AnalisiResult {
    private SimpleObjectProperty<Double> pesoCampione;

    // data
    private SimpleObjectProperty<Double> pesoMDiff;
    private SimpleObjectProperty<Double> pesoPercentualeMDiff;
    private SimpleObjectProperty<Double> pesoFE;
    private SimpleObjectProperty<Double> pesoPercentualeFE;


    public AnalisiResult(SimpleObjectProperty<Double> pesoCampione){
        this.pesoCampione = pesoCampione;

        pesoMDiff = new SimpleObjectProperty<>(0.0);
        pesoPercentualeMDiff = new SimpleObjectProperty<>(0.0);
        pesoFE = new SimpleObjectProperty<>(0.0);
        pesoPercentualeFE = new SimpleObjectProperty<>(0.0);
    }

    // exopising the properties
    public Double getPesoMDiff(){
        return pesoMDiff.get();
    }

    public SimpleObjectProperty<Double> pesoMDiffProperty() {
        return pesoMDiff;
    }

    public Double getPesoPercentualeMDiff() {
        return pesoPercentualeMDiff.get();
    }

    public SimpleObjectProperty<Double> pesoPercentualeMDiffProperty() {
        return pesoPercentualeMDiff;
    }

    public Double getPesoFE() {
        return pesoFE.get();
    }

    public SimpleObjectProperty<Double> pesoFEProperty() {
        return pesoFE;
    }

    public Double getPesoPercentualeFE() {
        return pesoPercentualeFE.get();
    }

    public SimpleObjectProperty<Double> pesoPercentualeFEProperty() {
        return pesoPercentualeFE;
    }

    private void updatePercentuale(){
        if (pesoCampione.getValue() != 0){
            pesoPercentualeMDiff.setValue(pesoMDiff.getValue() / pesoCampione.getValue() * 100);
            pesoPercentualeFE.setValue(pesoFE.getValue() / pesoCampione.getValue() * 100);
        } else {
            pesoPercentualeMDiff.setValue(0.0);
            pesoPercentualeFE.setValue(0.0);
        }
    }

    public void updatePesoMDiff(double delta){
        pesoMDiff.setValue(pesoMDiff.getValue() + delta);
        updatePercentuale();
    }

    public void updatePesoFE(double delta){
        pesoFE.setValue(pesoFE.getValue() + delta);
        updatePercentuale();
    }

    public void setupControls(Label lblPesoMDiff, Label lblPesoPercentualeMDiff, Label lblPesoFE, Label lblPesoPercentualeFE){
        lblPesoMDiff.textProperty().bindBidirectional(pesoMDiff, new PositiveDoubleStringConverter());
        lblPesoPercentualeMDiff.textProperty().bindBidirectional(pesoPercentualeMDiff, new PositiveDoubleStringConverter());
        lblPesoFE.textProperty().bindBidirectional(pesoFE, new PositiveDoubleStringConverter());
        lblPesoPercentualeFE.textProperty().bindBidirectional(pesoPercentualeFE, new PositiveDoubleStringConverter());
    }
}
