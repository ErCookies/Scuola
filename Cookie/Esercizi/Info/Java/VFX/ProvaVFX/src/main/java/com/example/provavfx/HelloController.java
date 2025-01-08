package com.example.provavfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button btnMexCiao;

    @FXML
    private Label lblMexCiao;

    @FXML
    private TextField txtMex;

    public void onBtnMexCiaoClick(){
        this.lblMexCiao.setText(this.txtMex.getText());
    }
}
