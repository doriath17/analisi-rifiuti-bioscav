package com.doriath.model;

public enum Rifiuto {

    IMBALLAGGI_COREPLA("Imballaggi Corepla"),
    INDUSTRIALI("Industriali"),
    ALLUMINIO_ACCIAIO("Alluminio / Acciaio"),
    UMIDO("Umido"),
    VETRO("Vetro"),
    CARTA_TETRA_PAK("Carta / TETRA PAK"),
    MEDICINALI("Medicinali"),
    FRAZIONI_FINI_2X2("Frazioni Fini 2x2"),
    RAEE("RAEE"),
    LEGNO("Legno"),
    TESSUTI("Tessuti"),
    ALTRE_FE("Altre Frazioni Estranee");

    private final String text;

    Rifiuto(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
