package myapps;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Rifiuto {
    private SimpleObjectProperty<Double> pesoLordo;
    private SimpleObjectProperty<Double> pesoTara;
    private SimpleObjectProperty<Double> pesoNetto;

    private CategoriaRifiuto categoria;

    private Analisi currentAnalisi;


    public Rifiuto(Analisi currentAnalisi, CategoriaRifiuto categoria){
        pesoLordo = new SimpleObjectProperty<Double>(0.0);
        pesoTara = new SimpleObjectProperty<Double>(0.0);
        pesoNetto = new SimpleObjectProperty<Double>(0.0);

        this.categoria = categoria;
        this.currentAnalisi = currentAnalisi;
    }


    public SimpleObjectProperty<Double> pesoLordoProperty(){
        return pesoLordo;
    }

    public SimpleObjectProperty<Double> pesoTaraProperty() { return pesoTara; }

    public SimpleObjectProperty<Double> pesoNettoProperty(){
        return pesoNetto;
    }


    public void updatePesoNetto(){
        pesoNetto.setValue(pesoLordo.getValue() + pesoTara.getValue());
    }


    public void setupControls(TextField txtPesoLordo, TextField txtPesoTara, Label lblPesoNetto){
        txtPesoLordo.setTextFormatter(PrimaryController.getTextFormatterInstance(pesoLordo));
        txtPesoLordo.setOnAction(event -> {
            updatePesoNetto();
            currentAnalisi.updatePesoCampione();
        });

        txtPesoTara.setTextFormatter(PrimaryController.getTextFormatterInstance(pesoTara));
        txtPesoTara.setOnAction(event -> {
            updatePesoNetto();
            currentAnalisi.updatePesoCampione();
        });

        lblPesoNetto.textProperty().bindBidirectional(pesoNetto, new PositiveDoubleStringConverter());
    }

}
