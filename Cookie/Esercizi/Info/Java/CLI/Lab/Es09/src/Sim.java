/*
    Realizzare un’applicazione in grado di gestire la vostra scheda SIM.
    La SIM è caratterizzata da:
        Nome intestatario
        ICCID
        Numero di telefono
        Credito residuo
        Minuti di chiamate effettuate sulla SIM
        SIM attiva(boolean)
    Realizzare i seguenti metodi:
        Costruttori (ogni SIM creata deve essere disattiva)
        Getters e Setters
        Metodo toString
        Metodo compareTo
        Metodo che riceve un valore in euro ed effettua la ricarica della SIM.
        Metodo che, dato un tempo in minuti, permetta di effettuare una chiamata.
            (La TARIFFA per le chiamate è pari a 0,32€/minuti – nel caso in cui il credito non sia sufficiente?)
        Metodo DISATTIVA SIM con cui si potrà disattivare la SIM
        Metodo che converte i minuti di chiamate nel formato: hh:mm

    Realizzare un main di prova contenente il seguente menu:
        Attiva SIM
        Stampa dati SIM
        Ricarica SIM (tagli ricarica: 5€, 10€, 20€)
        Effettua telefonata
        Visulizza hh:mm totale di chiamate
        Disattiva SIM
*/
public class Sim implements Comparable<Sim>{
    private String nomeInst, iccid, numTel, opt;
    private double cred, minuti;
    private boolean active;
    private final double TARIFFA = 0.32;

    public String getNomeInst() {
        return this.nomeInst;
    }
    public String getIccid() {
        return this.iccid;
    }
    public String getNumTel() {
        return this.numTel;
    }
    public double getCred() {
        return this.cred;
    }
    public double getMinuti() {
        return this.minuti;
    }
    public boolean isActive() {
        return this.active;
    }
    public String getOpt() {
        return opt;
    }
    public void setNomeInst(String nomeInst) {
        if(!nomeInst.isEmpty())
            this.nomeInst = nomeInst;
        else
            throw new IllegalArgumentException("Nome invalido");
    }
    public void setIccid(String iccid) {
        if(iccid.length() == 19 || iccid.length() == 20)
           this.iccid = iccid;
        else
            throw new IllegalArgumentException("ICCID invalido");
    }
    public void setNumTel(String numTel) {
        if(numTel.length() == 10)
            this.numTel = numTel;
        else
            throw new IllegalArgumentException("Numero invalido");
    }
    public void setCred(double cred) {
        if(cred >= 0)
            this.cred = cred;
        else
            throw new IllegalArgumentException("Credito invalido");
    }
    public void setMinuti(double minuti) {
        if(minuti >= 0)
            this.minuti = minuti;
        else
            throw new IllegalArgumentException("Minutaggio invalido");
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setOpt(String opt) {
        if(!opt.isEmpty())
            this.opt = opt;
        else
            throw new IllegalArgumentException("Operatore invalido");
    }
    public Sim(){
        this.setActive(false);
        this.setNomeInst("Mario Rossi");
        this.setIccid("aa11aa11aa11aa11aa11");
        this.setNumTel("3792654036");
        this.setOpt("TIM");
        this.setCred(0);
        this.setMinuti(0);
    }
    public Sim(String nomeInst, String iccid, String numTel, String opt){
        this.setActive(false);
        this.setNomeInst(nomeInst);
        this.setIccid(iccid);
        this.setNumTel(numTel);
        this.setOpt(opt);
        this.setCred(0);
        this.setMinuti(0);
    }
    public Sim(Sim sim){
        this.setActive(false);
        this.setNomeInst(sim.getNomeInst());
        this.setIccid(sim.getIccid());
        this.setNumTel(sim.getNumTel());
        this.setOpt(sim.getOpt());
        this.setCred(sim.getCred());
        this.setMinuti(sim.getMinuti());
    }

    @Override
    public String toString(){
        String s = "";
        s = s.concat(this.getNomeInst() + ";");
        s = s.concat(this.getIccid() + ";");
        s = s.concat(this.getNumTel() + ";");
        s = s.concat(this.getCred() + ";");
        s = s.concat(this.convertMinToHhMm() + ";");
        s = s.concat(this.isActive() + ";\n");
        return s;
    }

    public void ricarica(double val){
        if(this.isActive())
            this.setCred(this.getCred() - val);
        else
            throw new IllegalStateException("SIM inattiva");
    }

    public void chiamata(double min){
        if(this.isActive()){
            this.setCred(this.getCred() - (min*this.TARIFFA));
            this.setMinuti(getMinuti() + min);
        }
        else
            throw new IllegalStateException("SIM inattiva");
    }

    public void attivazione(boolean state){
        if(this.isActive() != state)
            this.setActive(state);
        else if(state)
            throw new IllegalArgumentException("Sim gia' attiva");
        else
            throw new IllegalArgumentException("Sim gia' disattivata");
    }

    public String convertMinToHhMm(){
        String s;
        int hh;
        double min = this.getMinuti();
        hh = (int) min / 60;
        min = min % 60;
        s = hh + ":" + min;
        return s;
    }

    public int compareTo(Sim sim) {
        int x;
        if(this.getIccid().equals(sim.getIccid()))
            x = 0;
        else if(this.getIccid().compareTo(sim.getIccid()) > 0)
            x = 1;
        else
            x = -1;

        return x;
    }
}
