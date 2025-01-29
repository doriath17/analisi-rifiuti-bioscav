module AnalisiRifiutiBioScaV {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.librepdf.openpdf;

    opens myapps.analisibioscav to javafx.fxml;
    opens myapps.analisibioscav.gui to javafx.fxml;

    exports myapps.analisibioscav;
}