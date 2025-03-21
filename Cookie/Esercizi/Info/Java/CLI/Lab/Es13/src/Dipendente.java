public class Dipendente {
    private int matricola;
    private String name, sur;

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
}
