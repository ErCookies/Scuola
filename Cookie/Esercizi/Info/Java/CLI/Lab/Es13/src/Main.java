/*
    Cucchi Francesco    4BI
    TESTO:
    Un’azienda è caratterizzata da un nome, un responsabile, un indirizzo, una e-mail ed un sito web.
    In tale azienda lavorano dipendenti di tipo diverso: Impiegati e Operai.
    Tutti i dipendenti sono caratterizzati da:
        - Matricola (Intero / UNIVOCO)
        - Nome
        - Cognome
        - Data di nascita
    Gli impiegati sono caratterizzati da un salario mensile e dal numero di ore di permesso
    (per ogni ora di permesso vengono decurtati 20€ dallo stipendio).
    Gli operai, invece, sono caratterizzati da una paga oraria, un numero di ore di straordinario
    e un numero di ore di permesso (si consideri che, di norma, un mese è formato da 160 ore lavorative
    e le ore di straordinario hanno una paga orario incrementata del 30% rispetta a quella ordinaria).
    Tutti gli elementi della gerarchia devono avere metodi comuni come stampaDati e calcolaPaga.
    Realizzare un programma che gestisca i dipendenti di un’azienda.
    Tale menù sarà costituito dai seguenti punti:
        1. Inserimento di un nuovo dipendente
        2. Stampa dell’elenco dei dipendenti dell’azienda
            - per gli operai stampare “matricola + nome + cognome + oreLavorate”;
            - per gli impiegati stampare “matricola + nome + cognome + pagaMensile”;
        3. Stampa di tutti di dipendenti aventi uno stipendio mensile inferiore a 1350€
        4. Licenziamento di un dipendete, data la matricola
        5. Stampa del totale stipendi che l’azienda dovrà versare ai dipendenti
        6. Esportazione su file csv di tutti i dipendenti di un tipo indicato ordinati per cognome (Operaio/Impiegato)

    Dovrà esistere la classe Gestore che gestisce l’insieme dei dipendenti (l’insieme è gestita come lista non sequenziale
    gestita dalla classe MyList<T> vista a lezione) che avrà tutti i metodi necessari alle funzionalità del main.
    La classe T dovrà usare l’interfaccia Comparable e FileCsv.
    L’interazione con l’utente avverrà tramite interfaccia grafica e le diverse voci del menù saranno
    rappresentate da bottoni presenti alla prima finestra visibile all’apertura del programma.
    Realizzare il mockup dell’applicazione per individuare gli oggetti grafici necessari ad ogni singola finestra del programma.
    Descrivere, inoltre, la struttura del file csv.
*/

public class Main {
    public static void main(String[] args) {
        int sc;
        Azienda azienda = initAzienda();

        do{
            menu();
            sc = Input.lgInt(0, 6, "Inserire funzione interessata: ");

            switch(sc){
                case 1:{
                    addDip(azienda);
                    break;
                }
                case 2:{
                    System.out.println(azienda.printAll());
                    break;
                }
                case 3:{
                    System.out.println(azienda.printStipLess());
                    break;
                }
                case 4:{
                    azienda.licenzia(Input.lgInt(0, Integer.MAX_VALUE, "Inserire matricola: "));
                    break;
                }
                case 5:{
                    System.out.println("Totale stipendi da versare: " + azienda.totStip());
                    break;
                }
                case 6:{
                    azienda.expOrd(Input.lgStr("Inserire nome file: "));
                    break;
                }
                case 0:{break;}
            }
        }while(sc != 0);
    }

    public static Azienda initAzienda()
    {
        String nome, resp, ind, mail, web;
        boolean val = false;
        Azienda a = null;
        do{
            try{
                nome = Input.lgStr("Inserire il nome: ");
                resp = Input.lgStr("Inserire il responsabile: ");
                ind = Input.lgStr("Inserire la via: ");
                mail = Input.lgStr("Inserire l'indirizzo e-mail: ");
                web = Input.lgStr("Inserire l'indirizzo web: ");
                a = new Azienda(nome, resp, ind, mail, web);
                val = true;
            }
            catch(NullPointerException | IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Reinserire i dati");
            }
        }while(!val);

        return a;
    }

    public static void addDip(Azienda az)
    {
        boolean val = false;
        char type;
        int mat, hhPerm;
        String name, sur;
        Dipendente d = null;
        do{
            try{
                type = Input.lgChar("Inserire tipo dipendente (i/o): ");
                while(type != 'i' && type != 'o'){
                    System.out.println("Errore");
                    type = Input.lgChar("Inserire tipo dipendente (i/o): ");
                }
                // ins dati dip generico
                mat = Input.lgInt(0, Integer.MAX_VALUE, "Inserire matricola: ");
                name = Input.lgStr("Inserire nome: ");
                sur = Input.lgStr("Inserire cognome: ");
                hhPerm = Input.lgInt(0, Integer.MAX_VALUE, "Inserire ore di permesso: ");

                if(type == 'i'){
                    // impiegato
                    double salMen = Input.lgDbl(0, Double.MAX_VALUE, "Inserire salario mensile: ");
                }
                else{
                    // operaio (pagaHH, hhXtra)
                }
                az.add(d);
                val = true;
            }
            catch(NullPointerException | IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Reinserire i dati");
            }
        }while(!val);
    }

    public static void menu()
    {
        System.out.println("1) Inserimento di un nuovo dipendente;");
        System.out.println("2) Stampa dell’elenco dei dipendenti dell’azienda;");
        System.out.println("3) Stampa dipendenti con stipendio mensile < 1350€;");
        System.out.println("4) Licenziamento di un dipendente, data la matricola;");
        System.out.println("5) Stampa totale stipendi da versare;");
        System.out.println("6) Esportazione su file CSV di tutti i dipendenti di un tipo indicato ordinati per cognome;");
        System.out.println("0) Termina il programma;");
    }
}