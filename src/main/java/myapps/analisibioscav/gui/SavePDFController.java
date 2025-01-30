package myapps.analisibioscav.gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import myapps.analisibioscav.datamodel.AnagrafeAnalisi;
import myapps.analisibioscav.pdf.FilenameException;
import myapps.analisibioscav.pdf.NoDirectorySelectedExeption;
import myapps.analisibioscav.pdf.PdfGenerator;

import java.io.File;

public class SavePDFController extends ControllerBase {

    // UI bindings
    @FXML private TextField txtFilename;
    @FXML private TextField txtPath;
    @FXML private Label lblSaveStatus;
    private File selectedDirectory;

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

    private void setFilename(){
        if (txtFilename.getText().isEmpty()) {
            StringBuilder builder = new StringBuilder("analisi");

            String comune = anagrafe.getMap().get("Comune");
            if (!comune.isEmpty()){
                builder.append("-");
                builder.append(comune);
            }

            String date = anagrafe.getMap().get("Data Analisi");
            if (!date.isEmpty()){
                builder.append("-");
                builder.append(date.replaceAll("/", "-"));
            }

            txtFilename.setText(builder.toString());
        }
    }

    public void onShowing(){
        anagrafe.update();
        txtFilename.setText("");
        setFilename();
    }

    public void onClosing(){
        lblSaveStatus.setText("");
    }

    @FXML private void selectDirectory(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        selectedDirectory = directoryChooser.showDialog(stage);
        txtPath.setText(selectedDirectory.getAbsolutePath());
    }

    @FXML public void saveToPDF() {
        setFilename();
        // todo: path not selected handler
        try {
            pdfGenerator.generatePdf(selectedDirectory, txtFilename.getText() + ".pdf");
            lblSaveStatus.setText("Salvataggio completato correttamente");
        } catch (NoDirectorySelectedExeption | FilenameException e) {
            lblSaveStatus.setText(e.getMessage());
        }
    }

    @FXML public void closeSaveDialog(){
        onClosing();
        stage.close();
    }
}
