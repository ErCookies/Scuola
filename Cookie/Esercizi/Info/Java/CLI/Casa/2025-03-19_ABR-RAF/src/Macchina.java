import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Macchina implements IOFileRandom, FileCSV, Copyable<Macchina>, Comparable<Macchina>{
    private final int LENSTR = 50;
    private String targa, marca, modello;
    private char alim;
    private double cil, prezzo;
    private int yy;

    /// GETTER - SETTER
    public int getYy() {
        return this.yy;
    }
    public void setYy(int yy) {
        if(yy >= 1900)
            this.yy = yy;
        else
            throw new IllegalArgumentException("Anno non valido");
    }

    public double getPrezzo() {
        return this.prezzo;
    }
    public void setPrezzo(double prezzo) {
        if(prezzo > 0)
            this.prezzo = prezzo;
        else
            throw new IllegalArgumentException("Prezzo non valido");
    }

    public double getCil() {
        return this.cil;
    }
    public void setCil(double cil) {
        if(cil > 0)
            this.cil = cil;
        else
            throw new IllegalArgumentException("Cilindrata non valida");
    }

    public char getAlim() {
        return this.alim;
    }
    public void setAlim(char alim) {
        this.alim = alim;
    }

    public String getModello() {
        return this.modello;
    }
    public void setModello(String modello) {
        if(!modello.isEmpty())
            this.modello = modello;
        else
            throw new IllegalArgumentException("Modello non valido");
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        if(!marca.isEmpty())
            this.marca = marca;
        else
            throw new IllegalArgumentException("Marca non valida");
    }

    public String getTarga() {
        return this.targa;
    }
    public void setTarga(String targa) {
        if(!targa.isEmpty())
            this.targa = targa;
        else
            throw new IllegalArgumentException("Targa non valida");
    }

    /// COSTRUTTORI
    public Macchina(){
        setAlim('B');
        setCil(100);
        setMarca("Ford");
        setModello("Fiesta");
        setPrezzo(100000);
        setTarga("AA111AA");
        setYy(2014);
    }
    public Macchina(char alim, double cil, String marca, String modello,
                    double prezzo, String targa, int yy) throws IllegalArgumentException{
        setAlim(alim);
        setCil(cil);
        setMarca(marca);
        setModello(modello);
        setPrezzo(prezzo);
        setTarga(targa);
        setYy(yy);
    }

    @Override
    public String toString(){
        String s = getAlim() + " ";
        s = s.concat(getCil() + " ");
        s = s.concat(getMarca() + " ");
        s = s.concat(getModello() + " ");
        s = s.concat(getPrezzo() + " ");
        s = s.concat(getTarga() + " ");
        s = s.concat(getYy() + "");
        return s;
    }

    public void write(RandomAccessFile raf) throws IOException {
        Input.write(raf, this.toString(), LENSTR);
    }
    public void read(RandomAccessFile raf) throws IOException {
         init(Input.readString(raf, LENSTR), false);
    }

    public String toCSV() {
        String s = getAlim() + ";";
        s = s.concat(getCil() + ";");
        s = s.concat(getMarca() + ";");
        s = s.concat(getModello() + ";");
        s = s.concat(getPrezzo() + ";");
        s = s.concat(getTarga() + ";");
        s = s.concat(getYy() + ";");
        return s;
    }
    public void fromCSV(String s) throws IllegalArgumentException{
        init(s, true);
    }

    private void init(String s, boolean csv){
        StringTokenizer toks;
        if(csv)
            toks = new StringTokenizer(s, ";");
        else
            toks = new StringTokenizer(s, " ");

        setAlim(toks.nextToken().charAt(0));
        setCil(Double.parseDouble(toks.nextToken()));
        setMarca(toks.nextToken());
        setModello(toks.nextToken());
        setPrezzo(Double.parseDouble(toks.nextToken()));
        setTarga(toks.nextToken());
        setYy(Integer.parseInt(toks.nextToken()));
    }

    @Override
    public Macchina copy() {
        return new Macchina(getAlim(), getCil(), getMarca(), getModello(), getPrezzo(), getTarga(), getYy());
    }

    @Override
    public int compareTo(Macchina o) {
        int x;
        if(getTarga().compareTo(o.getTarga()) > 0)
            x = 1;
        else if(getTarga().compareTo(o.getTarga()) == 0)
            x = 0;
        else
            x = -1;

        return x;
    }
}
