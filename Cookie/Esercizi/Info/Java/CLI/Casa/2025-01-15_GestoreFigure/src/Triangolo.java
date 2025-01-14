import java.util.ArrayList;

public class Triangolo extends Figura {
    //

    public Triangolo() throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(3);
        this.sides = new ArrayList<>();
        for(int k = 1; k < this.getnSides() + 1; k++){
            this.setSide(k,1);
        }
        this.setPer(this.perimetro());
        this.setArea(this.area());
    }
    public Triangolo(double l1, double l2, double l3) throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(3);
        this.sides = new ArrayList<>();
        this.setSide(1, l1);
        this.setSide(2, l2);
        this.setSide(3, l3);
        this.setPer(this.perimetro());
        this.setArea(this.area());
    }

    public Triangolo(Quadrilatero q) throws IndexOutOfBoundsException, IllegalArgumentException{
        this.setnSides(3);
        this.sides = new ArrayList<>();
        for(int k = 1; k < this.getnSides() + 1; k++){
            this.setSide(k, q.getSide(k));
        }
        this.setPer(q.getPer());
        this.setArea(q.getArea());
    }

    protected double area(){
        return Math.sqrt((perimetro()/2) * ((perimetro()/2) - this.getSide(1)) * ((perimetro()/2) - this.getSide(2)) * ((perimetro()/2) - this.getSide(3)));
    }

    @Override
    public String toString(){
        String s = "Triangolo+";
        for(int k = 1; k <= this.getnSides(); k++)
            s = s.concat("l" + k + "=" + this.getSide(k) + "+");
        s = s.concat("area=" + this.getArea());
        s = s.concat("+perimetro=" + this.getPer() + ";");
        return s;
    }
}
