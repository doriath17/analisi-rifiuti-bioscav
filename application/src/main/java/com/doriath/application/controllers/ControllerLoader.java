package com.doriath.application.controllers;

import com.doriath.application.configuration.ConfigLoader;
import com.doriath.application.configuration.SavedDataLoader;
import com.doriath.model.AnalisiDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import com.doriath.application.App;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLoader {

    private Stage stage;
    private ConfigLoader configLoader;
    private AnalisiDAO analisiDAO;
    private SavedDataLoader savedDataLoader;

    private PrimaryController primaryController;
    private Parent root;

    private ControllerBase inputController;
    private ControllerBase resultController;
    private ControllerBase anagrafeController;
    private ControllerBase savePDFController;

    public static final String loc1 = "primaryWindow.fxml";
    public static final String loc2 = "inputWindow.fxml";
    public static final String loc3 = "resultWindow.fxml";
    public static final String loc4 = "anagrafeWindow.fxml";
    public static final String loc5 = "savePDF.fxml";

    public ControllerLoader(Stage stage, AnalisiDAO analisiDAO, SavedDataLoader savedDataLoader, ConfigLoader configLoader){
        this.stage = stage;
        this.configLoader = configLoader;
        this.analisiDAO = analisiDAO;
        this.savedDataLoader = savedDataLoader;

        loadPrimaryController();
        loadInputController();
        loadResultController();
        loadAnagrafeController();
        loadSavePDFController();
        initControllers();
    }

    private void initControllers(){
        primaryController.init(this);
        resultController.init(this, primaryController);
        inputController.init(this, primaryController);
        anagrafeController.init(this, primaryController);
        savePDFController.init(this, primaryController);
    }

    public Stage getStage() {
        return stage;
    }

    public ConfigLoader getConfig() {
        return configLoader;
    }

    public AnalisiDAO getAnalisiDAO() {
        return analisiDAO;
    }

    public SavedDataLoader getSavedDataLoader() {
        return savedDataLoader;
    }
    
    public PrimaryController getPrimaryController() {
        return primaryController;
    }

    public Parent getRoot() {
        return root;
    }

    public InputController getInputController() {
        return (InputController) inputController;
    }

    public ResultController getResultController() {
        return (ResultController) resultController;
    }

    public AnagrafeController getAnagrafeController() {
        return (AnagrafeController) anagrafeController;
    }

    public SavePDFController getSavePDFController() {
        return (SavePDFController) savePDFController;
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
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadSavePDFController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(loc5));
            Parent content = fxmlLoader.load();
            savePDFController = fxmlLoader.getController();
            savePDFController.setContent(content);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
