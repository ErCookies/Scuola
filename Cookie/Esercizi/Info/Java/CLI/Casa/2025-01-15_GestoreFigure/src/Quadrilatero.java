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

import java.util.ArrayList;

public class Quadrilatero extends Figura {
    //

    public Quadrilatero() throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(4);
        this.sides = new ArrayList<>();
        for(int k = 1; k < this.getnSides() + 1; k++){
            this.setSide(k,1);
        }
        this.setPer(this.perimetro());
        this.setArea(this.area());
    }
    public Quadrilatero(double l1, double l2, double l3, double l4) throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(4);
        this.sides = new ArrayList<>();
        this.setSide(1, l1);
        this.setSide(2, l2);
        this.setSide(3, l3);
        this.setSide(4, l4);
        this.setPer(this.perimetro());
        this.setArea(this.area());
    }
    public Quadrilatero(Quadrilatero q) throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(4);
        this.sides = new ArrayList<>();
        for(int k = 1; k < this.getnSides() + 1; k++){
            this.setSide(k, q.getSide(k));
        }
        this.setPer(q.getPer());
        this.setArea(q.getArea());
    }

    @Override
    protected double area(){
        return (this.getSide(1) * this.getSide(2));
    }

    @Override
    public String toString(){
        String s = "Quadrilatero+";
        for(int k = 1; k <= this.getnSides(); k++)
            s = s.concat("l" + k + "=" + this.getSide(k) + "+");
        s = s.concat("area=" + this.getArea());
        s = s.concat("+perimetro=" + this.getPer() + ";");
        return s;
    }

}