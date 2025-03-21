/*
    Modificare esercizio di gestione di un RAF con oggetti di tipo AUTO considerando di
    aggiungere un ABR che contenga la targa (chiave primaria) e l'indirizzo del record su raf.
    Prevedere la realizzazione delle seguenti funzionalità:
        a) importazione dell'ABR a partire da RAF (da realizzare ad inizio programma)
        b) inserimento di un nuovo record con controllo unicità della chiave
        c) ricerca di una targa e sua visualizzazione con accesso random al raf
    Postare codice su OneNOte
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        Gestore ges;
        int sc;

        try{
            ges = new Gestore();
            do{
                menu();
                sc = Input.lgInt(0, 3, "Inserire funzione interessata: ");

                switch (sc){
                    case 1: {
                        try{
                            add(ges);
                        }
                        // KeyAlreadyExistsException e' inclusa nel seguente catch,
                        // dato che e' una sottoclasse de IllegalArgumentException
                        catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        catch (IOException e) {
                            System.out.println("Errore nella scrittura su file");
                        }
                        break;
                    }
                    case 2: {
                        try{
                            System.out.println(ges.search(Input.lgStr("Inserire targa: ")).toString());
                        }
                        catch(NoSuchElementException | IllegalStateException e){
                            System.out.println(e.getMessage());
                        }
                        catch (IOException e) {
                            System.out.println("Errore nella lettura da file");
                        }
                        break;
                    }
                    case 3:{
                        ges.stampaTable();
                        break;
                    }
                    case 0:{break;}
                }
            }while(sc != 0);
            ges.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File da cui importare non trovato");
        }
        catch (IOException e) {
            System.out.println("Errore nell'importazione");
        }
    }

    public static void add(Gestore ges)
            throws IOException, IllegalArgumentException
    {
        char alim = Input.lgChar("Inserire alimentazione: ");
        double cil = Input.lgDbl(0, Double.MAX_VALUE, "Inserire cilindrata: ");
        String marca = Input.lgStr("Inserire marca: ");
        String modello = Input.lgStr("Inserire modello: ");
        double prezzo = Input.lgDbl(1, Double.MAX_VALUE, "Inserire prezzo: ");
        String targa = Input.lgStr("Inserire targa: ");
        int yy = Input.lgInt(0, Integer.MAX_VALUE, "Inserire anno: ");
        ges.add(alim, cil, marca, modello, prezzo, targa, yy);
    }

    public static void menu()
    {
        System.out.println("1) Inserire una nuova auto;");
        System.out.println("2) Stampa auto data targa;");
        System.out.println("3) **TEST** Stampa table;");
        System.out.println("0) Termina il programma;");
    }
}