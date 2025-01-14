module myapps {
    requires javafx.controls;
    requires javafx.fxml;

    opens myapps to javafx.fxml;
    exports myapps;
}
