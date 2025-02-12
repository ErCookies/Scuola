#include <stdio.h>
#include <stdlib.h>

/*
    Cucchi Francesco    4BI
    TESTO:
    Esercizio 6
    Creare un programma che generi 4 processi figli.
    Per ogni figlio chiedere in input un tempo di attesa in secondi.
    Il processo padre attenderà il processo con attesa MAGGIORE.
*/
void creaFiglio();

int main()
{
    for(int k = 0; k < 3; k++){
        //
    }
    return 0;
}

void creaFiglio(){
    int pid = fork();
    int waitTime;
    printf("Inserire tempo attesa: ");
    scanf("%d", &waitTime);
}
