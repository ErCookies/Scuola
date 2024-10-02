#include "header.h"

void caricaArray(TDati *v, int *n){
    FILE* f = fopen("f.csv", "r");
    if(f != NULL){
        int k;
        *n = 0;
        char* str = (char*) calloc(sizeof(char),LEN);
        fgets(str,LEN,f);
        for(k = 0; !feof(f); k++){
            (v+k)->numI = atoi(strtok(str,";"));
            (v+k)->numF = atof(strtok(NULL,";"));
            strcpy(&((v+k)->c), strtok(NULL,";"));
            strcpy(((v+k)->stringa), strtok(NULL,";"));
            fgets(str,LEN,f);
        }
        *n = k;
        fclose(f);
        printf("Numero record importati: %d\n", *n);
    }
    else
        printf("Errore, file inesistente\n");
}

void stampa(TDati *v, int *n){
    for(int k = 0; k<*n; k++){
        printf("----------------------\n");
        printf("Record num %d: \n", k+1);
        stamparec(v+k);
    }
}

void stamparec(TDati *v){
    printf("Numero intero: %d\n", v->numI);
    printf("Numero float: %.2f\n", v->numF);
    printf("Carattere: %c\n", v->c);
    printf("Stringa: %s\n", v->stringa);
}
