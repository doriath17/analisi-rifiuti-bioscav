package myapps.datamodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import myapps.gui.PositiveDoubleStringConverter;
import myapps.gui.PrimaryController;
import java.util.Random;

public class Rifiuto {
    private CategoriaRifiutoBase categoria;
    private Analisi currentAnalisi;

    // data
    private final String name;
    private final SimpleObjectProperty<Double> pesoLordo;
    private final SimpleObjectProperty<Double> pesoTara;
    private final SimpleObjectProperty<Double> pesoNetto;
    private double delta;


    public Rifiuto(String name, Analisi currentAnalisi, CategoriaRifiutoBase categoria){
        this.name = name;
        this.categoria = categoria;
        this.currentAnalisi = currentAnalisi;

        pesoLordo = new SimpleObjectProperty<Double>(0.0);
        pesoTara = new SimpleObjectProperty<Double>(0.0);
        pesoNetto = new SimpleObjectProperty<Double>(0.0);
        delta = 0;
    }

    public void randomSetup(){
        Random rand = new Random();
        pesoTara.setValue(rand.nextInt(50) + 1 + rand.nextDouble());
        pesoLordo.setValue(pesoTara.getValue() + rand.nextInt(50) + 1 + rand.nextDouble());
        updatePesoNetto();
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
        currentAnalisi.updatePesoCampione(delta);
        categoria.updatePesoTotale(delta);
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
