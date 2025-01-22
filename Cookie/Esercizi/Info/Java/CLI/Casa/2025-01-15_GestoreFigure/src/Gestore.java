import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Gestore{
    private final LinkedList<Figura> figs;

    public Gestore(){
        this.figs = new LinkedList<>();
    }

    public void add(Figura f){
        if(f != null)
            this.figs.add(f);
        else
            throw new NullPointerException("Puntatore a NULL non valido");
    }

    public String toString(){
        String s = "";
        Iterator<Figura> it = this.figs.iterator();
        Figura f;
        for(int k = 1; it.hasNext(); k++){
            f = it.next();
            s = s.concat(k + ") " + f.toString() + "\n");
        }
        return s;
    }

    public String elencoAree(){
        String s = "";
        Iterator<Figura> it = this.figs.iterator();
        Figura f;
        for(int k = 1; it.hasNext(); k++){
            f = it.next();

            s = s.concat(k + ") " + f.getClass() + ": Area = " + f.area() + "\n");
        }

        return s;
    }

    public void importa(String filename){
        try{
            FileReader f;
            BufferedReader fin;
            String s;
            f = new FileReader(filename);
            //
            f.close();
        }
        catch(FileNotFoundException exc){
            System.out.println("Errore nell'apertura del file");
        }
        catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }

    public void esporta(String filename){
        if(!this.figs.isEmpty()){
            try{
                String s;
                PrintWriter fout = new PrintWriter(new FileWriter(filename));
            }
            catch(Exception exc){
                System.out.println(exc.getMessage());
            }
        }
        else
            throw new IllegalStateException("Nessuna figura importata");
    }
}
