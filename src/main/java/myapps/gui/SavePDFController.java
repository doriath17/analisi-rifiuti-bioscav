package myapps.gui;

import javafx.fxml.FXML;
import javafx.scene.DirectionalLight;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import myapps.datamodel.Analisi;
import myapps.pdf.PdfGenerator;

import java.io.File;
import java.util.HashMap;

public class SavePDFController {


    @FXML private TextField txtAnalizzatore;
    @FXML private TextField txtSupervisore;
    @FXML private TextField txtFilename;

    @FXML private Button btnSaveToPDF;

    HashMap<String, String> anagrafe;
    Stage stage;
    Analisi currentAnalisi;

    public void setAnagrafe(HashMap<String, String> anagrafe){
        this.anagrafe = anagrafe;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setCurrentAnalisi(Analisi currentAnalisi){
        this.currentAnalisi = currentAnalisi;
    }

    public void updateAnagrafe(){
        anagrafe.put(PrimaryController.a12, txtAnalizzatore.getText());
        anagrafe.put(PrimaryController.a13, txtSupervisore.getText());
    }

    @FXML public void saveToPDF(){
        String filename = txtFilename.getText();
        updateAnagrafe();
        if (filename.isEmpty()){
            String date = anagrafe.get(PrimaryController.a4);
            if (date == null || date.isEmpty()){
                date = "";
            }
            filename = "Analisi" + date + ".pdf";
        } else {
            filename = txtFilename.getText() + ".pdf";
        }

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(stage);

        PdfGenerator.generatePdf(selectedDirectory, filename, currentAnalisi, anagrafe);
    }
}
