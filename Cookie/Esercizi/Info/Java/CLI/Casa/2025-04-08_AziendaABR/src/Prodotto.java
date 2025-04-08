import java.io.IOException;
import java.io.RandomAccessFile;

public class Prodotto implements IOFileRandom {
    public static int LENSTR = 20;
    // public static int LENREC = 32;
    private int cod;
    private String nome;
    private double prz;

    public int getCod() {
        return cod;
    }
    public void setCod(int cod){
        if(cod < 0)
            throw new IllegalArgumentException("Codice non valido");
        else
            this.cod = cod;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Nome non valido");
        else
            this.nome = nome;
    }

    public double getPrz() {
        return prz;
    }
    public void setPrz(double prz) {
        if(prz <= 0)
            throw new IllegalArgumentException("Prezzo non valido");
        else
            this.prz = prz;
    }

    public Prodotto(int cod, String nome, double prz)
            throws IllegalArgumentException
    {
        setCod(cod);
        setNome(nome);
        setPrz(prz);
    }

    public Prodotto()
    {
        cod = 1;
        nome = "A";
        prz = 1.0;
    }

    public void write(RandomAccessFile raf)
            throws IOException
    {
        raf.writeInt(cod);
        Input.writeString(raf, nome, LENSTR);
        raf.writeDouble(prz);
    }

    public void read(RandomAccessFile raf)
            throws IOException
    {
        cod = raf.readInt();
        nome = Input.readString(raf, LENSTR);
        prz = raf.readDouble();
    }

    @Override
    public String toString()
    {
        return getCod() + " - " + getNome() + " - " + getPrz();
    }
}
