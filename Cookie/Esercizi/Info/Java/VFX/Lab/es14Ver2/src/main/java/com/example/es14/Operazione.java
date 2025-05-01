package com.example.es14;

public class Operazione extends Thread{
    private boolean prel;
    private double amount;
    private Cassaforte cassaforte;
    private HelloController controller;

    public Operazione(boolean prel, double amount, Cassaforte cassaforte,
                      HelloController controller)
            throws IllegalArgumentException
    {
        this.controller = controller;
        this.cassaforte = cassaforte;
        this.prel = prel;
        setAmount(amount);
    }

    public boolean isPrel() {
        return prel;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount){
        if(amount > 0)
            this.amount = amount;
        else
            throw new IllegalArgumentException("Importo non valido");
    }

    @Override
    public void run()
            throws IllegalArgumentException, IllegalStateException
    {
        synchronized (cassaforte){
            if(isPrel()){
                cassaforte.preleva(getAmount());
            }
            else{
                cassaforte.deposita(getAmount());
            }
            controller.stampaContenuto(this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
