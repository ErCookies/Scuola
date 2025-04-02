package com.example.threadvfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Label lblContent;

    @FXML
    private TextField txtContent;

    @FXML
    void onBtnAvviaClick() {
        String content = txtContent.getText();
        Printer p = new Printer(content, HelloController.this);
        p.start();
    }

    public void stampaContenuto(String content){
        javafx.application.Platform.runLater(() -> {
            lblContent.setText(content);
        });
    }

}
