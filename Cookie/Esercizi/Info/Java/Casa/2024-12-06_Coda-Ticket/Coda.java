/*
    Realizzare la classe Coda di oggetti di tipo Tocket(come esercizio di allenamento
    sull'uso di arrayList o LinkedList, decidete voi quale è meglio) che esponga i seguenti
    metodi: pop, push, isEmpty, isFull, getLast. Produrre anche l'UML associato.
    Postare il tutto su OneNote.
*/
import java.util.LinkedList;

public class Coda {

    private LinkedList<Ticket> coda;
    private int nmax;

    /// GETTER - SETTER
    public int getNmax(){
        return this.nmax;
    }
    public int getSize(){
        return this.coda.size();
    }
    private void setNmax(int nmax){
        if(nmax > coda.size())
            this.nmax = nmax;
        else
            throw new IllegalArgumentException("Il numero massimo deve essere superiore della dimensione attuale della coda (" + this.getSize() + ")");
    }

    /// COSTRUTTORI
    public Coda(){          //default
        this.coda = new LinkedList<>();
        this.setNmax(10);
    }
    public Coda(int nmax){  //con parametri
        this.coda = new LinkedList<>();
        this.setNmax(nmax);
    }

    /// METODI
    public Ticket pop(){
        if(!this.isEmpty())
            return this.coda.removeFirst();
        else
            throw new IllegalStateException("La coda e' gia' vuota");
    }

    public void push(){
        if(!this.isFull())
            if(this.coda.isEmpty())
                this.coda.addLast(new Ticket(1));
            else
                 this.coda.addLast(new Ticket(this.getLastNum() + 1));
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

    public int getLastNum(){
        return this.coda.getLast().getNum();
    }
}
