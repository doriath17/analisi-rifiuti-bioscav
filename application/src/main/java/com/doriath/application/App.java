package com.doriath.application;

import com.doriath.guicomponents.TryClass;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.doriath.application.datamodel.AnalisiDAO;
import com.doriath.application.gui.ControllerLoader;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private ControllerLoader controllerLoader;
    private AnalisiDAO analisiDAO;

    @Override
    public void init(){
        var x = new TryClass();
        analisiDAO = new AnalisiDAO();
    }

    @Override
    public void start(Stage stage) throws IOException {
        controllerLoader = new ControllerLoader(analisiDAO);

        stage.setScene(new Scene(controllerLoader.getRoot()));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    @Override
    public void stop(){

    }

    public static void main(String[] args) {
        launch();
    }

}