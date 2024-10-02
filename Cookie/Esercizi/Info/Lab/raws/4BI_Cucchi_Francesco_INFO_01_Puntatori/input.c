#include "header.h"

int lgInt(int vmin, int vmax, char* mex){
    int x;
    printf("%s", mex);
    scanf("%d", &x);
    while(x<vmin || x>vmax){
        err();
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
        err();
        printf("%s", mex);
        scanf("%f", &x);
    }
    return x;
}

char lgChar(char* mex){
    char c;
    printf("%s", mex);
    fflush(stdin);
    scanf("%c", &c);
    if(c == '\0'){
        err();
        printf("%s", mex);
        fflush(stdin);
        scanf("%c", &c);
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
    printf("1) Inserimento frase;\n");
    printf("2) Numero vocali e consonanti;\n");
    printf("3) Frase in reverse;\n");
    printf("4) Sostituzione vocali col carattere - ;\n");
    printf("5) Dato un carattere, contarne la frequenza;\n");
    printf("0) Termina programma;\n");
}

void err(){
    printf("Errore\n");
}
