package com.doriath.guicomponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private SimpleObjectProperty<Integer> hours = new SimpleObjectProperty<>(0);
    private SimpleObjectProperty<Integer> minutes = new SimpleObjectProperty<>(0);

    public String getTimeString() {
        return timeString.get();
    }

    public SimpleObjectProperty<String> timeStringProperty() {
        return timeString;
    }

    private SimpleObjectProperty<String> timeString = new SimpleObjectProperty<>("00:00");

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
        var hoursConverter = createHoursStringConverter();
        var tf = new TextFormatter<Integer>(hoursConverter, 0, createHoursFormatter());
        var tfValueProperty = tf.valueProperty();
        txtHours.setTextFormatter(tf);
        tfValueProperty.addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                timeString.setValue(txtHours.getText() + timeString.getValue().substring(2,5));
                System.out.println(timeString.getValue());
            }
        });

        tf = new TextFormatter<Integer>(createMinutesStringConverter(), 0);
        tf.valueProperty().bindBidirectional(minutes);
        txtMinutes.setTextFormatter(tf);

        hours.addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                timeString.setValue(hoursConverter.toString(minutes.getValue()) + timeString.getValue().substring(2,5));
                System.out.println(timeString.getValue());
            }
        });
    }

    @FXML private void addHour(){

    }

    @FXML private void subHour(){

    }

    @FXML private void addMinute(){

    }

    @FXML private void subMinute(){

    }

    private StringConverter<Integer> createHoursStringConverter(){
        return new StringConverter<Integer>() {

            private Integer lastHoursInteger = 0;

            private boolean valid(int h){
                if (h < 0 || h > 23){
                    return false;
                }
                return true;
            }

            @Override
            public String toString(Integer value) {
                StringBuilder sb = new StringBuilder();
                if (value < 10){
                    sb.append(0);
                }
                return sb.append(value).toString();
            }

            @Override
            public Integer fromString(String string) {
                if (string.isEmpty() || string.length() > 2){
                    return lastHoursInteger;
                }
                try {
                    if (string.length() == 1){
                        lastHoursInteger = Integer.parseInt(string);
                        return lastHoursInteger;
                    } else {
                        if (string.startsWith("0")){
                            string = string.substring(1,2);
                        }
                        Integer value = Integer.parseInt(string);
                        if (valid(value)){
                            lastHoursInteger = value;
                            return value;
                        } else {
                            return lastHoursInteger;
                        }
                    }
                } catch (NumberFormatException e) {
                    return lastHoursInteger;
                }
            }
        };
    }

    private boolean validHour(String text){
        if (text.startsWith("0")){
            text = text.substring(1,2);
            int h = Integer.parseInt(text);
            if (h < 0 || h > 23){
                return false;
            }
        } else {
            int h = Integer.parseInt(text);
            if (h < 0 || h > 23){
                return false;
            }
        }
        return true;
    }

    private UnaryOperator<TextFormatter.Change> createHoursFormatter(){
        return new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                var text = change.getControlNewText();
                if (text.isEmpty()){
                    return change;
                }
                if (text.length() <= 2){
                    if (text.length() == 1 && Character.isDigit(text.charAt(0))){
                        return change;
                    } else if (text.length() == 2 && (Character.isDigit(text.charAt(0)) && Character.isDigit(text.charAt(1)))){
                        if (validHour(text)){
                            return change;
                        }
                    }
                }
                return null;
            }
        };
    }

    private StringConverter<Integer> createMinutesStringConverter(){
        return new StringConverter<Integer>() {

            private Integer lastMinutesInteger = 0;

            private boolean valid(int h){
                if (h < 0 || h > 59){
                    return false;
                }
                return true;
            }

            @Override
            public String toString(Integer value) {
                StringBuilder sb = new StringBuilder();
                if (value < 10){
                    sb.append(0);
                }
                return sb.append(value).toString();
            }

            @Override
            public Integer fromString(String string) {
                if (string.isEmpty() || string.length() > 2){
                    return lastMinutesInteger;
                }
                try {
                    if (string.length() == 1){
                        lastMinutesInteger = Integer.parseInt(string);
                        return lastMinutesInteger;
                    } else {
                        if (string.startsWith("0")){
                            string = string.substring(1,2);
                        }
                        Integer value = Integer.parseInt(string);
                        if (valid(value)){
                            lastMinutesInteger = value;
                            return value;
                        } else {
                            return lastMinutesInteger;
                        }
                    }
                } catch (NumberFormatException e) {
                    return lastMinutesInteger;
                }
            }
        };
    }

}
