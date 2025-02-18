module com.example.presentazionejavafxcoin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.presentazionejavafxcoin to javafx.fxml;
    exports com.example.presentazionejavafxcoin;
}