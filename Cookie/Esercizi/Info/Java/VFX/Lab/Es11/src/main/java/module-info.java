module com.example.es11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.es11 to javafx.fxml;
    exports com.example.es11;
}