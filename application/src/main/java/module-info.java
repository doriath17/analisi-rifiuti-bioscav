module application {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.github.librepdf.openpdf;
    requires gui.components.lib;
    requires model;

    opens com.doriath.application to javafx.fxml;
    opens com.doriath.application.controllers to javafx.fxml;

    exports com.doriath.application;
    exports com.doriath.application.configuration;
}