public class Ticket {
    private final int num;
    private final String sez;

    /// COSTRUTTORI
    public Ticket(String sez){
        this.num = 1;
        this.sez = sez;
    }
    public Ticket(int num, String sez){
        this.num = num;
        this.sez = sez;
    }

    /// GETTER
    public int getNum(){
        return this.num;
    }
    public String getSez() {
        return sez;
    }

    @Override
    public String toString(){
        return getSez() + getNum();
    }
}
