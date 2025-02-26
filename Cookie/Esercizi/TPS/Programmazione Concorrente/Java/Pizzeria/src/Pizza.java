public class Pizza {
    private int tCott;
    private String stato;

    public Pizza(){
        tCott = 3;
        stato = "Prenotata";
    }

    public String getStato() {
        return stato;
    }
    public void setStato(String stato) {
        this.stato = stato;
    }

    public int gettCott(){
        return this.tCott;
    }
    public void settCott(int tCott) {
        this.tCott = tCott;
    }
}
