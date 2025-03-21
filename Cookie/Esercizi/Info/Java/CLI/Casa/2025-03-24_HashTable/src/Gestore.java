import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.*;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class Gestore implements Closeable {
    private Hashtable<String, Long> table;
    private final RandomAccessFile raf;

    /// COSTRUTTORE
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

    private void initTable() throws IOException{
        this.raf.seek(0);
        long posPreRead;
        for(int k = 0; this.raf.getFilePointer() < this.raf.length(); k++){
            posPreRead = this.raf.getFilePointer();
            table.put(Input.readString(this.raf, Macchina.LENSTR), posPreRead);
            this.raf.seek((long)(k+1)*Macchina.LENREC);
        }
    }

    /// CLOSE
    @Override
    public void close(){
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

    /// METODI

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

    public void stampaTable(){
        System.out.println(table);
    }
}
