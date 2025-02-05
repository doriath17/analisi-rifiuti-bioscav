package com.doriath.application;

import com.doriath.application.configuration.SavedDataLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.doriath.application.datamodel.AnalisiDAO;
import com.doriath.application.gui.ControllerLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    public static String appName = "analisi-rifiuti-bioscav";
    public static final Path configPath = Paths.get(System.getProperty("user.home") + "\\." + App.appName);

    {
        try {
            Files.createDirectories(configPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ControllerLoader controllerLoader;
    private AnalisiDAO analisiDAO;
    private SavedDataLoader savedDataLoader;

    @Override
    public void init() throws IOException {
        analisiDAO = new AnalisiDAO();
        savedDataLoader = new SavedDataLoader(analisiDAO);
    }

    @Override
    public void start(Stage stage) throws IOException {
        controllerLoader = new ControllerLoader(analisiDAO, savedDataLoader);

        stage.setScene(new Scene(controllerLoader.getRoot()));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    @Override
    public void stop() throws IOException {
        savedDataLoader.save();
    }

    public static void main(String[] args) {
        launch();
    }

}