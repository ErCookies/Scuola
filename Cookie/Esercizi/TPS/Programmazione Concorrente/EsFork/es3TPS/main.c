#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/*
    Cucchi Francesco    4BI

    TESTO:
    Esercizio 3
    Realizzare un programma che chiede in input 4 valori all'utente; generare in seguito
    una biforcazione. Il processo padre effettua stampa il maggiore, il processo figlio
    stampa la media dei valori.
*/

int main()
{
    int x[4];
    printf("Inserire 4 numeri: ");
    scanf("%d %d %d %d", &x[0], &x[1], &x[2], &x[3]);
    int pid = fork();

    if(pid < 0)
        printf("Errore nella fork");
    else if(pid == 0){
        //ramo figlio
        printf("(FIGLIO): Media: %f", (double)((x[0]+x[1]+x[2]+x[3])/4));
    }
    else{
        //ramo padre
        int max = x[0];
        for(int k = 1; k < 3; k++)
            if(x[k] > max)
                max = x[k];
        printf("(PADRE): Numero maggiore: %d", max);
    }

    return 0;
}
