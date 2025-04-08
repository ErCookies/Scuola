/*
    CUCCHI FRANCESCO    4BI

    TESTO:
    Realizzare applicazione che permetta di inserire e ricercare un prodotto venduto per la
    modifica del prezzo per il magazzino da una grande azienda di distribuzione.
    Nell'inserimento si deve controllare che il codice sia univoco, mentre la ricerca avviene
    tramite conoscenza del codice. Produrre grafo UML e codice java delle classi interessate.
    Si dovrà produrre la classe Gestore che permette di memorizzare/ ricercare un prodotto
    tramite uso di un indice gestito da ABR (la cui classe già avete creato in precedenti esercizi)
    ed un file binario ad accesso random. L'ABR dovrà essere considerato come indice di accesso al
    file random in cui dovrà essere memorizzato codice prodotto e indirizzo del record nel file binario.
    L’indice dovrà essere salvato su disco al termine del programma e ricaricato in ram all’inizio del programma.
*/
import java.io.*;
import java.util.NoSuchElementException;

public class Gestore {
    private ABR abr;
    private RandomAccessFile raf;

    public Gestore()
            throws IOException
    {
        try {
            raf = new RandomAccessFile("prod.dat", "rw");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abr.dat"));
            abr = (ABR) ois.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            // Nel caso vi siano problemi nell'importazione dell'albero,
            // lo inizializzo a partire dal RAF, nel caso contenga dei dati
            if(raf.length() > 0)
                loadABR();
            else
                abr = new ABR();
        }
    }

    private void loadABR()
            throws IOException
    {
        abr = new ABR();
        Prodotto p = new Prodotto();
        raf.seek(0);
        while(raf.getFilePointer() < raf.length()){
            long posPreRead = raf.getFilePointer();
            p.read(raf);
            abr.add(p.getCod(), posPreRead);
        }
    }

    public void add(int cod, String name, double prz)
            throws IllegalArgumentException, IOException
    {
        Prodotto p = new Prodotto(cod, name, prz);
        raf.seek(raf.length());
        abr.add(cod, raf.getFilePointer());
        p.write(raf);
    }

    public Prodotto search(int cod)
            throws NoSuchElementException, IOException
    {
        long pos = abr.search(cod);
        if(pos == -1)
            throw new NoSuchElementException("Prodotto non trovato");
        else {
            Prodotto p = new Prodotto();
            raf.seek(pos);
            p.read(raf);
            return p;
        }
    }

    public void close()
            throws IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abr.dat", false));
        oos.writeObject(abr);
        oos.close();
        raf.close();
    }
}
