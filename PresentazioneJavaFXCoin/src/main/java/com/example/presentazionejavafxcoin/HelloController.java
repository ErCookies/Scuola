package com.example.presentazionejavafxcoin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

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

    /// alla modifica del valore dello slider
    public void onSldBetInteraction(){
        lblVal.setText(Integer.toString((int)sldBet.getValue()));
        btnPlay.setDisable(false);
    }

    /// pressione button per giocare
    public void onBtnPlayClick(){
        btnReset.setDisable(false);
        try{
            //random testa o croce
            coin.flip();

            //TEST
            //System.out.println("Tent: " + spnBet.getValue());
            //System.out.println("Risultato: " + coin.getRand());
            //System.out.println("Corrispondono? " + (spnBet.getValue() == coin.getRand()));

            //disabilitazione slider e button
            sldBet.setDisable(true);
            btnPlay.setDisable(true);

            //pausa per suspance
            Thread.sleep(2000);

            //mostra faccia moneta
            showCoin(coin.getRand());

            //gestione punteggi
            result(spnBet.getValue(), coin.getRand(), sldBet.getValue());

            //disabilitazione spinner
            spnBet.setDisable(true);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        //se si hanno finito i soldi
        catch(IllegalStateException e){
            disableAll();
            lblSoldi.setTextFill(new Color(1, 0, 0, 1));
        }
    }

    /// disabilita tutti gli elementi interagibili
    public void disableAll(){
        sldBet.setDisable(true);
        btnReset.setDisable(true);
        btnPlay.setDisable(true);
        spnBet.setDisable(true);
    }

    /// gestione risultato
    public void result(int bet, int res, double value){
        //detrazione puntata
        sldBet.setMax((int)(sldBet.getMax() - sldBet.getValue()));

        //vincita puntata
        if(bet == res)
            sldBet.setMax((int)(sldBet.getMax() + (value*2)));

        //mostra il risultato
        lblSoldi.setText(Integer.toString((int)sldBet.getMax()));

        //applica le modifiche allo slider
        // + controllo se si hanno altri soldi
        if((int)(sldBet.getMax() / 10) > 0)
            sldBet.setMajorTickUnit((int)(sldBet.getMax() / 10));
        else
            throw new IllegalStateException("Hai finito i soldi");

        if(Integer.parseInt(lblVal.getText()) > sldBet.getMax())
            lblVal.setText(Integer.toString((int)sldBet.getMax()));

        //disabilita il bottone play se la puntata precedente non puo' essere effettuata,
        //obbligando la modifica della stessa
        if(Integer.parseInt(lblVal.getText()) > sldBet.getMax())
            btnPlay.setDisable(true);
    }

    /// mostra moneta (1 - TESTA | 2 CROCE)
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

    /// preparazione alla prossima giocata
    public void BtnResetOnClick(){
        btnReset.setDisable(true);
        sldBet.setDisable(false);
        btnPlay.setDisable(false);
        spnBet.setDisable(false);
        imgCoinTails.setVisible(false);
        imgCoinHeads.setVisible(false);
    }

    /// inizializzazione scena
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2);
        factory.setValue(1);
        spnBet.setValueFactory(factory);

        lblVal.setText(Integer.toString((int)sldBet.getValue()));
        lblSoldi.setText(Integer.toString((int)sldBet.getMax()));
    }

    /// interruzione applicazione
    public void imgOnClick(){
        Platform.exit();
    }
}
