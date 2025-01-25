package myapps.gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.control.TextFormatter;
import myapps.datamodel.Analisi;

public class ControllerBase {
    protected Analisi currentAnalisi;
    protected Parent content;

    public void setCurrentAnalisi(Analisi currentAnalisi){
        this.currentAnalisi = currentAnalisi;
    }

    public void setContent(Parent content){
        this.content = content;
    }

    public static TextFormatter<Double> getTextFormatterInstance(SimpleObjectProperty<Double> toBind){
        var textformatter = new TextFormatter<Double>(new PositiveDoubleStringConverter());
        textformatter.valueProperty().bindBidirectional(toBind);
        return textformatter;
    }
}
