/*
    boolean add(E obj);         // aggiunge in coda, ritorna true se la collection cambia post operazione
    void addFirst(E obj);       // aggiunge in testa
    void addLast(T obj);        // aggiunge in coda
    void clear();               // elimina tutti gli elementi della lista
    boolean contains(E obj);    // true se la lista contiene l'elemento obj
    E element();                // ritorna senza rimuovere il primo elemento
    E getFirst();               // ritorna il primo elemento della lista
    E getLast();                // ritorna l'ultimo elemento
    E remove();                 // rimuove il primo elemento
    E removaLast();             // rimuove l'ultimo elemento
*/
public class MyList <E>{
    private Nodo<E> first;

    /// GETTER
    public Nodo<E> getFirst() {
        return first;
    }

    /// COSTRUTTORE
    public MyList(){
        this.first = null;
    }

    /// METODI
    public boolean add(E e){
        if(e != null){
            boolean val;
            if(contains(e))
                val = false;
            else{
                Nodo<E> last = new Nodo<>(e);
                Nodo<E> nodo = getFirst();
                while(nodo.getNext() != null)
                    nodo = nodo.getNext();
                nodo.setNext(last);
                val = true;
            }
            return val;
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }

    public boolean contains(E e){
        if(e != null){
            boolean con = false;
            Nodo<E> n = this.first;
            while(n != null && !con){
                if(e.equals(n))
                    con = true;
                n = n.getNext();
            }
            return con;
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }

}
