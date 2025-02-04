public class MyList <E>{
    private Nodo<E> first;

    /// GETTER
    private Nodo<E> getFirstNode() {
        return first;
    }

    /// SETTER
    public void setFirst(Nodo<E> first){
        this.first = first;
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
}
