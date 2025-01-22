module com.example.es12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.es12 to javafx.fxml;
    exports com.example.es12;
}