module com.example.sudokufx.model {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.sudokufx to javafx.fxml;
    exports com.example.sudokufx.view;
}