#include "header.h"

/*
    Francesco Cucchi    4^BI

    TESTO:
    Un negozio di informatica commissiona un applicativo per la gestione del proprio catalogo di videogiochi.
    Ogni videogioco ha le seguenti caratteristiche:
    - ID – Univoco
    - Nome
    - Costo
    - Classificazione (S, A, B)
    - Usato (0->usato, 1->nuovo)
    Realizzare un menu che presenti le seguenti funzionalita':
    1) Importa il catalogo dei videogiochi da file (controlla che i dati del videogioco siano corretti. In caso di
    errori la riga riferita al videogioco dovra' essere esportata in un file chiamato log.csv);
    2) Stampa catalogo;
    3) Stampa il valore economico totale del catalogo;
    4) Dato l'ID, stampa i dati videogioco;
    5) Dato l'ID, modifica il costo del videogioco;
    6) Data la classificazione, esporta in un file i videogiochi aventi quella classificazione;
    - VINCOLI/OBBLIGHI
    − Il progetto dovrà essere realizzato dividendo il codice in piu' file.
    − Per gli input si dovranno utilizzare le apposite funzioni realizzate.
    − L'array di record si deve istanziare a run time
    − obbligo di uso dei puntatori all'interno delle procedure e delle funzioni.
    − Non è possibile utilizzare parentesi quadre ([]).
*/

int main()
{
    Tgioco* giochi = NULL;
    int* num = (int*)malloc(sizeof(int));
    int sc;
    do{
        system("cls");
        menu();
        sc = lgInt(0,6,"Inserire funzione interessata: ");
        switch(sc){
            case 1:{
                giochi = imp(giochi,num);
                break;
            }
            case 2:{
                stampaCat(giochi,*num);
                break;
            }
            case 3:{
                valEcTot(giochi,*num);
                break;
            }
            case 4:{
                stampaPerID(giochi,*num);
                break;
            }
            case 5:{
                modPricePerID(giochi,*num);
                break;
            }
            case 6:{
                espCat(giochi,*num);
                break;
            }
            case 0: break;
        }
        system("pause");
        system("cls");
    }while(sc!=0);
}
