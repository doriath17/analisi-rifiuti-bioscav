package com.doriath.guicomponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class TryClass extends HBox {

    public TryClass(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TryClass.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}
