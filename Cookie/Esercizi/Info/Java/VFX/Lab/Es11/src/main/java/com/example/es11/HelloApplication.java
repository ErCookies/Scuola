/*
    Cucchi Francesco    4BI
    Realizzare un’applicazione grafica che permetta ad un utente di effettuare la somma di 2 numeri.
    L’interfaccia dovrà contenere 2 textField dove l’utente potrà inserire i numeri da sommare,
    un bottone e una label dove verrà visualizzata la somma.
*/

package com.example.es11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}