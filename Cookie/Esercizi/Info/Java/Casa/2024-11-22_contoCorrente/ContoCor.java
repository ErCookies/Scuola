/*
    DOCUMENTAZIONE CLASSE:
    ContoCor
    Questa classe permette di gestire un singolo conto corrente, insieme alle operazioni fondamentali ad esso associate

    Costruttori
    ContoCor()
                Crea un nuovo conto corrente con codice identificativo "0123456789ABCDEFGHIJ" e saldo iniziale 0€

    ContoCor(String cod, double saldo)
                Crea un nuovo conto corrente con codice (cod) e saldo iniziale (saldo)

    ContoCor(ContoCor c)
                Crea un nuovo conto corrente copiando il gia' esistente (c)

    Metodi
    double      getSaldo()
                Ritorna il valore attuale del saldo

    String      getCod()
                Ritorna il codice identificativo del conto

    void        versamento(double x)
                Aggiunge (x) al valore attuale del saldo

    void        prelievo(double x)
                Sottrae (x) al valore attuale del saldo
*/

public class ContoCor {
    private String cod; //20 cifre
    private double saldo;

    public ContoCor(){
        this.cod = new String("0123456789ABCDEFGHIJ");
        this.saldo = 0;
    }
    public ContoCor(String cod, double saldo){
        if(cod.length() == 20)
            this.cod = cod.intern();
        else
            throw new IllegalArgumentException("Errore nella creazione del conto\nCodice invalido");
        if(saldo >= 0)
            this.saldo = saldo;
        else
            throw new IllegalArgumentException("Errore nella creazione del conto\nSaldo negativo");
    }
    public ContoCor(ContoCor c){
        this.cod = c.cod.intern();
        this.saldo = c.saldo;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public String getCod(){
        return this.cod.intern();
    }


    public void versamento(double x){
        if(x > 0)
            this.saldo += x;
        else
            throw new IllegalArgumentException("Errore nel versamento\nQuantitativo negativo");
    }

    public void prelievo(double x){
        if(x > 0) {
            if(this.saldo - x > 0)
                this.saldo -= x;
            else
                throw new IllegalArgumentException("Errore nel prelievo\nQuantitativo maggiore del saldo corrente");
        }
        else
            throw new IllegalArgumentException("Errore nel prelievo\nQuantitativo negativo");
    }
}
