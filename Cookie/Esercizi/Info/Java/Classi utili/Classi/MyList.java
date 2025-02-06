public class MyList <E extends Str> implements Str{
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
    public boolean add(E e){
        if(e != null){
            boolean val;
            if(contains(e))
                val = false;
            else{
                Nodo<E> last = new Nodo<>(e);
                if(getFirstNode() == null)
                    this.first = last;
                else{
                    Nodo<E> nodo = getFirstNode();
                    while(nodo.getNext() != null)
                        nodo = nodo.getNext();
                    nodo.setNext(last);
                }
                val = true;
            }
            return val;
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }
    public void addFirst(E e){
        if(e != null){
            Nodo<E> aus = getFirstNode();
            this.first = new Nodo<>(e, aus);
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }
    public void addLast(E e){
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
    public void clear(){
        if(getFirstNode() != null)
            this.first = null;
        else
            throw new IllegalStateException("Lista vuota");

    }
    public boolean contains(E e){
        if(e != null){
            boolean con = false;
            if(getFirstNode() != null){
                Nodo<E> n = this.first;
                while(n != null && !con){
                    if(e.equals(n))
                        con = true;
                    n = n.getNext();
                }
            }
            return con;
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }
    public E element(){
        if(getFirstNode() != null)
            return this.first.getDati();
        else
            throw new IllegalStateException("Lista vuota");

    }
    public E getFirst(){
        if(getFirstNode() != null)
            return this.first.getDati();
        else
            throw new IllegalStateException("Lista vuota");

    }
    public E getLast(){
        if(getFirstNode() != null){
            Nodo<E> last = getFirstNode();
            while(last.getNext() != null)
                last = last.getNext();
            return last.getDati();
        }
        else
            throw new IllegalStateException("Lista vuota");

    }
    public E remove(){
        if(getFirstNode() != null){
            Nodo<E> exFirst = getFirstNode();
            this.first = this.first.getNext();
            return exFirst.getDati();
        }
        else
            throw new IllegalStateException("Lista vuota");
    }
    public E remove(int index){
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
    public E removeLast(){
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

    public int size(){
        int x;
        Nodo<E> aus = getFirstNode();
        for(x = 0; aus != null; x++)
            aus = aus.getNext();
        return x;
    }

    public E get(int index){
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

    public String toStr(){
        if(size() > 0){
            String s = "";
            for(int k = 0; k < size(); k++)
                s = s.concat("El " + k + ": " + get(k).toStr() + "\n");
            return s;
        }
        else
            throw new IllegalStateException("Lista vuota");
    }
}
