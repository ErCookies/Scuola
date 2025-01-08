/*
    Realizzare la classe Cerchio che implementa tutto ciò che serve er gestire un cerchio su piano cartesiano.
    Il cerchio parte con la conoscenza della posizione del centro e del raggio e permette di:
    a) sapere se un punto p(x,y) appartiene o no alla circonferenza del cerchio,
    b) indicare in quale quadrante si trova il centro del cerchio,
    c) restituire area e perimetro,
    d) getter e setter del centro e del raggio
    Realizzare il programma che gestisce due cerchi con inserimento dei dati e determinazione del cerchio di area massima.
*/

public class Main {
    public static void main(String[] args) {
        Cerchio c1 = null;
        Cerchio c2 = null;
        while(c1 == null)
            c1 = insDati();
        while(c2 == null)
            c2 = insDati();
        if(c1.area() > c2.area())
            System.out.println("Il primo cerchio ha area maggiore");
        else
            System.out.println("Il secondo cerchio ha area maggiore");
    }

    public static Cerchio insDati(){
        double x, y, r;
        Input lg;
        Cerchio c;
        lg = new Input();
        x = lg.dbl(- Double.MAX_VALUE,Double.MAX_VALUE,"Inserire ascissa del centro: ");
        y = lg.dbl(- Double.MAX_VALUE,Double.MAX_VALUE,"Inserire ordinata del centro: ");
        r = lg.dbl(0,Double.MAX_VALUE,"Inserire raggio del cerchio: ");
        try {
            c = new Cerchio(x, y, r);
        }
        catch(IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
            return null;
        }
        return c;
    }
}