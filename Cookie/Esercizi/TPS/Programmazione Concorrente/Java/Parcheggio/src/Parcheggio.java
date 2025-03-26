public class Parcheggio {
    private int postiLib;
    private final int POSTIMAX;

    public int getPostiLib() {
        return postiLib;
    }
    public void setPostiLib(int postiLib) {
        if(postiLib >= 0)
            this.postiLib = postiLib;
        else
            throw new IllegalArgumentException("Numero posti non validi");
    }

    public Parcheggio(int postiLib) throws IllegalArgumentException{
        setPostiLib(postiLib);
        POSTIMAX = postiLib;
    }

    public void entrataAuto(){
        if(postiLib > 0)
            this.postiLib--;
        else
            throw new IllegalStateException("Non ci sono posti liberi");
    }
    public void uscitaAuto(){
        if(postiLib < POSTIMAX)
            postiLib++;
        else
            throw new IllegalStateException("Tutti i posti sono liberi");
    }
}
