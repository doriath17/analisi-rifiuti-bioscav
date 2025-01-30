package myapps.analisibioscav.datamodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import myapps.analisibioscav.gui.ControllerBase;
import myapps.analisibioscav.gui.PositiveDoubleStringConverter;

import java.util.Random;

public class Rifiuto {
    private CategoriaRifiuto categoria;
    private ResultContainer resultContainer;

    // data
    private final String name;
    private final SimpleObjectProperty<Double> pesoLordo = new SimpleObjectProperty<Double>(0.0);
    private final SimpleObjectProperty<Double> pesoTara = new SimpleObjectProperty<Double>(0.0);
    private final SimpleObjectProperty<Double> pesoNetto = new SimpleObjectProperty<Double>(0.0);
    private double delta = 0;

    public Rifiuto(String name){
        this.name = name;
    }

    public void setResultContainer(ResultContainer resultContainer, CategoriaRifiuto categoria){
        this.resultContainer = resultContainer;
        this.categoria = categoria;
    }

    public void randomSetup(){
        Random rand = new Random();
        pesoTara.setValue(rand.nextInt(50) + 1 + rand.nextDouble());
        pesoLordo.setValue(pesoTara.getValue() + rand.nextInt(50) + 1 + rand.nextDouble());
    }

    // getters

    public String getName() {
        return name;
    }

    public SimpleObjectProperty<Double> getPesoLordo(){
        return pesoLordo;
    }

    public SimpleObjectProperty<Double> getPesoTara() { return pesoTara; }

    public SimpleObjectProperty<Double> getPesoNetto(){
        return pesoNetto;
    }

    public void updatePesoNetto(){
        double prev = pesoNetto.getValue();
        pesoNetto.setValue(pesoLordo.getValue() - pesoTara.getValue());
        delta = pesoNetto.getValue() - prev;
        resultContainer.getPesoCampione().updatePesoCampione(delta);
        categoria.updatePesoTotale(delta);
        resultContainer.updatePercentualiCategorie();
    }

    public void setupControls(TextField txtPesoLordo, TextField txtPesoTara, Label lblPesoNetto){
        txtPesoLordo.setTextFormatter(ControllerBase.getTextFormatterInstance(pesoLordo));
        txtPesoLordo.setOnAction(event -> {
            updatePesoNetto();
        });

        txtPesoTara.setTextFormatter(ControllerBase.getTextFormatterInstance(pesoTara));
        txtPesoTara.setOnAction(event -> {
            updatePesoNetto();
        });

        lblPesoNetto.textProperty().bindBidirectional(pesoNetto, new PositiveDoubleStringConverter());
    }

    public void reset(){
        pesoLordo.setValue(0.0);
        pesoTara.setValue(0.0);
        pesoNetto.setValue(0.0);
    }

}
