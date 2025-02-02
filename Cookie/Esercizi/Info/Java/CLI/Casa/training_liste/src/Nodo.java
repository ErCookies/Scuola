public class Nodo <E>{
    private E dati;
    private Nodo<E> next;

    public Nodo<E> getNext() {
        return next;
    }
    public void setNext(Nodo<E> next){
        this.next = next;
    }

    public Nodo(E dati){
        this.dati = dati;
        setNext(null);
    }
}
