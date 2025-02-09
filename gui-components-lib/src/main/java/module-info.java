module gui.components.lib {
    requires javafx.fxml;
    requires javafx.controls;
    requires model;

    opens com.doriath.guicomponents to javafx.fxml;

    exports com.doriath.guicomponents;
}