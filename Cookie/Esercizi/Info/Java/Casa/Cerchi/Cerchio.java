/*
    DOCUMENTAZIONE CLASSE
    Cerchio
    metodi
     + appart, verifica se un punto appartiene al cerchio, boolean
     + quad, ritorna il quadrante di appartenenza del cerchio, int
     + area, ritorna l'area, double
     + per, ritorna il perimetro, double
     + getX, ritorna l'atr X, double
     + setX, imposta l'atr X, void
     + getY, ritorna l'atr Y, double
     + setY, imposta l'atr Y, void
     + getRaggio, ritorna l'atr raggio, double
     + setRaggio, imposta l'atr raggio, void
*/

public class Cerchio {
    private double x, y, raggio;

    public Cerchio() {
        this.x = 0;
        this.y = 0;
        this.raggio = 1;
    }
    public Cerchio(double x, double y, double raggio){
        this.x = x;
        this.y = y;
        if(raggio > 0)
            this.raggio = raggio;
        else
            throw new IllegalArgumentException("Errore, raggio non positivo");
    }
    public Cerchio(Cerchio c){
        if(c != null){
            this.x = c.x;
            this.y = c.y;
            this.raggio = c.raggio;
        }
        else
            throw new IllegalArgumentException("Errore, oggetto non ancora istanziato");
    }

    public boolean appart(double x, double y){
        return (Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) == Math.pow(this.raggio, 2));
    }

    public boolean appart(){
        Input lg = new Input();
        double x = lg.dbl(- Double.MAX_VALUE, Double.MAX_VALUE, "Inserire x del punto: ");
        double y = lg.dbl(- Double.MAX_VALUE, Double.MAX_VALUE, "Inserire y del punto: ");
        return (Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) == Math.pow(this.raggio, 2));
    }

    public int quad(){
        int q;
        if(this.x == 0 && this.y > 0)
            q = 12;
        else if(this.x == 0 && this.y < 0)
            q = 34;
        else if(this.y == 0 && this.x > 0)
            q = 14;
        else if(this.y == 0 && this.x < 0)
            q = 23;
        else if(this.x > 0 && this.y > 0)
            q = 1;
        else if(this.x > 0 && this.y < 0)
            q = 2;
        else if(this.x < 0 && this.y < 0)
            q = 3;
        else if(this.x < 0 && this.y > 0)
            q = 4;
        //else if(this.x == 0 && this.y == 0)
        else
            q = 0;

        return q;
    }

    /*a) sapere se un punto p(x,y) appartiene o no alla circonferenza del cerchio,
    b) indicare in quale quadrante si trova il centro del cerchio,
    c) restituire area e perimetro,
    d) getter e setter del centro e del raggio*/
}
