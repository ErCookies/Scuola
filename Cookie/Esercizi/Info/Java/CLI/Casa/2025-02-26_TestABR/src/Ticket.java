import java.util.StringTokenizer;

public class Ticket implements Comparable<Ticket>, FileCSV, Copyable<Ticket>{
    private int num;

    /// COSTRUTTORI
    public Ticket(){
        this.num = 1;
    }
    public Ticket(int num){
        this.num = num;
    }

    /// GETTER
    public int getNum(){
        return this.num;
    }

    @Override
    public String toString(){
        return Integer.toString(this.getNum());
    }

    public int compareTo(Ticket t){
        return Integer.compare(this.getNum(), t.getNum());
    }

    public String toCSV(){
        return this.getNum() + ";";
    }
    public void fromCSV(String s){
        StringTokenizer tok = new StringTokenizer(s, ";");
        this.num = Integer.parseInt(tok.nextToken());
    }

    public Ticket copy(){
        return new Ticket(this.getNum());
    }
}
