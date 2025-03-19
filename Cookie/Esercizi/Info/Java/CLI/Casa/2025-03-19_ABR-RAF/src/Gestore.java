import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;

public class Gestore {
    private final Abr abr;
    private final RandomAccessFile raf;

    /// COSTRUTTORE
    public Gestore(String filename)
            throws FileNotFoundException
    {
        abr = new Abr();
        raf = new RandomAccessFile(filename, "rw");
    }

    /// METODI
    public void importa()
            throws IOException
    {
        if(raf.length() > 0)
            abr.importa(raf);
        else
            throw new IllegalStateException("File vuoto");
    }

    public void add(char alim, double cil, String marca, String modello,
                    double prezzo, String targa, int yy)
            throws IOException, IllegalArgumentException
    {
        if(abr.search(targa) == -1){
            Macchina car = new Macchina(alim, cil, marca, modello, prezzo, targa, yy);
            raf.seek(raf.length());
            abr.add(car.getTarga(), raf.length());
            car.write(raf);
        }
        else
            throw new KeyAlreadyExistsException("Targa gia' registrata");
    }

    public Macchina search(String targa)
            throws IOException
    {
        long pos = abr.search(targa);
        if(pos == -1)
            throw new NoSuchElementException("Targa non trovata");
        else{
            Macchina car = new Macchina();
            raf.seek(pos);
            car.read(raf);
            return car;
        }
    }
}
