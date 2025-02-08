package com.doriath.guicomponents;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class NumericKeyboard extends GridPane {

    private SimpleStringProperty output = null;

    public NumericKeyboard() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NumericKeyboard.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public String getOutput() {
        return output.get();
    }

    public SimpleStringProperty outputProperty() {
        return output;
    }

    public void setOutput(String output) {
        this.output.set(output);
    }

    @FXML private void add0(){
        if (output != null){
            output.setValue(output.getValue() + "0");
        }
    }

    @FXML private void add1(){
        if (output != null){
            output.setValue(output.getValue() + "1");
        }
    }

}
