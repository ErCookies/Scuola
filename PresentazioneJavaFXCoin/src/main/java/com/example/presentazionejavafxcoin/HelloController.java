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
    @FXML private Button btnReset;
    @FXML private ImageView imgCoinHeads;
    @FXML private ImageView imgCoinTails;
    @FXML private Label lblVal;
    @FXML private Label lblSoldi;
    @FXML private Slider sldBet;
    @FXML private Spinner<Integer> spnBet;

    private final Coin coin = new Coin();

    public void onSldBetInteraction(){
        lblVal.setText(Integer.toString((int)sldBet.getValue()));
    }

    public void onBtnPlayClick(){
        btnReset.setDisable(false);
        try{
            coin.flip();

            //TEST
            System.out.println("Tent: " + spnBet.getValue());
            System.out.println("Risultato: " + coin.getRand());
            System.out.println("Corrispondono? " + (spnBet.getValue() == coin.getRand()));

            sldBet.setDisable(true);
            btnPlay.setDisable(true);

            Thread.sleep(2000);

            showCoin(coin.getRand());
            result(spnBet.getValue(), coin.getRand(), sldBet.getValue());
            spnBet.setDisable(true);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        catch(IllegalStateException e){
            disableAll();
        }
    }

    public void disableAll(){
        sldBet.setDisable(true);
        btnReset.setDisable(true);
        btnPlay.setDisable(true);
        spnBet.setDisable(true);
    }

    public void result(int bet, int res, double value){
        sldBet.setMax((int)(sldBet.getMax() - sldBet.getValue()));

        if(bet == res)
            sldBet.setMax((int)(sldBet.getMax() + (value*2)));

        lblSoldi.setText(Integer.toString((int)sldBet.getMax()));

        if((int)(sldBet.getMax() / 10) > 0)
            sldBet.setMajorTickUnit((int)(sldBet.getMax() / 10));
        else
            throw new IllegalStateException("Hai finito i soldi");
    }

    public void showCoin(int rand){
        if(rand == 1){
            imgCoinHeads.setVisible(true);
            imgCoinTails.setVisible(false);
        }
        else{
            imgCoinTails.setVisible(true);
            imgCoinHeads.setVisible(false);
        }
    }

    public void BtnResetOnClick(){
        btnReset.setDisable(true);
        sldBet.setDisable(false);
        btnPlay.setDisable(false);
        spnBet.setDisable(false);
        imgCoinTails.setVisible(false);
        imgCoinHeads.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2);
        factory.setValue(1);
        spnBet.setValueFactory(factory);

        lblVal.setText(Integer.toString((int)sldBet.getValue()));
        lblSoldi.setText(Integer.toString((int)sldBet.getMax()));
    }

    public void imgOnClick(){
        Platform.exit();
    }
}
