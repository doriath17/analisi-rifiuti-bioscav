package myapps;

import java.util.ArrayList;
import java.util.Date;

public class AnagrafeAnalisi {
    private ArrayList<String> elements;

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
        elements = new ArrayList<>(10);
    }

    public void setComune(String comune){
        elements.set(0, comune);
    }

    public String getComune(){
        return elements.get(0);
    }
}
