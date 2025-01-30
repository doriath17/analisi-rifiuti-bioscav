package myapps.analisibioscav.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimaryController {

    public class State {
        public final ControllerBase sx;
        public final ControllerBase showing;
        public final ControllerBase dx;

        public State(ControllerBase sx, ControllerBase showing, ControllerBase dx){
            this.sx = sx;
            this.showing = showing;
            this.dx = dx;
        }
    }

    @FXML private VBox content;
    @FXML private Button btnDx;
    @FXML private Button btnSx;

    @FXML private RadioMenuItem mItemFullscreen;

    private ControllerLoader loader;

    private State s1;
    private State s2;
    private State s3;
    private State currentState;

    public void init(ControllerLoader loader){
        this.loader = loader;
        s1 = new State(null, loader.getInputController(), loader.getResultController());
        s2 = new State(loader.getInputController(), loader.getResultController(), loader.getAnagrafeController());
        s3 = new State(loader.getResultController(), loader.getAnagrafeController(), null);
        currentState = s1;
        setContentToShow((VBox) loader.getInputController().getContent());
        mustDisable(btnSx);
    }

    public void setContentToShow(VBox content){
        this.content.getChildren().clear();
        this.content.getChildren().add(content);
    }

    private void mustDisable(Button btn){
        btn.setDisable(true);
    }

    private void mustEnable(Button btn){
        btn.setDisable(false);
    }

    @FXML private void switchToRight(){
        State from = currentState;
        if (from.equals(s1)){
            setContentToShow((VBox) s1.dx.getContent());
            currentState = s2;
            mustEnable(btnSx);
        } else if (from.equals(s2)){
            setContentToShow((VBox) s2.dx.getContent());
            currentState = s3;
            mustDisable(btnDx);
        }
    }

    @FXML private void switchToLeft(){
        State from = currentState;
        if (from.equals(s3)){
            setContentToShow((VBox) s3.sx.getContent());
            currentState = s2;
            mustEnable(btnDx);
        } else if (from.equals(s2)){
            setContentToShow((VBox) s2.sx.getContent());
            currentState = s1;
            mustDisable(btnSx);
        }
    }

    // menu items

    @FXML public void closeApp(){
        ((Stage) content.getScene().getWindow()).close();
    }

    @FXML public void setFullscreen(){
        if (mItemFullscreen.isSelected()){
            mItemFullscreen.setText("Fullscreen Attivo");
            ((Stage) content.getScene().getWindow()).setFullScreen(true);
        } else {
            mItemFullscreen.setText("Attiva Fullscreen");
            ((Stage) content.getScene().getWindow()).setFullScreen(false);
        }
    }

    @FXML private void resetInput(){
        loader.getAnalisiDAO().getInputContainer().reset();
        loader.getAnalisiDAO().getResultContainer().reset();
    }

    @FXML private void resetAnagrafe(){
        loader.getAnalisiDAO().getAnagrafeAnalisi().reset();
    }

    @FXML private void resetAllData(){
        resetInput();
        resetAnagrafe();
    }
}
