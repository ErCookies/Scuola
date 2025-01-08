/*
    In riferimento all’esercizio precedente, si dovrà creare un negozio di telefonia che gestisca diverse SIM.
    Il negozio dovrà gestire sia le SIM inattive tenute in magazzino, sia le SIM acquistate dai vari clienti.
    Del negozio si conoscono le seguenti informazioni:
        - P.IVA
        - Nome
        - Indirizzo
    In negozio avrà la possibilità di:
        1. Attivare una SIM
        2. Disattivare una SIM
        3. Acquisto SIM da parte del negozio. Le SIM acquistate dal negozio andranno in magazzino.
        4. Ricaricare una SIM: si dovrà chiedere l’operatore, il numero di telefono e l’importo della ricarica
        5. Richiedere la portabilità del numero: si dovrà chiedere l’ICCID della sim, il numero di telefono di
           cui effettuare la portabilità, l’operatore attuale e il nuovo operatore. Nella fase di portabilità
           si dovrà chiedere all’utente se trasferire o meno il credito residuo.
        6. Visualizzare le SIM attive/disattive in negozio in base alla scelta dell’utente.
        7. ....
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Shop {
    private ArrayList<Sim> stor, bought;
    private String pIva, name, address;

    /// GETTER - SETTER
    public String getpIva() {
        return this.pIva;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }

    public void setpIva(String pIva) {
        if(!pIva.isEmpty())
            if(pIva.length() == 11)
                this.pIva = pIva;
            else
                throw new IllegalArgumentException("Partita IVA invalida");
        else
            throw new NoSuchElementException("Stringa vuota");
    }
    public void setName(String name) {
        if(!name.isEmpty())
            this.name = name;
        else
            throw new NoSuchElementException("Stringa vuota");
    }
    public void setAddress(String address) {
        if(!address.isEmpty())
            this.address = address;
        else
            throw new NoSuchElementException("Stringa vuota");
    }

    /// COSTRUTTORI
    public Shop(){
        setpIva("00000000001");
        setName("Sicc & CO.");
        setAddress("Via dei fiori");
        this.stor = new ArrayList<>();
        this.bought = new ArrayList<>();
    }

    public Shop(String pIva, String name, String address){
        setpIva(pIva);
        setName(name);
        setAddress(address);
        this.stor = new ArrayList<>();
        this.bought = new ArrayList<>();
    }

    /// Punto 1 --> Attivare una SIM
    public void attivazione(Sim s, String name){
        int pos;
        if(s != null){
            if(!this.stor.isEmpty()){
                pos = this.stor.indexOf(s);
                if(pos != -1){
                    this.stor.get(pos).setActive(true);
                    this.stor.get(pos).setNomeInst(name);
                    this.bought.add(this.stor.remove(pos));
                }
                else
                    throw new NoSuchElementException("Sim non trovata");
            }
            else
                throw new IllegalStateException("Storage vuoto");
        }
        else
            throw new NullPointerException("Puntatore a NULL non consentito");
    }

    /// Punto 2 --> Disattivare una SIM
    public void disattivazione(Sim s){
        if(s != null){
            if(!this.bought.isEmpty()){
                int pos = this.bought.indexOf(s);
                if(pos != -1){
                    this.bought.get(pos).setActive(false);
                    this.bought.get(pos).setNomeInst("");
                    this.stor.add(this.bought.remove(pos));
                }
                else
                    throw new NoSuchElementException("Sim non trovata");
            }
            else
                throw new IllegalStateException("Nessuna SIM acquistata");
        }
        else
            throw new NullPointerException("Puntatore a NULL non consentito");
    }

    /// Punto 3 --> Rifornimento del negozio
    public void restock(Sim s){
        if(s != null){
            if(!this.existsBought(s) || !this.existsStor(s))
                this.stor.add(s);
            else
                throw new IllegalArgumentException("Sim gia' esistente");
        }
        else
            throw new NullPointerException("Puntatore a NULL non consentito");
    }

    ///Punto 4 --> Ricarica SIM
    public void ricarica(String numTel, String opt, int val) throws IllegalStateException{
        int pos = this.srcNumOpt(numTel, opt);
        if(pos != -1){
            this.bought.get(pos).ricarica(val);
        }
        else
            throw new NoSuchElementException("Sim non trovata");
    }

    /// Punto 5 --> Portabilita' del numero
    public void portabilita(String iccid, String numTel, String newOpt, boolean impCred){
        int pos = srcNumIccid(numTel, iccid);
        if(pos != -1){
            this.bought.get(pos).setOpt(newOpt);
            if(!impCred)
                this.bought.get(pos).setCred(0);
        }
        else
            throw new NoSuchElementException("Sim non trovata");
    }

    /// Punto 6 --> Visualizzazione SIM dis|attive
    public String view(boolean active){
        String st;
        Sim s;
        Iterator<Sim> it;
        if(active)
            it = this.bought.iterator();
        else
            it = this.stor.iterator();
        for(st = ""; it.hasNext(); st += s.toString() + '\n')
            s = it.next();
        return st;
    }

    private int srcNumOpt(String numTel, String opt){
        int pos = -1;
        Iterator<Sim> it = this.bought.iterator();
        for(int k = 0; it.hasNext() && pos == -1; k++){
            Sim s = it.next();
            if(s.getNumTel().equals(numTel) && s.getOpt().equals(opt))
                pos = k;
        }
        return pos;
    }
    private int srcNumIccid(String numTel, String iccid){
        int pos = -1;
        Iterator<Sim> it = this.bought.iterator();
        for(int k = 0; it.hasNext() && pos == -1; k++){
            Sim s = it.next();
            if(s.getNumTel().equals(numTel) && s.getOpt().equals(iccid))
                pos = k;
        }
        return pos;
    }

    private boolean existsStor(Sim e){
        boolean tro = false;
        Iterator<Sim> itS = this.stor.iterator();
        while(itS.hasNext() && !tro){
            Sim s = itS.next();
            if(s.getIccid().equals(e.getIccid()) || s.getNumTel().equals(e.getNumTel()))
                tro = true;
        }
        return tro;
    }
    private boolean existsBought(Sim e){
        boolean tro = false;
        Iterator<Sim> itB = this.bought.iterator();
        while(itB.hasNext() && !tro) {
            Sim s = itB.next();
            if (s.getIccid().equals(e.getIccid()) || s.getNumTel().equals(e.getNumTel()))
                tro = true;
        }
        return tro;
    }

    public boolean isEmpty(){
        return this.stor.isEmpty();
    }
}
