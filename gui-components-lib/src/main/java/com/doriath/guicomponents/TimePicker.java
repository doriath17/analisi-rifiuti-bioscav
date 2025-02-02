package com.doriath.guicomponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class TimePicker extends HBox {

    @FXML private TextField txtHours;
    @FXML private TextField txtMinutes;
    @FXML private Button btnAddHour;
    @FXML private Button btnSubHour;
    @FXML private Button btnAddMinute;
    @FXML private Button btnSubMinute;

    private ObjectProperty<Integer> hours;
    private ObjectProperty<Integer> minutes;

    public void setMinutes(Integer minutes) {
        this.minutes.set(minutes);
    }

    public void setHours(Integer hours) {
        this.hours.set(hours);
    }

    public Integer getHours() {
        return hours.get();
    }

    public ObjectProperty<Integer> hoursProperty() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes.get();
    }

    public ObjectProperty<Integer> minutesProperty() {
        return minutes;
    }

    public TimePicker() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TimePicker.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e){
            throw e;
        }
    }

    @FXML private void initialize(){
        txtHours.setTextFormatter(
                new TextFormatter<>(createStringConverter(), 0)
        );
        hours = (ObjectProperty<Integer>) txtHours.getTextFormatter().valueProperty();

        txtMinutes.setTextFormatter(
                new TextFormatter<>(createStringConverter(), 0)
        );
        minutes = (ObjectProperty<Integer>) txtMinutes.getTextFormatter().valueProperty();

    }

    @FXML private void addHour(){
        var value = hours.getValue();
        if (value < 24){
            hours.setValue(value + 1);
        } else {
            hours.setValue(0);
        }
    }

    @FXML private void subHour(){
        var value = hours.getValue();
        if (value > 0){
            hours.setValue(value - 1);
        } else {
            hours.setValue(23);
        }
    }

    @FXML private void addMinute(){
        var value = minutes.getValue();
        if (value < 60){
            minutes.setValue(value + 1);
        } else {
            minutes.setValue(0);
        }
    }

    @FXML private void subMinute(){
        var value = minutes.getValue();
        if (value > 0){
            minutes.setValue(value - 1);
        } else {
            minutes.setValue(59);
        }
    }

    public static StringConverter<Integer> createStringConverter(){
        return new StringConverter<Integer>() {
            @Override
            public String toString(Integer value) {
                return value.toString();
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        };
    }

    private UnaryOperator<TextFormatter.Change> createFilter(){
        return new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String text = change.getControlNewText();
                //&& text.matches("[0-9]{1,2}")
                if (!text.isEmpty()){
                    return change;
                }
                return null;
            }
        };
    }
}
