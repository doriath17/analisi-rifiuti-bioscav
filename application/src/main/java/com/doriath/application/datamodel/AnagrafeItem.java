package com.doriath.application.datamodel;

public enum AnagrafeItem {

    COMUNE("Comune"),
    NUM_CONTROLLO("Controllo N°"),
    CER_RIFIUTO("CER Rifiuto"),
    DATA_ANALISI("Data Analisi"),
    NUM_FORMULARIO("Formulario N°"),
    DATA_FORMULARIO("Data Formulario"),
    SFUSO_IN_BALLE("Sfuso/In Balle"),
    FLUSSO("Flusso"),
    ORA_INIZIO("Ora Inizio"),
    ORA_FINE("Ora Fine"),
    ANALIZZATORE("Analizzatore"),
    SUPERVISORE("In presenza di:"),
    MATERIALE_CONFERITO("Materiale Conferito (Kg)");

    private final String text;

    private AnagrafeItem(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
