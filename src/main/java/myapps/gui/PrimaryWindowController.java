package myapps.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import myapps.App;
import myapps.datamodel.ResultContainer;

import java.io.IOException;

public class PrimaryWindowController extends ControllerBase {
    private InputWindowController inputWindowController;

    public PrimaryWindowController() throws IOException {
        currentAnalisi = new ResultContainer();

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
