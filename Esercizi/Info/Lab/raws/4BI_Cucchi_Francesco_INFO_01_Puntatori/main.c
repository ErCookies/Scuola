#include "header.h"

/*
    FRANCESCO CUCCHI    3^BI

    TESTO:
    Realizzare un programma contenente un menu in cui sono presenti I seguenti punti:
    1. Chiedere in input una frase all’utente;
    2. Contare il numero di vocali e consonanti di cui è composta quella frase;
    3. Stampare la frase al contrario;
    4. Sostituire le vocali con il simbolo “-” e stampare il risultato
    5. Dato un carattere chiesto in input, contare quante volte è presente quel carattere nella frase
*/
int main()
{
    int sc;
    char frase[LEN];
    int* lun = malloc(sizeof(int));
    do{
        system("cls");
        menu();
        sc = lgInt(0,5,"Selezionare funzione interessata: ");
        switch(sc){
            case 1:{
                ins(frase, lun);
                break;
            }
            case 2:{
                cntVC(frase, lun);
                break;
            }
            case 3:{
                stampaReverse(frase, lun);
                break;
            }
            case 4:{
                sostVoc(frase, lun);
                break;
            }
            case 5:{
                cntChar(frase, lun);
                break;
            }
            case 0:
                break;
        }
        system("pause");
        system("cls");
    }while(sc!=0);
    return 0;
}
