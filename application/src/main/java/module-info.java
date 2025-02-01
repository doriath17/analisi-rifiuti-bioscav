module application {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.github.librepdf.openpdf;

    opens com.doriath to javafx.fxml;
    opens com.doriath.gui to javafx.fxml;

    exports com.doriath;
}