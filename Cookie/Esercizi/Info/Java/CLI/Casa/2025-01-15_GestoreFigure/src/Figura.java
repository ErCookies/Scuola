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

public class Figura {
    protected int nSides;
    protected ArrayList<Double> sides;
    protected double area, per;

    @Override
    public String toString() {
        return this.sides.toString();
    }
    protected double area(){
        return 0;
    }
    protected double perimetro(){
        double p = 0;
        for(int k = 1; k <= this.getnSides(); k++)
            p += this.getSide(k);
        return p;
    }

    /// GETTER
    public double getArea(){
        return this.area;
    }
    public double getPer(){
        return this.per;
    }
    public int getnSides(){
        return this.nSides;
    }
    public Double getSide(int num){
        if(num - 1 >= 0){
            if(num - 1 < this.getnSides())
                return this.sides.get(num - 1);
            else
                throw new IndexOutOfBoundsException("Indice maggiore del numero di elementi");
        }
        else
            throw new IndexOutOfBoundsException("Indice negativo");
    }

    /// SETTER
    protected void setArea(double area){
        if(area >= 0){
            this.area = area;
        }
        else
            throw new IllegalArgumentException("Area non positiva");
    }
    protected void setPer(double per){
        if(per >= 0){
            this.per = per;
        }
        else
            throw new IllegalArgumentException("Perimetro non positivo");
    }
    protected void setnSides(int nSides){
        if(nSides >=3)
            this.nSides = nSides;
        else
            throw new IllegalArgumentException("Numero lati non valido");
    }
    protected void setSide(int num, double value){
        if(num - 1 >= 0 && num - 1 <= this.getnSides())
            if(value > 0){
                if(num == this.sides.size() && !this.isFull())
                    this.sides.set(num - 1, value);
                else
                    this.sides.add(value);
            }
            else
                throw new IllegalArgumentException("Valore da assegnare al lato non positivo");
        else
            throw new IndexOutOfBoundsException("Numero lato non valido");
    }

    protected boolean isFull(){
        return this.sides.size() == this.getnSides();
    }
}
