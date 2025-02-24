package com.example.presentazionejavafxcagr;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML private Button btnCalc;
    @FXML private Label lblCagr;
    @FXML private Label lblValF;
    @FXML private Label lblValI;
    @FXML private Slider sldFinale;
    @FXML private Slider sldIniziale;
    @FXML private Spinner<Integer> spnYY;
    private final Cagr cagr = new Cagr();

    public void sldInizialeOnInteraction(){
        lblValI.setText(Integer.toString((int)sldIniziale.getValue()));
    }
    public void sldFinaleOnInteraction(){
        lblValF.setText(Integer.toString((int)sldFinale.getValue()));
    }

    public void btnCalcOnClick(){
        double c;
        cagr.setvI(sldIniziale.getValue());
        cagr.setvF(sldFinale.getValue());
        cagr.setvI(spnYY.getValue());
        c = cagr.calcoloCAGR();
        lblCagr.setText(Double.toString(c));
        if(c < 0)
            lblCagr.setTextFill(new Color(1, 0, 0, 1));
        else
            lblCagr.setTextFill(new Color(0, 0, 0, 1));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000);
        factory.setValue(1);
        spnYY.setValueFactory(factory);

        lblValI.setText(Integer.toString((int)sldIniziale.getValue()));
        lblValF.setText(Integer.toString((int)sldFinale.getValue()));
    }

    public void imgOnClick(){
        Platform.exit();
    }
}
