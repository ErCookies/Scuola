package com.example.presentazionejavafxcagr;

//Tasso di crescita annuo composto
//Compound annual groth rate

import java.text.DecimalFormat;

public class Cagr {
    //Valori iniziale (investimento) e finale (liquidazione)
    private double vI, vF;
    //Anni di maturazione investimento
    private int yy;
    //Necessario per arrotondare il CAGR a sole 1/2 cifre decimali
    private final DecimalFormat df = new DecimalFormat("###.##");

    /// COSTRUTTORE
    public Cagr(){
        this.vI = 0;
        this.vF = 0;
        this.yy = 0;
    }

    /// GETTER
    public double getYy() {
        return this.yy;
    }
    public double getvI() {
        return this.vI;
    }
    public double getvF() {
        return this.vF;
    }

    /// SETTER
    public void setvI(double vI) {
        if(vI > 0)
            this.vI = vI;
        else
            throw new IllegalArgumentException("Valore iniziale non valido");
    }
    //vF non necessita controlli perche' si potrebbe andare in debito
    public void setvF(double vF) {
        this.vF = vF;
    }
    public void setYy(int yy) {
        if(yy > 0)
            this.yy = yy;
        else
            throw new IllegalArgumentException("Numero anni non valido");
    }

    /// METODO CALCOLO
    public double calcoloCAGR(){
        double cagr = (Math.pow(getvF() / getvI(), 1 / getYy()) - 1) * 100;
        cagr = Double.parseDouble(df.format(cagr));
        return cagr;
    }
}
