#include "header.h"

/*
    Francesco Cucchi 4BI

    TESTO:
    Creare un software per la gestione delle auto poste a noleggio di una azienda. Per ogni auto vengono memorizzate
    le seguenti informazioni:
    - Targa (Univoco)
    - Modello
    - tipo auto (utilitaria, lusso, confort)
    - prezzo al giorno
    - km fatti dall'acquisto.
    Realizzare un programma che permetta di:
    1. Caricare da file *.csv il parco macchine dall'azienda disponibili per il noleggio.
    2. Stampa tutte le auto contenute nella lista.
    3. Visualizzare i dati di un'auto di cui si fornisce la targa.
    4. Salvare su file binario tutti le auto di un tipo scelto in input dall'utente.
    5. Data in input una targa calcolare il guadagno in base ai km effettuati.
    Per il calcolo del guadagno usare una funzione parametrizzata che segua le seguenti regole:
    - per il livello "utilitaria" il guadagno al km e' 0,44 euro;
    - per il livello "lusso" il guadagno al km e' 1,99 euro;
    - per il livello "confort" il guadagno al km e' 0,99 euro.

    Obblighi/Limiti:
    - Ogni singolo punto del menu deve essere preceduto dallo pseudocodice con descrizione dei parametri,
    delle variabili locali e delle strutture dei file creati.
    - Il progetto dovr� essere realizzato dividendo il codice in piu' file.
    - Per gli input si dovranno utilizzare le apposite funzioni realizzate.
*/

int main()
{
    int sc;
    TNodo* first = NULL;
    char* nf[CMOD];
    do{
        menu();
        sc = lgInt(0,5,"Selezionare funzione interessata: ");
        switch(sc){
            case 1:{
                lgStr(nf,"Inserire nome file: ");
                first = imp(first, nf);
                break;
            }
            case 2:{
                stampa(first);
                break;
            }
            case 3:{
                //voce
                break;
            }
            case 4:{
                //voce
                break;
            }
            case 5:{
                //voce
                break;
            }
            case 0:
                break;
        }
    }while(sc!=0);
    return 0;
}
