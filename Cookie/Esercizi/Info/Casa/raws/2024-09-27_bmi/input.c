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
    printf("1) Importazione + calcolo bmi;\n");
    //printf("2) Stampa dati importati;\n");
    printf("2) Esportazione persone sottopeso;\n");
    printf("0) Termina programma;\n");
}

void err(){
    printf("Errore\n");
}
