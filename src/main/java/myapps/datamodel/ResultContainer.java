package myapps.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultContainer {
    private final PesoCampione pesoCampione = new PesoCampione();

    public static final int NUM_CATEGORIE = 5;
    protected final HashMap<String, CategoriaRifiutoBase> categorie = new HashMap<>();

    public static final List<String> names = new ArrayList<>(List.of(
            "Materiale Differenziato Totale", "Frazione Estranea Totale", "Monomateriale",
            "Traccianti", "Frazioni Estranee"
    ));

    public ResultContainer() {
        for (String name : names){
            categorie.put(name, new CategoriaRifiutoBase(name, this));
        }
    }

    // peso campione

    public PesoCampione getPesoCampione() {
        return pesoCampione;
    }

    public void updatePesoCampione(double delta){
        pesoCampione.updatePesoCampione(delta);
    }

    public HashMap<String, CategoriaRifiutoBase> getCategorie(){
        return categorie;
    }

    public void updatePercentualiCategorie(){
        for (CategoriaRifiutoBase categoria : categorie.values()){
            categoria.updatePesoPercentuale();
        }
    }
}
