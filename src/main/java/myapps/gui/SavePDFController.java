package myapps.gui;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import myapps.datamodel.AnagrafeAnalisi;
import myapps.pdf.PdfGenerator;

import java.io.File;

public class SavePDFController extends ControllerBase {

    // UI bindings
    @FXML private TextField txtAnalizzatore;
    @FXML private TextField txtSupervisore;
    @FXML private TextField txtFilename;

    @FXML private Button btnSaveToPDF;

    // UI
    private Stage stage;
    private PdfGenerator pdfGenerator;

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        stage = new Stage();
        stage.setScene(new Scene(content));
        stage.setAlwaysOnTop(true);
        pdfGenerator = new PdfGenerator(
                loader.getInputController().getInputContainer(),
                loader.getResultController().getResultContainer(),
                loader.getAnagrafeController().getAnagrafe()
        );
    }

    public void updateAnagrafe(){
        var map = loader.getAnagrafeController().getAnagrafe().getMap();
        map.put("Analizzatore", txtAnalizzatore.getText());
        map.put("In presenza di: ", txtSupervisore.getText());
    }

    public Stage getStage() {
        return stage;
    }

    @FXML public void saveToPDF(){
        String filename = txtFilename.getText();
        AnagrafeAnalisi anagrafe = loader.getAnagrafeController().getAnagrafe();

        loader.getAnagrafeController().updateAnagrafe();
        updateAnagrafe();

        if (filename.isEmpty()){
            String date = anagrafe.getMap().get("Data Analisi");
            if (date == null || date.isEmpty()){
                date = "";
            }
            filename = "Analisi" + date + ".pdf";
        } else {
            filename = txtFilename.getText() + ".pdf";
        }

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(stage);

        pdfGenerator.generatePdf(selectedDirectory, filename);
    }

    @FXML public void closeSaveDialog(){
        stage.close();
    }
}
