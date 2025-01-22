package myapps.datamodel;

import javafx.beans.property.SimpleObjectProperty;

public class Analisi {
    SimpleObjectProperty<Double> pesoCampione;

    CategoriaRifiuto monomateriale;
    CategoriaRifiuto traccianti;
    CategoriaRifiuto frazioniEstranee;
//    CategoriaRifiuto altreFE;

    Rifiuto imballaggi;
    Rifiuto industriali;
    Rifiuto umido;
    Rifiuto vetro;
    Rifiuto medicinali;
    Rifiuto alluminioAcciaio;
    Rifiuto frazioniFini2x2;
    Rifiuto raee;
    Rifiuto legno;
    Rifiuto inerti;
    Rifiuto tessuti;

    AnalisiResult result;

    public Analisi(){
        pesoCampione = new SimpleObjectProperty<>(0.0);

        monomateriale = new CategoriaRifiuto(this);
        traccianti = new CategoriaRifiuto(this);
        frazioniEstranee = new CategoriaRifiuto(this);

        imballaggi = new Rifiuto(this, monomateriale);
        industriali = new Rifiuto(this, traccianti);
        umido = new Rifiuto(this, frazioniEstranee);
        vetro = new Rifiuto(this, frazioniEstranee);
        medicinali = new Rifiuto(this, frazioniEstranee);
        alluminioAcciaio = new Rifiuto(this, frazioniEstranee);
        frazioniFini2x2 = new Rifiuto(this, frazioniEstranee);
        raee = new Rifiuto(this, frazioniEstranee);
        legno = new Rifiuto(this, frazioniEstranee);
        inerti = new Rifiuto(this, frazioniEstranee);
        tessuti = new Rifiuto(this, frazioniEstranee);

        result = new AnalisiResult(pesoCampione);
    }

    // peso campione

    public SimpleObjectProperty<Double> getPesoCampione() {
        return pesoCampione;
    }

    public void updatePesoCampione(double delta){
        pesoCampione.setValue(pesoCampione.getValue() + delta);
    }


    // getters categorie

    public CategoriaRifiuto getMonomateriale() { return monomateriale; }

    public CategoriaRifiuto getTraccianti() { return traccianti; }

    public CategoriaRifiuto getFrazioniEstranee() { return frazioniEstranee; }


    // getters rifiuti

    public Rifiuto getImballaggi() {
        return imballaggi;
    }

    public Rifiuto getIndustriali() {
        return industriali;
    }

    public Rifiuto getUmido() { return umido; }

    public Rifiuto getVetro() { return vetro; }

    public Rifiuto getMedicinali() { return medicinali; }

    public Rifiuto getAlluminioAcciaio() { return alluminioAcciaio; }

    public Rifiuto getFrazioniFini2x2() { return frazioniFini2x2; }

    public Rifiuto getRaee() { return raee; }

    public Rifiuto getLegno() { return legno; }

    public Rifiuto getInerti() { return inerti; }

    public Rifiuto getTessuti() { return tessuti; }

    // other getters

    public AnalisiResult getResult() {
        return result;
    }
}
