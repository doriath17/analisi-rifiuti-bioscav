package myapps;

import javafx.beans.property.SimpleObjectProperty;

public class Analisi {
    SimpleObjectProperty<Double> pesoCampione;

    CategoriaRifiuto monomateriale;
//    CategoriaRifiuto traccianti;
//    CategoriaRifiuto frazioniEstranee;
//    CategoriaRifiuto altreFE;

    Rifiuto imballagi;
//    Rifiuto industriali;
//    Rifiuto umido;
//    Rifiuto vetro;
//    Rifiuto medicinali;
//    Rifiuto alluminioAcciaio;
//    Rifiuto frazioniFini2x2;
//    Rifiuto raee;
//    Rifiuto legno;
//    Rifiuto inerti;
//    Rifiuto tessuti;


    public Analisi(){
        pesoCampione = new SimpleObjectProperty<>(0.0);
        monomateriale = new CategoriaRifiuto(this);
        imballagi = new Rifiuto(this, monomateriale);
    }

    public SimpleObjectProperty<Double> pesoCampioneProperty() {
        return pesoCampione;
    }

    public CategoriaRifiuto getMonomateriale() {
        return monomateriale;
    }

    public Rifiuto getImballagi() {
        return imballagi;
    }

}
