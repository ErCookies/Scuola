import java.util.ArrayList;

public class Quadrilatero extends Figura {

    public Quadrilatero() throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(4);
        this.sides = new ArrayList<>();
        for(int k = 1; k < this.getnSides() + 1; k++){
            this.setSide(k,1);
        }
    }
    public Quadrilatero(double l1, double l2, double l3, double l4) throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(4);
        this.sides = new ArrayList<>();
        this.setSide(1, l1);
        this.setSide(2, l2);
        this.setSide(3, l3);
        this.setSide(4, l4);
    }
    public Quadrilatero(Quadrilatero q) throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(4);
        this.sides = new ArrayList<>();
        for(int k = 1; k < this.getnSides() + 1; k++){
            this.setSide(k, q.getSide(k));
        }
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
        s = s.concat("area=" + this.area());
        s = s.concat("+perimetro=" + this.perimetro() + ";");
        return s;
    }

}