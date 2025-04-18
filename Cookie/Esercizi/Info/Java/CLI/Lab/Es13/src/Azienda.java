import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Azienda {
    private String nome, responsabile, indirizzo, mail, web;
    private final MyList<Dipendente> list;

    /// GETTER - SETTER
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        if(nome == null)
            throw new NullPointerException("Fornire un oggetto istanziato");
        else{
            if(nome.isEmpty())
                throw new IllegalArgumentException("Stringa vuota");
            else
                this.nome = nome;
        }
    }

    public String getResponsabile(){
        return this.responsabile;
    }
    public void setResponsabile(String responsabile) {
        if(responsabile == null)
            throw new NullPointerException("Fornire un oggetto istanziato");
        else{
            if(responsabile.isEmpty())
                throw new IllegalArgumentException("Stringa vuota");
            else
                this.responsabile = responsabile;
        }
    }

    public String getIndirizzo(){
        return this.indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        if(indirizzo == null)
            throw new NullPointerException("Fornire un oggetto istanziato");
        else{
            if(indirizzo.isEmpty())
                throw new IllegalArgumentException("Stringa vuota");
            else
                this.indirizzo = indirizzo;
        }
    }

    public String getMail(){
        return this.mail;
    }
    public void setMail(String mail) {
        if(mail == null)
            throw new NullPointerException("Fornire un oggetto istanziato");
        else{
            if(mail.isEmpty())
                throw new IllegalArgumentException("Stringa vuota");
            else
                this.mail = mail;
        }
    }

    public String getWeb(){
        return this.web;
    }
    public void setWeb(String web) {
        if(web == null)
            throw new NullPointerException("Fornire un oggetto istanziato");
        else{
            if(web.isEmpty())
                throw new IllegalArgumentException("Stringa vuota");
            else
                this.web = web;
        }
    }

    /// COSTRUTTORE
    public Azienda(String nome, String responsabile,
                   String indirizzo, String mail, String web)
            throws IllegalArgumentException, NullPointerException
    {
        this.setNome(nome);
        this.setResponsabile(responsabile);
        this.setIndirizzo(indirizzo);
        this.setMail(mail);
        this.setWeb(web);
        this.list = new MyList<>();
    }

    /// METODI
    public void add(Dipendente d)
    {
        if(d != null)
            list.add(d);
        else
            throw new NullPointerException("Null pointer non valido");
    }

    public String printAll()
    {
        StringBuilder s = new StringBuilder();
        for(int k = 0; k < list.size(); k++){
            Dipendente d = list.get(k);
            s.append(d.stampaDati());
            s.append('\n');
        }
        return s.toString();
    }

    public String printStipLess()
    {
        StringBuilder s = new StringBuilder();
        for(int k = 0; k < list.size(); k++){
            Dipendente d = list.get(k);
            if(d.calcolaPaga() <= 1350){
                s.append(d.stampaDati());
                s.append('\n');
            }
        }
        if(s.isEmpty())
            throw new NoSuchElementException("Nessun elemento trovato");
        return s.toString();
    }

    public void licenzia(int mat)
    {
        boolean tro = false;
        for(int k = 0; k < list.size() && !tro; k++){
            Dipendente d = list.get(k);
            if(d.getMatricola() == mat){
                tro = true;
                list.remove(k);
            }
        }
    }

    public double totStip()
    {
        double tot = 0;
        for(int k = 0; k < list.size(); k++){
            Dipendente d = list.get(k);
            tot += d.calcolaPaga();
        }
        return tot;
    }

    public void expOrd(String filename, char t)
            throws IOException
    {
        Dipendente d;
        PrintWriter fout;
        StringBuilder s = new StringBuilder();

        //     val  = boolCond |   ramo true   |  ramo false
        String type = (t == 'i' ? "Impiegato" : "Operaio");

        for(int k = 0; k < list.size(); k++){
            d = list.get(k);
            if(d.getClass().toString().contains(type)){
                s.append(d.toCSV());
                s.append('\n');
            }
        }
        if(!s.isEmpty()){
            fout = new PrintWriter(new FileWriter(filename));
            fout.print(s);
            fout.close();
        }
        else
            throw new NoSuchElementException("Nessun dipendente di tale tipo trovato");
    }

}
