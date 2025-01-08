package com.example.es11;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button btnSomma;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtX1;

    @FXML
    private TextField txtX2;

    public void btnSommaOnClick(){
        int x1, x2;
        x1 = Integer.parseInt(this.txtX1.getText());
        x2 = Integer.parseInt(this.txtX2.getText());
        this.lblResult.setText(String.valueOf(x1 + x2));
    }
}
