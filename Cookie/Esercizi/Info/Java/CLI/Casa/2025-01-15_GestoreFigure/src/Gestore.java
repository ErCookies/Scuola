/*
    Cucchi Francesco    4BI
    TESTO:
    Getstire quadrilateri e triangoli come elementi ereditati da classe figura e metodi comuni come stampa,
    area e perimetro.
    Realizzare un programma che gestisce n figure tramite classe GESTORE che possono essere o quadrilateri o
    triangoli (a scelta dell'utente) sui quali si possano fare le seguenti operazioni:
    1) inserimento;
    2) stampa dei dati delle figure inserite (se quadrilatero si stampa "quadrilatero+ lato1+lato2+area=.....+perimetro=...’’",
       se triangolo si stampa "triangolo+l1+l2+l3+area=....+perimetro=.....”,
    3) elenco delle aree di ogni figura in output si stampa “quadriatero: area=.....” se quadrilatero; “triangolo:area=....” se triangolo.
    Produrre classe GESTORE (con metodi add, toString ed elencoAree), la classe Figura e le classi Quadrilatero e Triangolo
    ed il main che realizzata I/O con utente e classe Gestore.
*/

import java.util.Iterator;
import java.util.LinkedList;

public class Gestore<Figura> {
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
            s = s.concat(k + ") " + f.getClass() + ": Area = "/* + f.getArea()*/ + "\n");
        }

        return s;
    }

}
