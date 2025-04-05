import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/// Classe Controller del programma
public class Gestore implements Closeable {
    private Hashtable<String, Long> table;
    private final RandomAccessFile raf;

    /// Costruttore default
    /// @throws IOException Errore durante le operazioni di IO
    public Gestore()
            throws IOException
    {
        this.raf = new RandomAccessFile("car.dat", "rw");
        try {
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("table.dat"));
            this.table = (Hashtable<String, Long>) fin.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            this.table = new Hashtable<>();
            this.initTable();
        }
    }

    private void initTable()
            throws IOException
    {
        this.raf.seek(0);
        long posPreRead;
        for(int k = 0; this.raf.getFilePointer() < this.raf.length(); k++){
            posPreRead = this.raf.getFilePointer();
            table.put(Input.readString(this.raf, Macchina.LENSTR), posPreRead);
            this.raf.seek((long)(k+1)*Macchina.LENREC);
        }
    }

    /// Salva i dati su file e chiude quelli aperti
    @Override
    public void close()
    {
        try{
            ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("table.dat", false));
            fout.writeObject(this.table);
            fout.close();
            raf.close();
        }
        catch(IOException e){
            // handling
        }
    }

    /// Metodo di aggiunta di una macchina
    /// @param alim a
    /// @param cil a
    /// @param marca a
    /// @param modello a
    /// @param prezzo a
    /// @param targa a
    /// @param yy a
    /// @throws IOException Errore durante le operazioni di IO
    /// @throws IllegalArgumentException /
    /// @throws KeyAlreadyExistsException /
    public void add(char alim, double cil, String marca, String modello,
                    double prezzo, String targa, int yy)
            throws IOException, IllegalArgumentException
    {
        if(!this.table.containsKey(targa)){
            Macchina car = new Macchina(alim, cil, marca, modello, prezzo, targa, yy);
            raf.seek(raf.length());
            long posPreWrite = raf.getFilePointer();
            car.write(raf);
            this.table.put(targa, posPreWrite);
        }
        else
            throw new KeyAlreadyExistsException("Targa gia' registrata");
    }

    /// Metodo di ricerca di una macchina data la targa
    /// @param targa /
    /// @throws IOException Errore durante le operazioni di IO
    /// @throws IllegalStateException /
    /// @throws NoSuchElementException /
    /// @return /
    public Macchina search(String targa)
            throws IOException
    {
        if(this.raf.length() == 0)
            throw new IllegalStateException("File vuoto");
        else{
            Long pos = this.table.get(targa);
            if(pos == null)
                throw new NoSuchElementException("Targa non trovata");
            else{
                Macchina car = new Macchina();
                raf.seek(pos);
                car.read(raf);
                return car;
            }
        }
    }

    /// Metodo che ritorna una stringa contenente ogni macchina senza ordinamento
    /// @throws IOException Errore durante le operazioni di IO
    /// @return /
    public String printAll()
            throws IOException
    {
        StringBuilder s = new StringBuilder();
        Iterator<Long> it = this.table.elements().asIterator();
        Macchina car = new Macchina();

        while(it.hasNext()){
            raf.seek(it.next());
            car.read(raf);
            s.append(car);
            s.append('\n');
        }

        return s.toString();
    }

    /// Metodo che ritorna una stringa contenente ogni macchina ORDINATE per targa
    /// @throws IOException Errore durante le operazioni di IO
    /// @return /
    public String printSort()
            throws IOException
    {
        StringBuilder s = new StringBuilder();
        String[] keys = tableKeysToSortedArray();
        long pos;
        Macchina car = new Macchina();
        for(String key: keys){
            pos = table.get(key);
            raf.seek(pos);
            car.read(raf);
            s.append(car);
            s.append('\n');
        }

        return s.toString();
    }

    private String[] tableKeysToSortedArray()
    {
        String[] arr = new String[table.size()];
        this.table.keySet().toArray(arr);
        Arrays.sort(this.table.keySet().toArray(arr));
        return arr;
    }
}
