package com.doriath.application.gui;

import com.doriath.guicomponents.util.stringconverter.WeightStringConverter;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.control.TextFormatter;

public class ControllerBase {
    protected ControllerLoader loader;
    protected PrimaryController primaryController;
    protected Parent content;

    public void setContent(Parent content){
        this.content = content;
    }

    public Parent getContent() {
        return content;
    }

    public void setPrimaryController(PrimaryController primaryController){
        this.primaryController = primaryController;
    }

    public void setLoader(ControllerLoader loader) {
        this.loader = loader;
    }

    public void init(ControllerLoader loader, PrimaryController primaryController){
        this.loader = loader;
        this.primaryController = primaryController;
    }

    public static TextFormatter<Double> getTextFormatterInstance(SimpleObjectProperty<Double> toBind){
        var textformatter = new TextFormatter<Double>(new WeightStringConverter());
        textformatter.valueProperty().bindBidirectional(toBind);
        return textformatter;
    }

}
