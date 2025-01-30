package myapps.analisibioscav.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class InputContainer {
    public static final int NUM_RIFIUTI = 11;
    private final HashMap<String, Rifiuto> rifiuti = new HashMap<>();

    public static final List<String> names = new ArrayList<>(List.of(
            "Imballaggi COREPLA", "Industriali", "Umido",
            "Vetro", "Medicinali", "Alluminio/Acciaio",
            "Frazioni Fini 2x2", "RAEE", "Legno",
            "Inerti", "Tessuti", "Altre FE"
    ));

    public InputContainer(){
        for (String name : names){
            rifiuti.put(name, new Rifiuto(name));
        }
    }

    public HashMap<String, Rifiuto> getMap(){
        return rifiuti;
    }

    public void setResultContainer(ResultContainer resultContainer){
        var map = resultContainer.getMap();
        Iterator<String> i = names.iterator();
        rifiuti.get(i.next()).setResultContainer(resultContainer, (CategoriaRifiuto) map.get("Monomateriale"));
        rifiuti.get(i.next()).setResultContainer(resultContainer, (CategoriaRifiuto) map.get("Traccianti"));
        for (; i.hasNext();){
            rifiuti.get(i.next()).setResultContainer(resultContainer, (CategoriaRifiuto) map.get("Frazioni Estranee"));
        }
    }

    public void reset(){
        for (var i : rifiuti.values()){
            i.reset();
        }
    }

    public void refresh(){
        for (var i : rifiuti.values()){
            i.updatePesoNetto();
        }
    }
}
