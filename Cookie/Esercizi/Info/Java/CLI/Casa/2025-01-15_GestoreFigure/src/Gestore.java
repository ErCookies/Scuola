import java.util.Iterator;
import java.util.LinkedList;

public class Gestore{
    private final LinkedList<Figura> figs;

    public Gestore(){
        this.figs = new LinkedList<>();
    }

    public void add(Figura f){
        if(f != null)
            this.figs.add(f);
        else
            throw new NullPointerException("Puntatore a NULL non valido");
    }

    public String toString(){
        String s = "";
        Iterator<Figura> it = this.figs.iterator();
        Figura f;
        for(int k = 1; it.hasNext(); k++){
            f = it.next();
            s = s.concat(k + ") " + f.toString() + "\n");
        }
        return s;
    }

    public String elencoAree(){
        String s = "";
        Iterator<Figura> it = this.figs.iterator();
        Figura f;
        for(int k = 1; it.hasNext(); k++){
            f = it.next();

            s = s.concat(k + ") " + f.getClass() + ": Area = " + f.area() + "\n");
        }

        return s;
    }

}
