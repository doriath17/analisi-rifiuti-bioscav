package com.doriath.datamodel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import com.doriath.gui.PositiveDoubleStringConverter;

public class QualityRange extends SimpleObjectProperty<Double> {
    private final CategoriaRifiutoBase mdiff;

    public QualityRange(CategoriaRifiutoBase mdiff){
        super(0.0);
        this.mdiff = mdiff;
    }

    public void update(){
//        setValue(mdiff.getPesoPercentuale().getValue());
    }

    public void reset(){
        setValue(0.0);
    }

    public void setupControls(Label label){
        label.textProperty().bindBidirectional(this, new PositiveDoubleStringConverter());
    }
}
