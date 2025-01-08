#include <stdio.h>
#include <stdlib.h>

/*
    ES1
    Realizzare un programma che chiede due numeri in input;
    generare in seguito una biforcazione.
    Il processo padre effettua la somma dei due numeri e la stampa,
    il processo figlio esegue il prodotto tra i due numeri e li stampa.
*/

int main()
{
    int pid, x1, x2;
    printf("Inserire due numeri: ");
    scanf("%d %d", &x1, &x2);
    pid = fork();
    if(pid < 0)
        printf("Errore nella generazione del processo figlio\n");
    else if(pid == 0){
        //ramo processo figlio
        printf("Processo figlio: \n");
        printf("Prodotto %d * %d = %d \n", x1, x2, x1*x2);
        printf("-------------------");
    }
    else{
        printf("Processo padre: \n");
        printf("Somma %d + %d = %d \n", x1, x2, x1+x2);
    }
    return 0;
}
