package com.example.threadvfx;

public class Printer extends Thread{
    private String contenuto;
    private HelloController controller;

    public String getContenuto() {
        return contenuto;
    }
    public void setContenuto(String contenuto) {
        if(!contenuto.isEmpty())
            this.contenuto = contenuto;
        else
            throw new IllegalArgumentException("Stringa vuota");
    }

    public Printer(String contenuto, HelloController controller)
            throws IllegalArgumentException
    {
        setContenuto(contenuto);
        this.controller = controller;
    }

    @Override
    public void run(){
        for(int k = 0; k < 3; k++){
            controller.stampaContenuto(getContenuto() + " - " + k);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
