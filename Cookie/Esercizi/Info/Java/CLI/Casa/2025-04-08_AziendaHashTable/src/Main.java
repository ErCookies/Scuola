/*
    CUCCHI FRANCESCO    4BI

    TESTO:
    Realizzare applicazione che permetta di inserire e ricercare un prodotto venduto per la
    modifica del prezzo per il magazzino da una grande azienda di distribuzione.
    Nell'inserimento si deve controllare che il codice sia univoco, mentre la ricerca avviene
    tramite conoscenza del codice. Produrre grafo UML e codice java delle classi interessate.
    Si dovrà produrre la classe Gestore che permette di memorizzare/ ricercare un prodotto
    tramite uso di un indice gestito da ABR (la cui classe già avete creato in precedenti esercizi)
    ed un file binario ad accesso random. L'ABR dovrà essere considerato come indice di accesso al
    file random in cui dovrà essere memorizzato codice prodotto e indirizzo del record nel file binario.
    L’indice dovrà essere salvato su disco al termine del programma e ricaricato in ram all’inizio del programma.
*/

import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        int sc;
        try{
            Gestore ges = new Gestore();
            do{
                menu();
                sc = Input.lgInt(0, 2, "Selezionare una funzione: ");
                switch (sc){
                    case 1:{
                        try{
                            ges.add(
                                    Input.lgInt(0, Integer.MAX_VALUE, "Inserire codice prodotto: "),
                                    Input.lgStr("Inserire il nome del prodotto: "),
                                    Input.lgDbl(0, Double.MAX_VALUE, "Inserire il prezzo del prodotto: ")
                            );
                        }
                        catch (KeyAlreadyExistsException e){
                            System.out.println("Chiave già esistente");
                        }
                        catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                        catch (IOException e){
                            System.out.println("Errore lettura file");
                        }
                        break;
                    }
                    case 2:{
                        try{
                            Prodotto p = ges.search(
                                    Input.lgInt(0, Integer.MAX_VALUE, "Inserire il codice del prodotto: ")
                            );
                            System.out.println(p);
                        }
                        catch (NoSuchElementException e){
                            System.out.println("Prodotto non trovato");
                        }
                        catch (IllegalStateException e){
                            System.out.println("Nessun elemento inserito");
                        }
                        catch (IOException e){
                            System.out.println("Errore lettura file");
                        }
                        break;
                    }
                    case 0:{
                        try{
                            ges.close();
                        }
                        catch (IOException e){
                            System.out.println("Errore salvataggio file");
                        }
                        break;
                    }
                }
            }while(sc != 0);
        }
        catch (IOException e) {
            System.out.println("Errore apertura file");
        }
    }

    public static void menu(){
        System.out.println("1) Inserimento prodotto;");
        System.out.println("2) Ricerca prodotto dato il codice;");
        System.out.println("0) Termina il programma;");
    }
}