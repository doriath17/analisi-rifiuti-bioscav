module gui.components.lib {
    requires javafx.fxml;
    requires javafx.controls;

    opens com.doriath.guicomponents to javafx.fxml;

    exports com.doriath.guicomponents;
    exports com.doriath.guicomponents.util.stringconverter;
}