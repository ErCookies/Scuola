import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Macchina implements IOFileRandom, FileCSV, Copyable<Macchina>, Comparable<Macchina>{
    public static final int LENSTR = 10;
    public static final int LENREC = 82;
    // 20 + 20 + 20 + 2 + 8 + 8 + 4 = 51
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
    public Macchina()
            throws IllegalArgumentException
    {
        setAlim('B');
        setCil(100);
        setMarca("Ford");
        setModello("Fiesta");
        setPrezzo(10000);
        setTarga("AA111AA");
        setYy(2014);
    }
    public Macchina(char alim, double cil, String marca, String modello,
                    double prezzo, String targa, int yy) throws IllegalArgumentException
    {
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
        String s = getTarga() + " ";
        s = s.concat(getAlim() + " ");
        s = s.concat(getCil() + " ");
        s = s.concat(getMarca() + " ");
        s = s.concat(getModello() + " ");
        s = s.concat(getPrezzo() + " ");
        s = s.concat(Integer.toString(getYy()));
        return s;
    }

    public void write(RandomAccessFile raf) throws IOException {
        Input.writeString(raf, getTarga(), LENSTR);
        raf.writeChar(getAlim());
        raf.writeDouble(getCil());
        Input.writeString(raf, getMarca(), LENSTR);
        Input.writeString(raf, getModello(), LENSTR);
        raf.writeDouble(getPrezzo());
        raf.writeInt(getYy());
    }
    public void read(RandomAccessFile raf) throws IOException {
        setTarga(Input.readString(raf, LENSTR));
        setAlim(raf.readChar());
        setCil(raf.readDouble());
        setMarca(Input.readString(raf, LENSTR));
        setModello(Input.readString(raf, LENSTR));
        setPrezzo(raf.readDouble());
        setYy(raf.readInt());
    }

    public String toCSV() {
        String s = getTarga() + ";";
        s = s.concat(getAlim() + ";");
        s = s.concat(getCil() + ";");
        s = s.concat(getMarca() + ";");
        s = s.concat(getModello() + ";");
        s = s.concat(getPrezzo() + ";");
        s = s.concat(getYy() + ";");
        return s;
    }
    public void fromCSV(String s) throws IllegalArgumentException{
        StringTokenizer toks = new StringTokenizer(s, ";");
        setTarga(toks.nextToken());
        setAlim(toks.nextToken().charAt(0));
        setCil(Double.parseDouble(toks.nextToken()));
        setMarca(toks.nextToken());
        setModello(toks.nextToken());
        setPrezzo(Double.parseDouble(toks.nextToken()));
        setYy(Integer.parseInt(toks.nextToken()));
    }

    @Override
    public Macchina copy() {
        return new Macchina(getAlim(), getCil(), getMarca(), getModello(), getPrezzo(), getTarga(), getYy());
    }

    @Override
    public int compareTo(Macchina o) {
        return Integer.compare(getTarga().compareTo(o.getTarga()), 0);
    }
}
