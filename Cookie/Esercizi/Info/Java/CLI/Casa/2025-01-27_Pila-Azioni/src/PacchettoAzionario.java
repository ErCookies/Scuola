import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PacchettoAzionario implements FileCSV, Copyable<PacchettoAzionario>{

    private int num;
    private double value;
    private Date data;
    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    /// GETTER
    public int getNum(){
        return this.num;
    }
    public double getValue(){
        return this.value;
    }
    public Date getData() {
        return this.data;
    }

    /// SETTER
    public void setData(Date data){
        if(data != null)
            this.data = data;
        else
            throw new NullPointerException("Puntatore a NULL non consentito");
    }
    public void setNum(int num){
        if(this.num >= 0)
          this.num = num;
        else
            throw new IllegalArgumentException("Numero non valido");
    }
    public void setValue(double value){
        if(value > 0)
            this.value = value;
        else
            throw new IllegalArgumentException("Valore non valido");
    }

    /// COSTRUTTORI
    public PacchettoAzionario(){
        this.setNum(1);
        this.setValue(1);
        this.setData(new Date());
    }
    public PacchettoAzionario(int num, double value) throws IllegalArgumentException{
        this.setNum(num);
        this.setValue(value);
        this.setData(new Date());
    }
    private PacchettoAzionario(int num, double value, Date data) throws IllegalArgumentException{
        this.setNum(num);
        this.setValue(value);
        this.setData(data);
    }
    public PacchettoAzionario(PacchettoAzionario p){
        if(p != null){
            setNum(p.getNum());
            setValue(p.getValue());
            setData(p.getData());
        }
        else throw new NullPointerException("Puntatore a NULL non consentito");
    }

    /// METODI INTERFACE FILECSV
    public String toCSV(){
        String s = "";
        s = s.concat(getNum() + ";");
        s = s.concat(getValue() + ";");
        s = s.concat(df.format(getData()) + ";");
        return s;
    }

    public void fromCSV(String s) {
        StringTokenizer toks = new StringTokenizer(s,";");
        try{
            setNum(Integer.parseInt(toks.nextToken()));
            setValue(Double.parseDouble(toks.nextToken()));
            setData(df.parse(toks.nextToken()));
        }
        catch(ParseException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    /// METODO COPY
    public PacchettoAzionario copy(){
        return new PacchettoAzionario(getNum(), getValue(), getData());
    }
}
