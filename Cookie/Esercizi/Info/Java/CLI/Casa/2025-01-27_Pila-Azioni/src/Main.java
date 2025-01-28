import java.io.FileNotFoundException;
import java.io.IOException;
/*
    Cucchi Francesco
    Creare la classe Pila su tipo generico vincolato (metodi: costruttori, size, pop, push, importa ed esporta)
    la classe PacchettoAzionario (metodi: costruttori, set/get) che implementi interfaccia FileCsv.
    ---
    Realizzare il programma che permetta di effettuare acquisti e vendite di pacchetti azionari.
    Il programma gestirà in modalità LIFO gli acquisti e calcolerà PluValenza e MinusValenza per ogni vendita.
    La pila dei pacchetti azionari acquistati (per uno stesso titolo) viene salvata alla fine del programma
    un file csv e viene ripristinata in ram all'inizio del programma a partire dal file csv.
*/
public class Main {
    public static void main(String[] args) {
        int sc;
        boolean val = false;
        Pila<PacchettoAzionario> azioni = new Pila<>();
        try{
            azioni.importa(Input.lgStr("Inserire nome file: "), new PacchettoAzionario());
            val = true;
        }
        catch(FileNotFoundException e){
            System.out.println("File inesistente");
            azioni.setNome(Input.lgStr("Inserire nome nuova azione: "));
            val = true;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if(val){
            do{
                menu();
                sc = Input.lgInt(0,3, "Inserire funzione interessata: ");
                switch (sc){
                    case 1:{
                        acquisto(azioni);
                        break;
                    }
                    case 2:{
                        vendita(azioni);
                        break;
                    }
                    case 3:{
                        stampa(azioni);
                        break;
                    }
                    case 0:{
                        try {
                            azioni.esporta(false);
                        }
                        catch (IOException e) {
                            System.out.println("Impossibile procedere con l'esportazione");
                            sc = -1;
                        }
                        break;
                    }
                }
            }while(sc != 0);

            out(azioni);
        }
    }

    public static void acquisto(Pila<PacchettoAzionario> azioni) {
        int num;
        double value;
        boolean val = false;
        while (!val){
            try {
                num = Input.lgInt(0, Integer.MAX_VALUE, "Inserire numero azioni da acquistare: ");
                value = Input.lgDbl(0, Double.MAX_VALUE, "Inserire valore singole azioni: ");
                azioni.push(new PacchettoAzionario(num, value));
                val = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void vendita(Pila<PacchettoAzionario> azioni){
        int numToS = Input.lgInt(0, Integer.MAX_VALUE, "Inserire numero azioni da vendere: ");
        double sValue = Input.lgDbl(0, Double.MAX_VALUE, "Inserire valore di vendita: ");
        int numSold;    //azioni vendute
        PacchettoAzionario pack;
        while(numToS > 0){
            try{
                pack = azioni.pop();
                if(numToS <= pack.getNum()){
                    numSold = numToS;
                    numToS = 0;
                    pack.setNum(pack.getNum() - numSold);
                    if(pack.getNum() > 0)
                        azioni.push(pack);
                }
                else{
                    numSold = pack.getNum();
                    numToS -= numSold;
                }
                System.out.println("Valenza pacchetto in data " + pack.getDataF() + ": " + ((sValue - pack.getValue()) * numSold));
                System.out.println("Azioni vendute: " + numSold);
                //
            }
            catch(IllegalStateException e){
                System.out.println(e.getMessage() + ", impossibile continuare con la vendita");
                numToS = 0;
            }
        }
    }
    public static void stampa(Pila<PacchettoAzionario> azioni){
        System.out.println("\nNumero;ValoreAcquisto;Data;");
        System.out.println(azioni.toString());
    }

    public static void menu(){
        System.out.println("1) Acquisto azione;");
        System.out.println("2) Vendita azione;");
        System.out.println("3) Stampa azioni attuali;");
        System.out.println("0) Esportazione + Terminazione programma.");
    }

    public static void out(Pila<PacchettoAzionario> p){
        System.out.println(p.getNome() + ":");
        while(!p.isEmpty())
            System.out.println(p.pop().toCSV());
    }
}