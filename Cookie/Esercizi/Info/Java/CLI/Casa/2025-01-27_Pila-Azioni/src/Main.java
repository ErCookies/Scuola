/*
    Cucchi Francesco    4BI
    Creare la classe Pila su tipo generico vincolato (metodi: costruttori, size, pop, push, importa ed esporta) e
    la classe PacchettoAzionario (metodi: costruttori, set/get) che implementi interfaccia FileCsv.
    ---
    Realizzare il programma che permetta di effettuare acquisti e vendite di pacchetti azionari.
    Il programma gestirà in modalità LIFO gli acquisti e calcolerà PluValenza e MinusValenza per ogni vendita.
    La pila dei pacchetti azionari acquistati (per uno stesso titolo) viene salvata alla fine del programma in
    un file csv e viene ripristinata in ram all'inizio del programma a partire dal file csv.
*/
public class Main {
    public static void main(String[] args) {
        testImp();
    }

    public static void testImp(){
        Pila<PacchettoAzionario> pila = new Pila<>();
        try{
            pila.importa("f.csv", new PacchettoAzionario());
            while(!pila.isEmpty())
                System.out.println(pila.pop().toCSV());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}