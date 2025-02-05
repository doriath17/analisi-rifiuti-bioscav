package com.doriath.application.configuration;

public enum ConfigOption {

    AUTOSAVE("Autosave");

    private String text;

    private ConfigOption(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

}
