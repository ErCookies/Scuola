public class Dipendente implements Comparable<Dipendente>, FileCSV{
    protected int matricola;
    protected String name, sur;

    /// GETTER - SETTER
    public int getMatricola(){
        return this.matricola;
    }
    public void setMatricola(int matricola) {
        if(matricola >= 0)
            this.matricola = matricola;
        else
            throw new IllegalArgumentException("Matricola non valida");
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        if(name == null)
            throw new NullPointerException("Fornire un oggetto istanziato");
        else{
            if(name.isEmpty())
                throw new IllegalArgumentException("Stringa vuota");
            else
                this.name = name;
        }
    }

    public String getSur(){
        return this.sur;
    }
    public void setSur(String sur) {
        if(sur == null)
            throw new NullPointerException("Fornire un oggetto istanziato");
        else{
            if(sur.isEmpty())
                throw new IllegalArgumentException("Stringa vuota");
            else
                this.sur = sur;
        }
    }

    public String stampaDati(){
        return "";
    }
    public double calcolaPaga(){
        return 0;
    }

    /// COSTRUTTORE
    public Dipendente(int mat, String name, String sur)
            throws IllegalArgumentException
    {
        this.setMatricola(mat);
        this.setName(name);
        this.setSur(sur);
    }

    /// METODI INTERFACES
    public int compareTo(Dipendente d) {
        return this.getSur().compareTo(d.getSur());
    }

    public void fromCSV(String s){
        //
    }
    public String toCSV(){
        StringBuilder s = new StringBuilder();
        s.append(getSur() + ";");
        s.append(getName() + ";");
        s.append(getMatricola() + ";");
        return s.toString();
    }
}
