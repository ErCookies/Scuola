import java.io.*;
import java.util.LinkedList;

public class Pila<E extends FileCSV & Copyable<E>>{
    private LinkedList<E> pila;

    public Pila(){
        pila = new LinkedList<>();
    }
    public boolean isEmpty(){
        return this.pila.isEmpty();
    }
    public int size(){
        return this.pila.size();
    }
    public E pop(){
        if(!this.isEmpty())
            return this.pila.removeLast();
        else
            throw new IllegalStateException("Pila vuota");
    }
    public void push(E obj){
        if(obj != null)
            this.pila.addLast(obj);
        else
            throw new NullPointerException("Puntatore a NULL non consentito");
    }

    public void esporta(String filename, boolean app) throws IOException {
        if(!filename.isEmpty()){
            PrintWriter fout = new PrintWriter(new FileWriter(filename), app);
            for(E obj : this.pila)
                fout.println(obj.toCSV());

            fout.close();
        }
        else
            throw new IllegalArgumentException("Nome non valido");
    }
    public void importa(String filename, E aus) throws IOException {
        if(!filename.isEmpty()){
            BufferedReader fin = new BufferedReader(new FileReader(filename));      //FileNotFoundException
            String s = fin.readLine();      //IOException
            while(s != null){
                E obj = aus.copy();
                obj.fromCSV(s);
                push(obj);
                s = fin.readLine();
            }
        }
        else
            throw new IllegalArgumentException("Nome non valido");
    }
}
