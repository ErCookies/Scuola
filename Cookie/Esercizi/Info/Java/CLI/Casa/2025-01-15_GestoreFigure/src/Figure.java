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

public class Figure {
    protected int nSides;
    protected ArrayList<Double> sides;
    protected double area, per;

    public void stampa() {
        //
    }
    public void area(){
        //
    }
    public void perimetro(){
        //
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
    public Double getSide(int index){
        if(index > 0){
            if(index <= this.nSides)
                return this.sides.get(index - 1);
                // -1 perche' il lato 1 sara' ad indice 0 e cosi' via
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
        if(nSides >= 3)
            this.nSides = nSides;
        else
            throw new IllegalArgumentException("Numero lati non valido");
    }
}
