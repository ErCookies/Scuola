package com.example.es14;

public class Cassaforte {
    private final int saldoMax;
    private double saldo;

    public Cassaforte(int saldoMax)
    {
        if(saldoMax <= 0)
            throw new IllegalArgumentException("Saldo massimo non valido");
        else{
            this.saldoMax = saldoMax;
            this.saldo = 0;
        }
    }

    public double getSaldo() {
        return saldo;
    }
    public int getSaldoMax(){
        return this.saldoMax;
    }

    public void preleva(double amount)
    {
        if(amount <= 0)
            throw new IllegalArgumentException("Quantativo non valido");
        else{
            if(amount > getSaldo())
                throw new IllegalStateException("Soldi insufficienti nel deposito");
            else
                this.saldo -= amount;
        }
    }

    public void deposita(double amount)
    {
        if(amount <= 0)
            throw new IllegalArgumentException("Quantativo non valido");
        else{
            if(getSaldo() + amount > this.saldoMax)
                throw new IllegalStateException("Non e' possibile aggiungere tale somma");
            else
                this.saldo += amount;
        }
    }

}
