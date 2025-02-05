package com.doriath.application.datamodel;

import com.doriath.application.gui.AnagrafeController;
import com.doriath.application.gui.PrimaryController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagrafeAnalisi extends HashMap<AnagrafeItem, SimpleStringProperty> {
    private Updater updater;

    public static final int ANAGRAFE_ITEMS_NUM = 13;

    public AnagrafeAnalisi(){
        super();
        for (var item : AnagrafeItem.values()){
            put(item, new SimpleStringProperty(""));
        }
    }

    public void syncController(ObjectProperty<LocalDate> dateAnalisi, ObjectProperty<LocalDate> dateFormulario){
        SimpleStringProperty dateA = get(AnagrafeItem.DATA_ANALISI);
        get(AnagrafeItem.DATA_ANALISI).addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                dateAnalisi.setValue(AnagrafeController.localDateStringConverter.fromString(dateA.getValue()));
            }
        });
        SimpleStringProperty dateB = get(AnagrafeItem.DATA_FORMULARIO);
        get(AnagrafeItem.DATA_FORMULARIO).addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                dateFormulario.setValue(AnagrafeController.localDateStringConverter.fromString(dateB.getValue()));
            }
        });
    }

    public void reset(){
        for (var item : AnagrafeItem.values()){
            get(item).setValue("");
        }
    }

    public void setUpdater(Updater updater){
        this.updater = updater;
    }

    public void update(){
        updater.update();
    }

}
