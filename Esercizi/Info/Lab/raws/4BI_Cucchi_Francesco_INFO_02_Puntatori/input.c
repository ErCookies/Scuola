#include "header.h"

//Francesco Cucchi  4BI

int lgInt(int vmin, int vmax, char* mex){
    int x;
    printf("%s", mex);
    scanf("%d", &x);
    while(x<vmin || x>vmax){
        printf("%s", "Errore\n");
        printf("%s", mex);
        scanf("%d", &x);
    }
    return x;
}

float lgFlt(float vmin, float vmax, char* mex){
    float x;
    printf("%s", mex);
    scanf("%f", &x);
    while(x<vmin || x>vmax){
        printf("%s", "Errore\n");
        printf("%s", mex);
        scanf("%f", &x);
    }
    return x;
}

char lgChar(char *mex){
    char c;
    printf("%s",mex);
    fflush(stdin);
    scanf("%c",&c);
    while(c == '\0'){
        err();
        printf("%s",mex);
        fflush(stdin);
        scanf("%c",&c);
    }
    return c;
}

void lgStr(char *s, char *mex){
    printf("%s", mex);
    fflush(stdin);
    gets(s);
    while(strcmp(s, "") == 0){
        err();
        printf("%s", mex);
        fflush(stdin);
        gets(s);
    }
}

void menu(){
    printf("1) Importazione catalogo;\n");
    printf("2) Stampa catalogo;\n");
    printf("3) Valore economico totale;\n");
    printf("4) Dato ID, stampa dati;\n");
    printf("5) Dato ID, modifica costo;\n");
    printf("6) Esporta i videogiochi con una data la classificazione;\n");
    printf("0) Termina programma;\n");
}

void err(){
    printf("Errore\n");
}
