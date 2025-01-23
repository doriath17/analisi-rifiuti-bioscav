package myapps.datamodel;

import java.util.ArrayList;

public class AnagrafeAnalisi {
    public final int NUM_STRING = 14;
    private ArrayList<String> keys = new ArrayList<>(NUM_STRING);
    private ArrayList<String> values = new ArrayList<>(NUM_STRING);



//    private String comune;
//    private String cerRifiuto;
//    private String numeroFormulario;
//    private String disposizione;
//    private String flusso;
//    private String numeroControllo;
//    private Date dataAnalisi;
//    private Date dataFormulario;
//    private String oraInizio;
//    private String oraFine;
//    private double materialeConferito;
//    private double pesoCampione;
//    private String analizzatore;
//    private String supervisore;

    public AnagrafeAnalisi(){
        keys.add("Comune");
        keys.add("Numero Controllo");

        keys.add("Cer. Rifiuto");
        keys.add("Data Analisi");

        keys.add("Formulario N°");
        keys.add("Data Formulario");

        keys.add("Sfuso/In Balle");
        keys.add("Flusso");

        keys.add("Ora Inizio");
        keys.add("Ora Fine");

        keys.add("Analizzatore");
        keys.add("Supervisore");

        keys.add("Materiale Conferito (kg)");
    }

    public ArrayList<String> getKeys(){
        return keys;
    }

    public ArrayList<String> getValues(){
        return values;
    }
}
