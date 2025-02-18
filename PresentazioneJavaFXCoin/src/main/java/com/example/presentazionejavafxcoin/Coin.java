package com.example.presentazionejavafxcoin;

public class Coin{
    private int rand;

    public Coin(){
        rand = 0;
    }

    public int getRand() {
        return rand;
    }

    public void flip(){
        this.rand = (int)Math.round(Math.random()) + 1;
    }
}
