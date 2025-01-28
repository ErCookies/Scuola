import java.io.*;
import java.util.LinkedList;

public class Pila<E extends FileCSV & Copyable<E>>{
    private final LinkedList<E> pila;
    private String nome;

    /// GETTER - SETTER
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome != null)
            if(!nome.isEmpty())
                this.nome = nome;
            else
                throw new IllegalArgumentException("Stringa vuota");
        else
            throw new NullPointerException("null pointer non valido");
    }

    /// COSTRUTTORI
    public Pila(){
        pila = new LinkedList<>();
        setNome("default");
    }
    public Pila(String nome) throws IllegalArgumentException, NullPointerException{
        pila = new LinkedList<>();
        setNome(nome);
    }

    /// METODI SU PILA
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

    /*@Override
    public String toString() {
        String s = "";
        for(E obj : this.pila)
            s = s.concat(obj.toCSV() + "\n");
        return s;
    }*/


    /// METODI SU FILE
    public void esporta(String filename, boolean app) throws IOException {
        if(!filename.isEmpty()){
            PrintWriter fout = new PrintWriter(new FileWriter(filename), app);
            fout.println(getNome());
            for(E obj : this.pila)
                fout.println(obj.toCSV());

            fout.close();
        }
        else
            throw new IllegalArgumentException("Nome non valido");
    }
    public void esporta(boolean app) throws IOException {
        PrintWriter fout = new PrintWriter(new FileWriter(getNome() + ".csv"), app);
        fout.println(getNome());
        for(E obj : this.pila)
                fout.println(obj.toCSV());
        fout.close();
    }
    public void importa(String filename, E aus) throws IOException {
        if(aus != null){
            if(!filename.isEmpty()){
                BufferedReader fin = new BufferedReader(new FileReader(filename));      //FileNotFoundException
                this.setNome(fin.readLine());
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
        else
            throw new NullPointerException("Passare oggetto istanziato");
    }
}
