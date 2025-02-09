package com.doriath.model;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;

public class AnagrafeAnalisi extends HashMap<AnagrafeItem, SimpleStringProperty> {

    public static final int ANAGRAFE_ITEMS_NUM = 13;

    public AnagrafeAnalisi(){
        super();
        for (var item : AnagrafeItem.values()){
            put(item, new SimpleStringProperty(""));
        }
    }

    public void reset(){
        for (var item : AnagrafeItem.values()){
            get(item).setValue("");
        }
    }

}
