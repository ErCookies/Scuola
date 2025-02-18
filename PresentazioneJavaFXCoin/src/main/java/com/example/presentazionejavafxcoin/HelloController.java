package com.example.presentazionejavafxcoin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private Button btnPlay;
    @FXML private ImageView imgCoinHeads;
    @FXML private ImageView imgCoinTails;
    @FXML private Label lblVal;
    @FXML private Label lblTest;
    @FXML private Slider sldBet;
    @FXML private Spinner<Integer> spnNumBet;

    public void onSldBetHover(){
        lblVal.setText(Double.toString(sldBet.getValue()));
    }

    public void onBtnPlayClick(){
        try{
            Coin coin = new Coin();
            //
            /*int randx;
            for(int numBet = spnNumBet.getValue(); numBet != 0; numBet--){
                randx = (int)Math.round(Math.random());
                System.out.println("Numero: " + numBet + " | Ris: " + randx);
                Thread.sleep(2000);
                lblTest.setText(Integer.toString(numBet));
            }*/
            //
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
        factory.setValue(1);
        spnNumBet.setValueFactory(factory);
    }

    public void imgOnClick(){
        Platform.exit();
    }
}
