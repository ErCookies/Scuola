#include "header.h"

/*
    Francesco Cucchi    3^BI

    TESTO:
    Realizzare la procedura che carica un array di record prelevando i dati da file csv
    (pseudocodice e linguaggio Cstd in cui >NON è possibile usare le []).`
    void caricaArray(TDati *v, int n);
    Realizzare ambiente chiamante sia con array istanziato a run time che con array allocato a compile time.
*/

int main()
{
    int num = 0;
    TDati* data[NMAX];
    caricaArray(data, &num);
    stampa(data, &num);
    return 0;
}
