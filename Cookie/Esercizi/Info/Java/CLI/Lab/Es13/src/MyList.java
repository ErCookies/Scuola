public class MyList <E extends Comparable<E> & FileCSV>{
    private String name;
    private Nodo<E> first;

    /// GETTER
    private Nodo<E> getFirstNode() {
        return first;
    }
    public String getName(){
        return this.name;
    }

    /// SETTER
    public void setFirst(Nodo<E> first){
        this.first = first;
    }
    public void setName(String name){
        if(!name.isEmpty())
            this.name = name;
        else
            throw new IllegalArgumentException("Stringa vuota");
    }

    /// COSTRUTTORE
    public MyList(){
        this.first = null;
        this.name = "";
    }
    public MyList(String name){
        setName(name);
        this.first = null;
    }

    /// METODI
    public boolean add(E e) // Aggiunta ordinata
    {
        if(e != null){
            boolean val;
            if(contains(e))
                val = false;
            else{
                Nodo<E> toAdd = new Nodo<>(e);
                if(getFirstNode() == null || e.compareTo(getFirstNode().getDati()) < 0)
                    this.first = toAdd;
                else{
                    Nodo<E> aus = getFirstNode();
                    Nodo<E> prec = null;
                    boolean tro = false;
                    while(aus != null && !tro){
                        if (e.compareTo(aus.getDati()) < 0)
                            tro = true;
                        else
                            aus = aus.getNext();
                    }
                    aus.setNext(toAdd);
                }
                val = true;
            }
            return val;
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }
    public void addFirst(E e) // Aggiunta in testa
    {
        if(e != null){
            Nodo<E> aus = getFirstNode();
            this.first = new Nodo<>(e, aus);
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }
    public void addLast(E e) // Aggiunta in coda
    {
        if(e != null){
            Nodo<E> last = new Nodo<>(e);
            if(getFirstNode() != null){
                Nodo<E> nodo = getFirstNode();
                while(nodo.getNext() != null)
                    nodo = nodo.getNext();
                nodo.setNext(last);
            }
            else
                first = last;
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }
    public void clear() // Rimozione di ogni elemento
    {
        if(getFirstNode() != null)
            this.first = null;
        else
            throw new IllegalStateException("Lista vuota");

    }
    public boolean contains(E e) // verifica se contiene l'elemento e
    {
        if(e != null){
            boolean con = false;
            if(getFirstNode() != null){
                Nodo<E> n = this.first;
                while(n != null && !con){
                    if(e.equals(n.getDati()))
                        con = true;
                    n = n.getNext();
                }
            }
            return con;
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }
    public E element() // getFirst()
    {
        if(getFirstNode() != null)
            return this.first.getDati();
        else
            throw new IllegalStateException("Lista vuota");

    }
    public E getFirst() // Ritorna il primo elemento
    {
        if(getFirstNode() != null)
            return this.first.getDati();
        else
            throw new IllegalStateException("Lista vuota");

    }
    public E get(int index) // Ritorna l'elemento ad indice index
    {
        if(index >= 0){
            if(index < size()){
                Nodo<E> node = getFirstNode();
                for(int k = 0; k < index; k++)
                    node = node.getNext();

                return node.getDati();
            }
            else
                throw new IndexOutOfBoundsException("Indice maggiore del numero di elementi");
        }
        else
            throw new IllegalArgumentException("Indice negativo");
    }
    public E getLast() // Ritorna l'ulimo elemento
    {
        if(getFirstNode() != null){
            Nodo<E> last = getFirstNode();
            while(last.getNext() != null)
                last = last.getNext();
            return last.getDati();
        }
        else
            throw new IllegalStateException("Lista vuota");

    }
    public E remove() // Rimuove e ritorna il primo elemento
    {
        if(getFirstNode() != null){
            Nodo<E> exFirst = getFirstNode();
            this.first = this.first.getNext();
            return exFirst.getDati();
        }
        else
            throw new IllegalStateException("Lista vuota");
    }
    public E remove(int index) // Rimuove e ritorna l'elemento a dindice index
    {
        if(index >= 0){
            if(index < size()){
                E val;
                if(index == 0)      // primo el
                    val = this.remove();
                else if(index == this.size() - 1)       // ultimo el
                    val = this.removeLast();
                else{       // el in centro
                    Nodo<E> prec = null;
                    Nodo<E> aus = getFirstNode();
                    for(int k = 0; k < index; k++){
                        prec = aus;
                        aus = aus.getNext();
                    }
                    prec.setNext(aus.getNext());    // sgancio di aus
                    val = aus.getDati();
                }
                return val;
            }
            else
                throw new IndexOutOfBoundsException("L'indice punta oltre l'ultimo elemento");
        }
        else
            throw new IllegalArgumentException("Indice negativo non valido");
    }
    public E removeLast() // Rimuove l'ultimo elemento
    {
        if(getFirstNode() != null){
            Nodo<E> prec = null;
            Nodo<E> last = getFirstNode();
            while(last.getNext() != null){
                prec = last;
                last = last.getNext();
            }
            if(prec == null)
                clear();
            else
                prec.setNext(null);
            return last.getDati();
        }
        else
            throw new IllegalStateException("Lista vuota");
    }
    public int size() // Ritorna il numero di nodi nella lista
    {
        int x;
        Nodo<E> aus = getFirstNode();
        for(x = 0; aus != null; x++)
            aus = aus.getNext();
        return x;
    }

    @Override
    public String toString()
    {
        if(size() > 0){
            String s = "";
            for(int k = 0; k < size(); k++)
                s = s.concat(get(k).toString() + ";");
            s = s.concat("\n");
            return s;
        }
        else
            throw new IllegalStateException("Lista vuota");
    }

    /*public E[] toArray()
    {
        E[] arr = null;
        return arr;
    }*/
}
