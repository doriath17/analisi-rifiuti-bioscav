package com.doriath.application.configuration;

public enum ConfigOption {

    NUMERIC_KEYBOARD("NUMERIC_KEYBOARD", false),
    AUTOSAVE("AUTOSAVE",true),
    FULLSCREEN("FULLSCREEN", false);

    private Boolean defaultValue;
    private String name;

    ConfigOption(String name, Boolean defaultValue){
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public String getName() {
        return name;
    }
}
