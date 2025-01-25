package myapps.gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.control.TextFormatter;

public class ControllerBase {

    protected Parent content;
    protected PrimaryController primaryController;

    public void setContent(Parent content){
        this.content = content;
    }

    public Parent getContent() {
        return content;
    }

    public void setPrimaryController(PrimaryController primaryController){
        this.primaryController = primaryController;
    }

    public static TextFormatter<Double> getTextFormatterInstance(SimpleObjectProperty<Double> toBind){
        var textformatter = new TextFormatter<Double>(new PositiveDoubleStringConverter());
        textformatter.valueProperty().bindBidirectional(toBind);
        return textformatter;
    }

}
