/*
    Realizzare la classe Coda di oggetti di tipo Tocket(come esercizio di allenamento
    sull'uso di arrayList o LinkedList, decidete voi quale è meglio) che esponga i seguenti
    metodi: pop, push, isEmpty, isFull, getLast. Produrre anche l'UML associato.
    Postare il tutto su OneNote.
*/
import java.util.ArrayList;

public class Coda {
    private ArrayList<Ticket> coda;
    private int nmax;

    /// GETTER - SETTER
    public int getNmax(){
        return this.nmax;
    }
    private void setNmax(int nmax){
        if(nmax > 0)
            this.nmax = nmax;
        else
            throw new IllegalArgumentException("Il numero massimo deve essere positivo");
    }

    /// COSTRUTTORI
    public Coda(){          //default
        this.setNmax(50);
        this.coda = new ArrayList<>(this.getNmax());
    }
    public Coda(int nmax){  //con parametri
        this.setNmax(nmax);
        this.coda = new ArrayList<>(this.getNmax());
    }

    /// METODI
    public Ticket pop(){
        if(!this.isEmpty())
            return this.coda.removeFirst();
        else
            throw new IllegalStateException("La coda e' gia' vuota");
    }

    public void push(Ticket t){
        if(!this.isFull())
            this.coda.addLast(t);
        else
            throw new IllegalStateException("La coda e' piena");
    }

    public boolean isEmpty(){
        return this.coda.isEmpty();
    }

    public boolean isFull(){
        return this.coda.size() == this.getNmax();
    }

    public Ticket getLast(){
        return this.coda.getLast();
    }
}
