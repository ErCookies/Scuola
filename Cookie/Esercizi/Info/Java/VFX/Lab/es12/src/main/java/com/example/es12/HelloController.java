package com.example.es12;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    private LampadinaRGB lamp;
    @FXML private Button btnCreate;
    @FXML private Button btnDelete;
    @FXML private Button btnOnOff;
    @FXML private Button btnLum;
    @FXML private Button btnRGB;
    @FXML private Circle crcLamp;
    @FXML private ImageView img;
    @FXML private Label lblErrCreate;
    @FXML private Label lblErrDelete;
    @FXML private Label lblErrLum;
    @FXML private Label lblErrRGB;
    @FXML private TextField txtB;
    @FXML private TextField txtG;
    @FXML private TextField txtLum;
    @FXML private TextField txtName;
    @FXML private TextField txtR;

    public void btnCreateOnClick(){
        try{
            if(this.lamp == null){
                this.lamp = new LampadinaRGB(txtName.getText());
                this.crcLamp.setVisible(false);
                disabilita(false);
            }
            else
                throw new IllegalStateException("Lampadina gia' esistente");
        }
        catch(IllegalArgumentException | NullPointerException | IllegalStateException e){
            this.lblErrCreate.setText(e.getMessage());
        }
    }

    public void btnOnOffOnClick(){
        if(this.lamp.isStateON()){
            this.lamp.spegni();
            this.crcLamp.setVisible(false);
        }
        else{
            this.lamp.accendi();
            this.crcLamp.setVisible(true);
            this.crcLamp.setFill(Color.rgb(lamp.getR(), lamp.getG(), lamp.getB()));
        }
    }

    public void btnLumOnClick(){
        try{
            this.lamp.setLum(Integer.parseInt(txtLum.getText()));
            this.crcLamp.setOpacity(((double)lamp.getLum() / 5));
            this.crcLamp.setFill(Color.rgb(lamp.getR(), lamp.getG(), lamp.getB()));
        }
        catch(NumberFormatException e){
            this.lblErrLum.setText("Inserire valore lum");
        }
        catch(IllegalArgumentException e){
            this.lblErrLum.setText(e.getMessage());
        }
    }

    public void btnRGBOnClick(){
        try{
            int r = Integer.parseInt(txtR.getText());
            int g = Integer.parseInt(txtG.getText());
            int b = Integer.parseInt(txtB.getText());
            this.lamp.setRGB(r,g,b);
            this.crcLamp.setFill(Color.rgb(lamp.getR(), lamp.getG(), lamp.getB()));
        }
        catch(NumberFormatException e){
            this.lblErrRGB.setText("Inserire 3 valori RGB (0-255)");
        }
        catch(IllegalArgumentException e){
            this.lblErrRGB.setText(e.getMessage());
        }
    }

    public void btnDeleteOnClick(){
        if(lamp != null){
            crcLamp.setVisible(false);
            lamp = null;
            disabilita(true);
        }
        else
            lblErrDelete.setText("Lampadina inesistente");
    }

    public void txtNameOnKeyPressed(){
        this.lblErrCreate.setText("");
        this.lblErrDelete.setText("");
    }
    public void txtNameOnClick(){
        this.txtName.setText("");
    }
    public void txtLumOnKeyPressed(){
        this.lblErrLum.setText("");
        this.lblErrLum.setText("");
    }
    public void txtLumOnClick(){
        this.txtLum.setText("");
    }
    public void txtRGBOnKeyPressed(){
        this.lblErrRGB.setText("");
        this.lblErrRGB.setText("");
    }
    public void txtROnClick(){
        this.txtR.setText("");
    }
    public void txtGOnClick(){
        this.txtG.setText("");
    }
    public void txtBOnClick(){
        this.txtB.setText("");
    }
    public void disabilita(boolean state){
        this.btnOnOff.setDisable(state);
        this.txtLum.setDisable(state);
        this.btnLum.setDisable(state);
        this.txtR.setDisable(state);
        this.txtG.setDisable(state);
        this.txtB.setDisable(state);
        this.btnRGB.setDisable(state);
        this.btnDelete.setDisable(state);
    }
}
