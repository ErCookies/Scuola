import java.util.StringTokenizer;

public class Impiegato extends Dipendente {
    private final int DECURT = 20;
    private double salMen;
    private int hhPerm;

    /// GETTER - SETTER
    public double getSalMen(){
        return this.salMen;
    }
    public void setSalMen(double salMen) {
        if(salMen >= 0)
            this.salMen = salMen;
        else
            throw new IllegalArgumentException("Salario mensile non valido");
    }

    public int getHhPerm(){
        return this.hhPerm;
    }
    public void setHhPerm(int hhPerm) {
        if(hhPerm >= 0)
            this.hhPerm = hhPerm;
        else
            throw new IllegalArgumentException("Ore permesso non valido");
    }

    /// COSTRUTTORE
    public Impiegato(int mat, String name, String sur,
                     double salMen, int hhPerm)
            throws IllegalArgumentException
    {
        super(mat, name, sur);
        this.setSalMen(salMen);
        this.setHhPerm(hhPerm);
    }

    /// METODI
    @Override public String stampaDati(){
        String s = this.getMatricola() + " + ";
        s = s.concat(this.getName() + " + ");
        s = s.concat(this.getSur() + " + ");
        s = s.concat(Double.toString(this.getSalMen()));
        return s;
    }
    @Override public double calcolaPaga(){
        return (getSalMen() - (getHhPerm() * this.DECURT));
    }

    /// METODI INTERFACES
    public void fromCSV(String s){
        StringTokenizer toks = new StringTokenizer(s, ";");
        setMatricola(Integer.parseInt(toks.nextToken()));
        setName(toks.nextToken());
        setSur(toks.nextToken());
        setSalMen(Double.parseDouble(toks.nextToken()));
        setHhPerm(Integer.parseInt(toks.nextToken()));
    }
    public String toCSV(){
        StringBuilder s = new StringBuilder(super.toCSV());
        s.append(getSalMen() + ";");
        s.append(getHhPerm() + ";");
        return s.toString();
    }
}
