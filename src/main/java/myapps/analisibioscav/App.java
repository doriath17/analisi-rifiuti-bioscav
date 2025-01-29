package myapps.analisibioscav;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myapps.analisibioscav.gui.ControllerLoader;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private ControllerLoader controllerLoader;

    @Override
    public void init(){
        controllerLoader = new ControllerLoader();
    }

    @Override
    public void start(Stage stage) throws IOException {
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