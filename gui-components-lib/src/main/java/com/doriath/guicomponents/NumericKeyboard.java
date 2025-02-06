package com.doriath.guicomponents;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class NumericKeyboard extends GridPane {

    private SimpleObjectProperty<TextField> selectedTF = new SimpleObjectProperty<>(null);

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

    @FXML private void add0(){
        if (selectedTF.getValue() != null){
            selectedTF.getValue().setText(selectedTF.getValue().getText() + "0");
        }
    }

    @FXML private void add1(){
        if (selectedTF.getValue() != null){
            selectedTF.getValue().setText(selectedTF.getValue().getText() + "1");
        }
    }

}
