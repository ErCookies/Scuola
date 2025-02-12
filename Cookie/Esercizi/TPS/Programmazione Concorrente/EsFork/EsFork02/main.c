#include <stdio.h>
#include <stdlib.h>

/*
    ES2
    Realizzare un programma che chiede in input un valore
    intero all'utente. generare in seguito una biforcazione.
    Il processo padre effettua stampa tutti i divisori di
    quel numeri, il processo figlio stampa il cubo del numero.
*/

int main()
{
    int pid, x, k;
    printf("Inserire un numero: ");
    scanf("%d", &x);
    pid = fork();
    if(pid < 0)
        printf("Errore nella generazione del processo figlio\n");
    else if(pid == 0){
        //ramo processo figlio
        printf("Cubo di %d: %d", x, pow(x,3));
    }
    else{
        //ramo processo padre
        printf("Divisori di %d: ", x);
        for(k = 1, k < x/2; k++){
            if(x%k == 0)
                printf("%d", k);
        }
        printf("\n");
    }
}
