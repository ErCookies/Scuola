import java.util.ArrayList;

public class Figura implements FileCSV{
    protected int nSides;
    protected ArrayList<Double> sides;

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

    public String toCSV(){
        String s = "";
        s = s.concat(this.getnSides() + ";");
        for(int k = 1; k <= this.getnSides(); k++)
            s =  s.concat(this.getSide(k) + ";");
        s = s.concat(this.perimetro() + ";");
        s = s.concat(this.area() + ";\n");
        return s;
    }
    public void fromCSV(String s){
        //
    }

}
