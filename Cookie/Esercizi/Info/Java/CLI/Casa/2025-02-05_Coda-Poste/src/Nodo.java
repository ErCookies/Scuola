public class Nodo <E>{
    private final E dati;
    private Nodo<E> next;

    /// GETTER
    public Nodo<E> getNext() {
        return this.next;
    }
    public E getDati(){
        return this.dati;
    }
    /// SETTER
    public void setNext(Nodo<E> next){
        this.next = next;
    }

    /// COSTRUTTORI
    public Nodo(E dati){
        this.dati = dati;
        setNext(null);
    }
    public Nodo(E dati, Nodo<E> next){
        this.dati = dati;
        setNext(next);
    }

}