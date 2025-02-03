package com.doriath.guicomponents;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ComponentTesterController {

    @FXML private TimePicker timePicker;
    @FXML private Label lblTimePicker;

    @FXML private void initialize(){
        lblTimePicker.textProperty().bindBidirectional(timePicker.timeStringProperty());
    }

}
