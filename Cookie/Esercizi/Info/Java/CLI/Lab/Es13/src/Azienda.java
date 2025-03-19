public class Azienda {
    private String nome, responsabile, indirizzo, mail, web;
    private MyList<Dipendente> list;

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
    public Azienda(String nome, String responsabile, String indirizzo, String mail, String web){
        this.setNome(nome);
        this.setResponsabile(responsabile);
        this.setIndirizzo(indirizzo);
        this.setMail(mail);
        this.setWeb(web);
        this.list = new MyList<>();
    }
}
