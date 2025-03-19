public class Operaio extends Dipendente {
    private final double aum = 1.3;
    private final int hhBase = 160;
    private double pagaHH;
    private int hhXtra, hhPerm;

    /// GETTER - SETTER
    public double getPagaHH(){
        return this.pagaHH;
    }
    public void setPagaHH(double pagaHH) {
        if(pagaHH > 0)
            this.pagaHH = pagaHH;
        else
            throw new IllegalArgumentException("Paga oraria non valida");
    }

    public int getHhXtra(){
        return this.hhXtra;
    }
    public void setHhXtra(int hhXtra) {
        if(hhXtra >= 0)
            this.hhXtra = hhXtra;
        else
            throw new IllegalArgumentException("Ore di straordinario non valide");
    }

    public int getHhPerm(){
        return this.hhPerm;
    }
    public void setHhPerm(int hhPerm) {
        if(hhPerm >= 0)
            this.hhPerm = hhPerm;
        else
            throw new IllegalArgumentException("Ore di permesso non valide");
    }

    /// COSTRUTTORE
    public Operaio(int mat, String name, String sur, double pagaHH, int hhXtra, int hhPerm)
            throws IllegalArgumentException
    {
        super(mat, name, sur);
        this.setPagaHH(pagaHH);
        this.setHhXtra(hhXtra);
        this.setHhPerm(hhPerm);
    }

    /// METODI
    public int hhLavorate(){
        return (this.hhBase + getHhXtra() - getHhPerm());
    }

    @Override public String stampaDati(){
        String s = this.getMatricola() + " + ";
        s = s.concat(this.getName() + " + ");
        s = s.concat(this.getSur() + " + ");
        s = s.concat(Integer.toString(hhLavorate()));
        return s;
    }
    @Override public double calcolaPaga(){
        double stip;
        int hhLav = this.hhLavorate();
        if(hhLav <= 160)
            stip = hhLav * getPagaHH();
        else{
            int xtra = hhLav - hhBase;
            stip = (hhBase * getPagaHH()) + (xtra * getPagaHH() * aum);
        }
        return stip;
    }
}
