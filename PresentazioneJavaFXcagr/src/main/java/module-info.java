module com.example.presentazionejavafxcagr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.presentazionejavafxcagr to javafx.fxml;
    exports com.example.presentazionejavafxcagr;
}