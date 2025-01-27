import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

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

            s = s.concat(k + ") " + f.getClass().toString().replace("class ","") + ": Area = " + f.area() + "\n");
        }

        return s;
    }
    public String elencoPer(){
        String s = "";
        Iterator<Figura> it = this.figs.iterator();
        Figura f;
        for(int k = 1; it.hasNext(); k++){
            f = it.next();

            s = s.concat(k + ") " + f.getClass().toString().replace("class ","") + ": Perimetro = " + f.perimetro() + "\n");
        }
        return s;
    }

    public void importa(String filename){
        try{
            FileReader f;
            BufferedReader fin;
            String s;
            int nS;
            StringTokenizer toks;
            f = new FileReader(filename);
            fin = new BufferedReader(f);
            s = fin.readLine();
            while(s != null){
                toks = new StringTokenizer(s, ";");
                nS = Integer.parseInt(toks.nextToken());
                if(nS == 3)
                    this.figs.add(new Triangolo(Double.parseDouble(toks.nextToken()), Double.parseDouble(toks.nextToken()), Double.parseDouble(toks.nextToken())));
                else
                    this.figs.add(new Quadrilatero(Double.parseDouble(toks.nextToken()), Double.parseDouble(toks.nextToken()), Double.parseDouble(toks.nextToken()), Double.parseDouble(toks.nextToken())));
                s = fin.readLine();
            }
            fin.close();
        }
        catch(FileNotFoundException exc){
            System.out.println("Errore nell'apertura del file");
        }
        catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }

    public void esporta(String filename, boolean app){
        if(!this.figs.isEmpty()){
            try{
                String s;
                PrintWriter fout = new PrintWriter(new FileWriter(filename), app);
                for(Figura f : this.figs)
                    fout.println(f.toCSV());

                fout.close();
            }
            catch(IOException exc){
                System.out.println(exc.getMessage());
            }
        }
        else
            throw new IllegalStateException("Nessuna figura importata");
    }
}
