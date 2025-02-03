package com.doriath.application.datamodel;

import com.doriath.guicomponents.util.PositiveIntegerConverter;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;

public class QualityRange extends SimpleObjectProperty<Integer> {
    private final CategoriaRifiutoBase mdiff;

    public QualityRange(CategoriaRifiutoBase mdiff){
        super(0);
        this.mdiff = mdiff;
    }

    public void update(){
        double val = mdiff.getPesoPercentuale() / 10.0;
        double decimal = val - (int) val;
        if (decimal > 0.5){
            setValue((int) val + 1);
        } else {
            setValue((int) val);
        }
    }

    public void reset(){
        setValue(0);
    }

    public void setupControls(Label label){
        label.textProperty().bindBidirectional(this, new PositiveIntegerConverter());
    }
}
