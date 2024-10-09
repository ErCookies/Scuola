#include "header.h"

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
    scanf("%s",&c);
    while(c == '\0'){
        err();
        printf("%s",mex);
        fflush(stdin);
        scanf("%s",&c);
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
    printf("1) Importazione da file .csv;\n");
    printf("2) Stampa tutte le auto;\n");
    printf("3) Visualizza dati auto data la targa;\n");
    printf("4) Salvare su file binario tutte le auto di un tipo deciso in input;\n");
    printf("5) Data targa calcolare guadagno;\n");
    printf("0) Termina programma;\n");
}

void err(){
    printf("Errore\n");
}
