package myapps;

import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.List;

public class CategoriaRifiuto {
    private SimpleObjectProperty<Double> pesoTotale;
    private SimpleObjectProperty<Double> pesoPercentuale;

    private Analisi currentAnalisi;
    private List<Rifiuto> rifiuti;

    public CategoriaRifiuto(Analisi currentAnalisi){
        this.currentAnalisi = currentAnalisi;

        pesoTotale = new SimpleObjectProperty<>(0.0);
        pesoPercentuale = new SimpleObjectProperty<>(0.0);

        rifiuti = new ArrayList<>();
    }

    public void register(Rifiuto rifiuto){
        rifiuti.add(rifiuto);
    }

    public void setRifiuti(List<Rifiuto> rifuti){
        this.rifiuti = rifuti;
    }

    public SimpleObjectProperty<Double> pesoTotaleProperty() {
        return pesoTotale;
    }

    public SimpleObjectProperty<Double> pesoPercentualeProperty() {
        return pesoPercentuale;
    }


}
