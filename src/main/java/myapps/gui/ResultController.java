//package myapps.gui;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import myapps.App;
//
//import java.io.IOException;
//
//public class ResultController {
//    @FXML private Label lblPesoCampione;
//
//    // categorie
//
//    @FXML private Label lblPesoTotaleMonomateriale;
//    @FXML private Label lblPesoPercentualeMonomateriale;
//
//    @FXML private Label lblPesoTotaleTraccianti;
//    @FXML private Label lblPesoPercentualeTraccianti;
//
//    @FXML private Label lblPesoTotaleFrazioniEstranee;
//    @FXML private Label lblPesoPercentualeFrazioniEstranee;
//
//
//    // final results
//    @FXML private Label lblPesoMDiff;
//    @FXML private Label lblPesoPercentualeMDiff;
//
//    @FXML private Label lblPesoFE;
//    @FXML private Label lblPesoPercentualeFE;
//
//    private SavePDFController savePDFController;
//
//    private Stage savePDFStage;
//
//    public ResultController() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("savePDF.fxml"));
//        Parent savePDFRoot = fxmlLoader.load();
//        savePDFController = fxmlLoader.getController();
//
//        Scene savePDFScene = new Scene(savePDFRoot);
//        savePDFStage = new Stage();
//        savePDFStage.setScene(savePDFScene);
//        savePDFStage.setAlwaysOnTop(true);
//
////        savePDFController.setAnagrafe(anagrafe);
////        savePDFController.setStage(savePDFStage);
////        savePDFController.setCurrentAnalisi(currentAnalisi);
//    }
//
//}
