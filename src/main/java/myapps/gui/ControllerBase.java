package myapps.gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.control.TextFormatter;
import myapps.datamodel.ResultContainer;

public class ControllerBase {
    protected ResultContainer currentAnalisi;
    protected Parent content;

    public void setCurrentAnalisi(ResultContainer currentResultContainer){
        this.currentAnalisi = currentResultContainer;
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
