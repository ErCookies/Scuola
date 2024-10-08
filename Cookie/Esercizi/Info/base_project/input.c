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
    printf("1) ;");
    printf("2) ;");
    printf("3) ;");
    printf("4) ;");
    printf("5) ;");
    printf("0) Termina programma;");
}

void err(){
    printf("Errore\n");
}
