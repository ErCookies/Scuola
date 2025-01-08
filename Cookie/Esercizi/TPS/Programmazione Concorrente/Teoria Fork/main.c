#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>  // Include this header for fork()

int main() {
    int pid;
    printf("Prima della fork: 1 processo MAIN\n");
    pid = fork();
    if (pid < 0) {
        printf("Errore nella generazione del processo figlio\n");
    } else if (pid == 0) {
        // ramo processo figlio
        printf("Processo figlio\n");
    } else {
        // ramo processo padre
        printf("Processo padre\n");
    }

    return 0;
}
