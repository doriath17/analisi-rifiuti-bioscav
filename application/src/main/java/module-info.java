module application {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.github.librepdf.openpdf;
    requires gui.components.lib;

    opens com.doriath.application to javafx.fxml;
    opens com.doriath.application.gui to javafx.fxml;

    exports com.doriath.application;
    exports com.doriath.application.configuration;
}