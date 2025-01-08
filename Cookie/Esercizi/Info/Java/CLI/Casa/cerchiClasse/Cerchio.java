/*
    DOCUMENTAZIONE CLASSE
    Cerchio

    metodi
    boolean         appart()
                    Verifica che un punto appartenga alla circonferenza. L'inserimento delle coordinate e' interno al metodo.
                    Sees if a point belongs to the circumference. The input of the coords is inside the method.
    boolean         appart(double x, double y)
                    Verifica che un punto appartenga alla circonferenza. Le coordinate sono passate come parametri.
                    Sees if a point belongs to the circumference. The coords are passed as parameters.
    double          area()
                    Ritorna l'area del cerchio.
                    Returns the area of the circle.
    getRaggio, ritorna l'atr raggio, double
    double          getRaggio()
                    Ritorna il raggio del cerchio.
                    Returns the radius of the circle.
    getX, ritorna l'atr X, double
    double          getX()
                    Ritorna la coordinata X del centro cel cerchio
                    Returns the X coordinate of the circle center
    getY, ritorna l'atr Y, double
    double          getY()
                    Ritorna la coordinata Y del centro cel cerchio
                    Returns the Y coordinate of the circle center
    per, ritorna il perimetro, double
    double          per()
                    Ritorna il perimetro della circonferenza.
                    Returns the perimeter of the circumference.
    setRaggio, imposta l'atr raggio, void
    void            setRaggio(double r)
                    Imposta l'attributo raggio al parametro r.
                    Sets the raggio attribute to the r parameter
    setX, imposta l'atr X, void
    void            setX(double x)
                    Imposta l'attributo x al parametro x.
                    Sets the x attribute to the x parameter
    setY, imposta l'atr Y, void
    void            setY(double y)
                    Imposta l'attributo y al parametro y.
                    Sets the y attribute to the y parameter
    quad, ritorna il quadrante di appartenenza del centro del cerchio, int
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

    public boolean appart(double x, double y) {
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
        if(this.x != 0 && this.y != 0) {
            if (this.x > 0 && this.y > 0)
                q = 1;
            else if (this.x > 0 && this.y < 0)
                q = 2;
            else if (this.x < 0 && this.y < 0)
                q = 3;
            else if (this.x < 0 && this.y > 0)
                q = 4;
                //else if(this.x == 0 && this.y == 0)
            else
                q = 0;
        }
        else
            throw new IllegalArgumentException("Una delle coordinate e' 0:\nIl centro del cerchio non appartiene ad alcun quadrante");
        return q;
    }
    public double area(){
        return (Math.PI * Math.pow(this.raggio, 2));
    }
    public double perim(){
        return 2 * Math.PI * this.raggio;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getRaggio() {
        return raggio;
    }
    public void setRaggio(double r) {
        this.raggio = r;
    }
}
