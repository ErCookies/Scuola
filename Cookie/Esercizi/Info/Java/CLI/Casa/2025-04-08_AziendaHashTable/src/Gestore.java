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
import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.*;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class Gestore {
    private Hashtable<Integer, Long> table;
    private RandomAccessFile raf;

    @SuppressWarnings("unchecked")
    public Gestore()
            throws IOException
    {
        try {
            raf = new RandomAccessFile("prod.dat", "rw");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abr.dat"));
            table = (Hashtable<Integer, Long>) ois.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            // Nel caso vi siano problemi nell'importazione dell'albero,
            // lo inizializzo a partire dal RAF, nel caso contenga dei dati
            if(raf.length() > 0)
                loadTable();
            else
                table = new Hashtable<>();
        }
    }

    private void loadTable()
            throws IOException
    {
        table = new Hashtable<>();
        Prodotto p = new Prodotto();
        raf.seek(0);
        while(raf.getFilePointer() < raf.length()){
            long posPreRead = raf.getFilePointer();
            p.read(raf);
            table.put(p.getCod(), posPreRead);
        }
    }

    public void add(int cod, String name, double prz)
            throws IllegalArgumentException, IOException
    {
        if(table.containsKey(cod))
            throw new KeyAlreadyExistsException("Chiave già esistente");
        else{
            Prodotto p = new Prodotto(cod, name, prz);
            raf.seek(raf.length());
            table.put(cod, raf.getFilePointer());
            p.write(raf);
        }
    }

    public Prodotto search(int cod)
            throws NoSuchElementException, IOException
    {
        Long pos = table.get(cod);
        if(pos == null)
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
        oos.writeObject(table);
        oos.close();
        raf.close();
    }
}
