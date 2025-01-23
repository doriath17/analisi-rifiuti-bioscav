package myapps.datamodel;

import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;

public class Analisi {
    private final SimpleObjectProperty<Double> pesoCampione;

    public final int NUM_CATEGORIE = 3;
    public final int NUM_RIFIUTI = 11;
    protected final ArrayList<CategoriaRifiuto> categorieArray = new ArrayList<>(NUM_CATEGORIE);
    protected final ArrayList<Rifiuto> rifiutiArray = new ArrayList<>(NUM_RIFIUTI);

    AnalisiResult result;

    public Analisi(){
        pesoCampione = new SimpleObjectProperty<>(0.0);

        categorieArray.add(new CategoriaRifiuto("Monomateriale",this));
        categorieArray.add(new CategoriaRifiuto("Traccianti",this));
        categorieArray.add(new CategoriaRifiuto("Frazioni Estranee",this));

        rifiutiArray.add(new Rifiuto("Imballaggi", this, getMonomateriale()));
        rifiutiArray.add(new Rifiuto("Industriali", this, getTraccianti()));
        rifiutiArray.add(new Rifiuto("Umido", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("Vetro", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("Medicinali", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("Alluminio/Acciaio", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("Frazioni Fini 2x2", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("RAEE", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("Legno", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("Inerti", this, getFrazioniEstranee()));
        rifiutiArray.add(new Rifiuto("Tessuti", this, getFrazioniEstranee()));

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

    public CategoriaRifiuto getMonomateriale() { return categorieArray.get(0); }

    public CategoriaRifiuto getTraccianti() { return categorieArray.get(1); }

    public CategoriaRifiuto getFrazioniEstranee() { return categorieArray.get(2); }


    // getters rifiuti

    public Rifiuto getImballaggi() {
        return rifiutiArray.get(0);
    }

    public Rifiuto getIndustriali() {
        return rifiutiArray.get(1);
    }

    public Rifiuto getUmido() { return rifiutiArray.get(2); }

    public Rifiuto getVetro() { return rifiutiArray.get(3); }

    public Rifiuto getMedicinali() { return rifiutiArray.get(4); }

    public Rifiuto getAlluminioAcciaio() { return rifiutiArray.get(5); }

    public Rifiuto getFrazioniFini2x2() { return rifiutiArray.get(6); }

    public Rifiuto getRaee() { return rifiutiArray.get(7); }

    public Rifiuto getLegno() { return rifiutiArray.get(8); }

    public Rifiuto getInerti() { return rifiutiArray.get(9); }

    public Rifiuto getTessuti() { return rifiutiArray.get(10); }

    // other getters

    public AnalisiResult getResult() {
        return result;
    }
}
