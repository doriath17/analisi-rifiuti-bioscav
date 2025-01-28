package myapps.datamodel;

import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ResultContainer {
    private final PesoCampione pesoCampione = new PesoCampione();
    private final SimpleObjectProperty<Double> rangeQ= new SimpleObjectProperty<>(0.0);

    public static final int NUM_CATEGORIE = 5;
    protected final HashMap<String, CategoriaRifiutoBase> categorie = new HashMap<>();

    public static final List<String> names = new ArrayList<>(List.of(
            "Materiale Differenziato Totale", "Frazione Estranea Totale", "Monomateriale",
            "Traccianti", "Frazioni Estranee"
    ));

    public ResultContainer() {
        categorie.put("Materiale Differenziato Totale",
                new CategoriaRifiutoBase("Materiale Differenziato Totale", this));
        categorie.put("Frazione Estranea Totale",
                new CategoriaRifiutoBase("Frazione Estranea Totale", this));
        categorie.put("Monomateriale",
                (CategoriaRifiutoBase) new CategoriaRifiuto(
                        "Monomateriale", this,  categorie.get("Materiale Differenziato Totale")
                ));
        categorie.put("Traccianti",
                (CategoriaRifiutoBase) new CategoriaRifiuto(
                        "Traccianti", this,  categorie.get("Materiale Differenziato Totale")
                ));
        categorie.put("Frazioni Estranee",
                (CategoriaRifiutoBase) new CategoriaRifiuto(
                        "Frazioni Estranee", this,  categorie.get("Frazione Estranea Totale")
                ));
    }

    // peso campione

    public PesoCampione getPesoCampione() {
        return pesoCampione;
    }

    public SimpleObjectProperty<Double> rangeQProperty() {
        return rangeQ;
    }

    public HashMap<String, CategoriaRifiutoBase> getMap(){
        return categorie;
    }

    public void updatePercentualiCategorie(){
        for (CategoriaRifiutoBase categoria : categorie.values()){
            categoria.updatePesoPercentuale();
        }
    }
}
