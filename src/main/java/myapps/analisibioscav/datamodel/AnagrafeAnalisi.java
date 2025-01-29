package myapps.analisibioscav.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagrafeAnalisi {
    public final int NUM_STRING = 14;
    private ArrayList<String> keys = new ArrayList<>(NUM_STRING);
    private ArrayList<String> values = new ArrayList<>(NUM_STRING);

    private HashMap<String, String> map = new HashMap<>();

    public static final List<String> names = new ArrayList<>(List.of(
       "Comune", "Numero Controllo",
        "CER Rifiuto", "Data Analisi",
        "Formulario N°", "Data Formulario",
        "Sfuso/In Balle", "Flusso",
        "Ora Inizio", "Ora Fine",
        "Analizzatore", "In presenza di: ",
        "Materiale Conferito (Kg)"
    ));

    public AnagrafeAnalisi(){
        for (String name : names){
            map.put(name, "");
        }
    }

    public HashMap<String, String> getMap() {
        return map;
    }
}
