package myapps.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import myapps.App;

import java.io.IOException;

public class ControllerLoader {

    private PrimaryController primaryController;
    private Parent root;

    private InputController inputController;
    private ResultController resultController;
    private AnagrafeController anagrafeController;

    public static final String loc1 = "primaryWindow.fxml";
    public static final String loc2 = "inputWindow.fxml";
    public static final String loc3 = "resultWindow.fxml";
    public static final String loc4 = "anagrafeWindow.fxml";

    public ControllerLoader(){
        loadPrimaryController();
        loadInputController();
        loadResultController();
        loadAnagrafeController();
        primaryController.initCotroller(this);
    }

    public PrimaryController getPrimaryController() {
        return primaryController;
    }

    public Parent getRoot() {
        return root;
    }

    public InputController getInputController() {
        return inputController;
    }

    public ResultController getResultController() {
        return resultController;
    }

    public AnagrafeController getAnagrafeController() {
        return anagrafeController;
    }

    private void loadPrimaryController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(loc1));
            root = fxmlLoader.load();
            primaryController = fxmlLoader.getController();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadInputController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(loc2));
            Parent content = fxmlLoader.load();
            inputController = fxmlLoader.getController();
            inputController.setContent(content);
            inputController.setPrimaryController(primaryController);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadResultController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(loc3));
            Parent content = fxmlLoader.load();
            resultController = fxmlLoader.getController();
            resultController.setContent(content);
            resultController.setPrimaryController(primaryController);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadAnagrafeController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(loc4));
            Parent content = fxmlLoader.load();
            anagrafeController = fxmlLoader.getController();
            anagrafeController.setContent(content);
            anagrafeController.setPrimaryController(primaryController);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
