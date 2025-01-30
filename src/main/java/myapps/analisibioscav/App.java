package myapps.analisibioscav;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myapps.analisibioscav.datamodel.AnalisiDAO;
import myapps.analisibioscav.gui.ControllerLoader;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private ControllerLoader controllerLoader;
    private AnalisiDAO analisiDAO;

    @Override
    public void init(){
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