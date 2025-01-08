import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Pila<T> {
    private LinkedList<T> pila;
    private int nmax;

    /// GETTER - SETTER
    public int getNmax(){
        return this.nmax;
    }
    public void setNmax(int nmax){
        if(nmax >= this.size())
            this.nmax = nmax;
        else
            throw new IllegalArgumentException("ciao");
    }
    public T getLast(){
        if(!this.pila.isEmpty())
            return this.pila.getLast();
        else
            throw new NoSuchElementException("Lista vuota, impossibile trovare elemento");
    }

    /// COSTRUTTORI
    public Pila(){
        this.pila = new LinkedList<>();
        this.setNmax(Integer.MAX_VALUE);    //virtualmente infinita
    }
    public Pila(int nmax) throws IllegalArgumentException{
        this.pila = new LinkedList<>();
        this.setNmax(nmax);
    }

    /// METODI
    public void push(T n){
        if(n != null){
            if(!this.isFull())
                this.pila.add(n);
            else
                throw new IllegalStateException("Pila piena");
        }
        else
            throw new NullPointerException("Puntatore a NULL non consentito");
    }

    public T pop(){
        if(!this.isEmpty())
            return this.pila.removeLast();
        else
            throw new NoSuchElementException("Pila vuota");
    }

    public int size(){
        return this.pila.size();
    }

    public boolean isFull(){
        return this.size() == this.getNmax();
    }

    public boolean isEmpty(){
        return this.pila.isEmpty();
    }
}
