package com.doriath.application.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagrafeAnalisi extends HashMap<AnagrafeItem, String> {
    private Updater updater;

    public static final int ANAGRAFE_ITEMS_NUM = 13;

    public AnagrafeAnalisi(){
        super();
        reset();
    }

    public void reset(){
        for (var item : AnagrafeItem.values()){
            put(item, "");
        }
    }

    public void setUpdater(Updater updater){
        this.updater = updater;
    }

    public void update(){
        updater.update();
    }

}
