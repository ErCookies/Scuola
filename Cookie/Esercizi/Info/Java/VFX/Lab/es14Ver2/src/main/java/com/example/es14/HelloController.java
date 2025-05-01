package com.example.es14;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML private Label lblMax;
    @FXML private Label lblOperazioneAtt;
    @FXML private Label lblSaldo;
    @FXML private Label lblSldSoldi;
    @FXML private Slider sldSoldi;
    @FXML private ListView<Operazione> lstElenco;
    private ListView<Operazione> ausList;

    private Cassaforte cassaforte;
    private ArrayList<Operazione> operazioni;

    public void stampaContenuto(Operazione op)
    {
        javafx.application.Platform.runLater(() -> {
            String tipo;
            if(op.isPrel()){
                tipo = "Prelievo: ";
            }
            else{
                tipo = "Deposito: ";
            }
            setExc(tipo + op.getAmount() + " --> Operazione effettuata");
            lblSaldo.setText(Double.toString(cassaforte.getSaldo()));
        });
    }

    public void sldSoldiOnInteraction(){
        lblSldSoldi.setText(Double.toString(sldSoldi.getValue()));
    }

    public void btnPrelOnClick()
    {
        double amount;
        try{
            amount = sldSoldi.getValue();
            if(amount <= 0)
                setExc("Inserire un importo valido");
            else{
                Operazione op = new Operazione(true, amount, this.cassaforte, HelloController.this);
                op.setUncaughtExceptionHandler((t, e) ->{
                    Platform.runLater(()->{
                        setExc("Errore Prelievo: " + e.getMessage());
                    });
                });
                //
                operazioni.add(op);
                lblOperazioneAtt.setText("Operazione di prelievo aggiunta");
            }
        }
        catch(NumberFormatException | NullPointerException e){
            setExc("Inserire un numero");
        }
    }

    public void btnDepOnClick()
    {
        double amount;
        try{
            amount = sldSoldi.getValue();
            if(amount <= 0)
                setExc("Inserire un importo valido");
            else{
                Operazione op = new Operazione(false, amount, this.cassaforte, HelloController.this);
                op.setUncaughtExceptionHandler((t, e) ->{
                    Platform.runLater(()->{
                        setExc("teErrore Deposito: " + e.getMessage());
                    });
                });
                operazioni.add(op);
                lblOperazioneAtt.setText("Operazione di deposito aggiunta");
            }
        }
        catch(NumberFormatException | NullPointerException e){
            setExc("Inserire un numero");
        }
    }

    public void btnStartOnClick(){
        if(operazioni.isEmpty())
            setExc("Nessuna operazione da eseguire");
        else{
            for(Operazione op: operazioni){
                op.start();
            }
            operazioni.clear();
        }
    }

    public void setExc(String txt){
        lblOperazioneAtt.setText(txt);
    }

    public void clearStatus(){
        setExc("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.cassaforte = new Cassaforte(50);
        this.operazioni = new ArrayList<>();
        this.lstElenco = new ListView<>();
        lblMax.setText(Integer.toString(cassaforte.getSaldoMax()));
        lblSaldo.setText(Double.toString(cassaforte.getSaldo()));
        sldSoldiOnInteraction();
    }
}
