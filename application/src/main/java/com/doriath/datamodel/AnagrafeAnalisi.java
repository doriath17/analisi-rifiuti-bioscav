package com.doriath.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagrafeAnalisi {
    private Updater updater;
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

    public void reset(){
        for (String name : names){
            map.put(name, "");
        }
    }

    public AnagrafeAnalisi(){
        reset();
    }

    public void setUpdater(Updater updater){
        this.updater = updater;
    }

    public void update(){
        updater.update();
    }

    public HashMap<String, String> getMap() {
        return map;
    }

}
