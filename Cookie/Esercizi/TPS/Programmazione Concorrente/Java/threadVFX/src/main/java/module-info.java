module com.example.threadvfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.threadvfx to javafx.fxml;
    exports com.example.threadvfx;
}