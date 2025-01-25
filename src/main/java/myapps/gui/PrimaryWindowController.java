package myapps.gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import myapps.App;
import myapps.datamodel.Analisi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrimaryWindowController extends ControllerBase {
    private InputWindowController inputWindowController;

    public PrimaryWindowController() throws IOException {
        currentAnalisi = new Analisi();

        // load controllers
        FXMLLoader fxmlLoader = null;
        Parent content = null;

        fxmlLoader = new FXMLLoader(App.class.getResource("inputWindow.fxml"));
        content = fxmlLoader.load();
        inputWindowController = fxmlLoader.getController();
        inputWindowController.setPrimaryWindow(this);
        inputWindowController.setCurrentAnalisi(currentAnalisi);
        inputWindowController.setContent(content);
    }

//    @FXML private void openSavePDFStage(){
//        updateAnagrafe();
//        savePDFStage.show();
//    }
}
