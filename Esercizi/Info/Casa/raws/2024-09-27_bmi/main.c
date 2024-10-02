#include "header.h"

/*
    Francesco Cucchi    3^BI

    TESTO:
    per una serie di persone di cui si conosce peso ed altezza, realizzare un programma che permetta di:
    a) calcolare l'indice BMI (indice di massa corporea) indicando a quale classe appartiene l'utente
    b) elencare in un file di testo(esportazione) i dati forniti per le persone considerate "sottopeso"
       e il loro numero totale.
    I dati delle persone sono contenute in un file di testo avente per ogni riga peso e altezza di una
    singola persona separata da uno spazio.
    Vincoli: i dati del file DEVONO essere caricati in un array di record istanziato a run time
    con un numero di elementi pari a numero delle righe del file
*/

int main()
{
    TDati* data = NULL;
    int sc, num = 0;
    do{
        menu();
        sc = lgInt(0,2,"Selezionare funzione interessata: ");
        system("cls");
        switch(sc){
            case 1:{
                data = imp(&num);
                break;
            }
            case 2:{
                espSP(data,num);
                break;
            }
            case 0:
                break;
        }
        system("pause");
        system("cls");
    }while(sc!=0);
    free(data);
    return 0;
}
