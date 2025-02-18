package com.example.presentazionejavafxcoin;

public class Coin implements Runnable{
    private int rand;
    private int numFlips;

    public Coin(){
        rand = -1;
        numFlips = 1;
    }

    public Coin(int numFlips){
        rand = -1;
        this.numFlips = numFlips;
    }

    public int getRand() {
        return rand;
    }
    public int getNumFlips(){
        return numFlips;
    }

    private void flip(){
        this.rand = (int)Math.round(Math.random());
    }

    public void run(){
        for(int k = 0; k < this.numFlips; k++){
            try{
                flip();
                System.out.println("Thread ris: " + getRand());
                Thread.sleep(2000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        numFlips = 0;
    }
}
