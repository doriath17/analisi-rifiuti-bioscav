package myapps.datamodel;

import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;

public class Analisi {
    private final PesoCampione pesoCampione = new PesoCampione();

    public static final int NUM_CATEGORIE = 5;
    public static final int NUM_RIFIUTI = 11;
    protected final ArrayList<CategoriaRifiutoBase> categorieArray = new ArrayList<>(NUM_CATEGORIE);
    protected final ArrayList<Rifiuto> rifiutiArray = new ArrayList<>(NUM_RIFIUTI);

    public Analisi(){
        categorieArray.add(new CategoriaRifiutoBase("Materiale Differenziato Totale", this));
        categorieArray.add(new CategoriaRifiutoBase("Frazione Estranea Totale", this));
        categorieArray.add(new CategoriaRifiuto("Monomateriale",this, categorieArray.get(0)));
        categorieArray.add(new CategoriaRifiuto("Traccianti",this, categorieArray.get(0)));
        categorieArray.add(new CategoriaRifiuto("Frazioni Estranee",this, categorieArray.get(1)));

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
    }

    // peso campione

    public PesoCampione getPesoCampione() {
        return pesoCampione;
    }

    public void updatePesoCampione(double delta){
        pesoCampione.updatePesoCampione(delta);
    }

    // getters categorie

    public CategoriaRifiutoBase getMaterialeDiff() {
        return categorieArray.get(0);
    }

    public CategoriaRifiutoBase getFrazioneEstraneaTot(){
        return categorieArray.get(1);
    }

    public CategoriaRifiuto getMonomateriale() { return (CategoriaRifiuto) categorieArray.get(2); }

    public CategoriaRifiuto getTraccianti() { return (CategoriaRifiuto) categorieArray.get(3); }

    public CategoriaRifiuto getFrazioniEstranee() { return (CategoriaRifiuto) categorieArray.get(4); }

    public void updatePercentualiCategorie(){
        for (CategoriaRifiutoBase categoria : categorieArray){
            categoria.updatePesoPercentuale();
        }
    }

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

    public ArrayList<Rifiuto> getRifiutiArray(){
        return rifiutiArray;
    }

    public ArrayList<CategoriaRifiutoBase> getCategorieArray() {
        return categorieArray;
    }
}
