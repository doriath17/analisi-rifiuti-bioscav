package myapps.gui;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class SavePDFController extends ControllerBase {

    // UI bindings
    @FXML private TextField txtAnalizzatore;
    @FXML private TextField txtSupervisore;
    @FXML private TextField txtFilename;

    @FXML private Button btnSaveToPDF;

    // UI
    private Stage stage;

    // data model
//    HashMap<String, String> anagrafe;
//
//    public void setAnagrafe(HashMap<String, String> anagrafe){
//        this.anagrafe = anagrafe;
//    }
//
//    public void setStage(Stage stage){
//        this.stage = stage;
//    }
//
//    public void updateAnagrafe(){
//        anagrafe.put(PrimaryWindowController.anagrafeStrings.get(12), txtAnalizzatore.getText());
//        anagrafe.put(PrimaryWindowController.anagrafeStrings.get(11), txtSupervisore.getText());
//    }

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        stage = new Stage();
        stage.setScene(new Scene(content));
        stage.setAlwaysOnTop(true);
    }

    public Stage getStage() {
        return stage;
    }

    @FXML public void saveToPDF(){
//        String filename = txtFilename.getText();
//        updateAnagrafe();
//        if (filename.isEmpty()){
//            String date = anagrafe.get(PrimaryWindowController.anagrafeStrings.get(3));
//            if (date == null || date.isEmpty()){
//                date = "";
//            }
//            filename = "Analisi" + date + ".pdf";
//        } else {
//            filename = txtFilename.getText() + ".pdf";
//        }
//
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        File selectedDirectory = directoryChooser.showDialog(stage);
//
//        PdfGenerator.generatePdf(selectedDirectory, filename, currentAnalisi, anagrafe);
    }

    @FXML public void closeSaveDialog(){
        stage.close();
    }
}
