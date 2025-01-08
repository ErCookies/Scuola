module com.example.provavfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.provavfx to javafx.fxml;
    exports com.example.provavfx;
}