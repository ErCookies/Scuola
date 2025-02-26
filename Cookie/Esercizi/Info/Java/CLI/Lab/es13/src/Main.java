/*
    Cucchi Francesco    4BI

   TESTO:
    Un’azienda è caratterizzata da un nome, un responsabile, un indirizzo, una e-mail ed un sito web.
    In tale azienda lavorano dipendenti di tipo diverso: Impiegati e Operai.
    Tutti i dipendenti sono caratterizzati da:
        - Matricola (Intero - UNIVOCO)
        - Nome
        - Cognome
        - Data di nascita
    Gli impiegati sono caratterizzati da un salario mensile e dal numero di ore di permesso
    (per ogni ora di permesso vengono decurtati 20€ dallo stipendio).
    Gli operai, invece, sono caratterizzati da una paga oraria, un numero di ore di straordinario e un numero di ore di permesso (si consideri che, di norma, un mese è formato da 160 ore lavorative e le ore di straordinario hanno una paga orario incrementata del 30% rispetta a quella ordinaria).
    Tutti gli elementi della gerarchia devono avere metodi comuni come stampaDati e calcolaPaga.
    Realizzare un programma che gestisca i dipendenti di un’azienda.
    Tale menù sarà costituito dai seguenti punti:
        1. Inserimento di un nuovo dipendente
        2. Stampa dell’elenco dei dipendenti dell’azienda
            - per gli operai stampare “matricola+nome+cognome+oreLavorate”;
            - per gli impiegati stampare “matricola+nome+cognome+pagaMensile”;
        3. Stampa di tutti di dipendenti aventi uno stipendio mensile inferiore a 1350€
        4. Licenziamento di un dipendete, data la matricola
        5. Stampa del totale stipendi che l’azienda dovrà versare ai dipendenti
        6. Esportazione su file csv di tutti i dipendenti di un tipo indicato ordinati per cognome (Operaio/Impiegato)

    Dovrà esistere la classe Gestore che gestisce l’insieme dei dipendenti (l’insieme è gestita come lista non sequenziale gestita dalla classe MyList<T> vista a lezione) che avrà tutti i metodi necessari alle funzionalità del main. La classe T dovrà usare l’interfaccia Comparable e FileCsv.
    L’interazione con l’utente avverrà tramite interfaccia grafica e le diverse voci del menù saranno rappresentate da bottoni presenti alla prima finestra visibile all’apertura del programma.
    Realizzare il mockup dell’applicazione per individuare gli oggetti grafici necessari ad ogni singola finestra del programma.
    Descrivere, inoltre, la struttura del file csv.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}