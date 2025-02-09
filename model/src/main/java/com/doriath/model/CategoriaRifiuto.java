package com.doriath.model;

public enum CategoriaRifiuto {
    MDIFF_COREPLA("Materiale Differenziato COREPLA"),
    MDIFF_ALLUMINIO_ACCIAIO("Materiale Differenziato Alluminio/Acciaio"),
    MDIFF_TOTALE("Materiale Differenziato Totale"),
    FE_TOTALE("Frazione Estranea Totale"),
    MONOMATERIALE("Monomateriale"),
    TRACCIANTI("Traccianti");

    private final String text;

    CategoriaRifiuto(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
