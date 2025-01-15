package myapps;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class CategoriaRifiuto {
    private Analisi currentAnalisi;
    private List<Rifiuto> rifiuti;

    // data
    private SimpleObjectProperty<Double> pesoTotale;
    private SimpleObjectProperty<Double> pesoPercentuale;


    public CategoriaRifiuto(Analisi currentAnalisi){
        this.currentAnalisi = currentAnalisi;
        rifiuti = new ArrayList<>();

        pesoTotale = new SimpleObjectProperty<>(0.0);
        pesoPercentuale = new SimpleObjectProperty<>(0.0);

    }

    public SimpleObjectProperty<Double> getPesoTotale() {
        return pesoTotale;
    }

    public SimpleObjectProperty<Double> getPesoPercentuale() {
        return pesoPercentuale;
    }
    public void register(Rifiuto rifiuto){
        rifiuti.add(rifiuto);
    }

    public void setRifiuti(List<Rifiuto> rifuti){
        this.rifiuti = rifuti;
    }

    public void updatePesoTotale(double delta){
        pesoTotale.setValue(pesoTotale.getValue() + delta);
        if (pesoTotale.getValue() != 0.0){
            pesoPercentuale.setValue(pesoTotale.getValue() / currentAnalisi.getPesoCampione().getValue());
        }
    }

    public void setupControls(Label lblPesoTotale, Label lblPesoPercentuale){
        lblPesoTotale.textProperty().bindBidirectional(pesoTotale, new PositiveDoubleStringConverter());
        lblPesoPercentuale.textProperty().bindBidirectional(pesoPercentuale, new PositiveDoubleStringConverter());
    }

}
