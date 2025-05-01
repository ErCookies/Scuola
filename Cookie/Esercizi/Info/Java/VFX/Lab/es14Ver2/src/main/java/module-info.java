module com.example.es14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.es14 to javafx.fxml;
    exports com.example.es14;
}