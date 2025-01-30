package myapps.analisibioscav.gui;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import myapps.analisibioscav.datamodel.AnagrafeAnalisi;
import myapps.analisibioscav.pdf.PdfGenerator;

import java.io.File;

public class SavePDFController extends ControllerBase {

    // UI bindings
    @FXML private TextField txtAnalizzatore;
    @FXML private TextField txtSupervisore;
    @FXML private TextField txtFilename;

    @FXML private Button btnSaveToPDF;

    private Stage stage = new Stage();
    private PdfGenerator pdfGenerator;
    private AnagrafeAnalisi anagrafe;

    @Override
    public void init(ControllerLoader loader, PrimaryController primaryController){
        super.init(loader, primaryController);
        stage.setScene(new Scene(content));
        stage.setAlwaysOnTop(true);
        pdfGenerator = new PdfGenerator(loader.getAnalisiDAO());
        anagrafe = loader.getAnalisiDAO().getAnagrafeAnalisi();
    }

    public Stage getStage() {
        return stage;
    }

    @FXML public void saveToPDF(){
        String filename = txtFilename.getText();

        anagrafe.update();

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
