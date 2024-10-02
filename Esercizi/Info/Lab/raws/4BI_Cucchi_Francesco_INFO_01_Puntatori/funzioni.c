#include "header.h"

//inserimento frase
void ins(char *s, int *l){
    lgStr(s, "Inserire frase: ");
    *l = strlen(s);
    printf("Lunghezza: %d\n", *l);
}

void stampa(char *s){
    printf("Frase: %s\n", s);
}

//conta vocali e consonanti
void cntVC(char *s, int *l){
    int voc = 0, cons = 0;
    for(int k = 0; k<*l; k++){
        if(*(s+k) == 'a' || *(s+k) == 'e' || *(s+k) == 'i' || *(s+k) == 'o' || *(s+k) == 'u' || *(s+k) == 'A' || *(s+k) == 'E' || *(s+k) == 'I' || *(s+k) == 'O' || *(s+k) == 'U')
            voc++;
        else
            cons++;
    }
    printf("Numero vocali: %d\nNumero consonanti: %d\n", voc, cons);
}

//stampare la frase al contrario
void stampaReverse(char *s, int *l){
    for(int k = *l; k>=0; k--)
        printf("%c",*(s+k));
    printf("\n");
}

void sostVoc(char *s, int *l){
    char* s1 = (char*) calloc(sizeof(char),*l);
    strcpy(s1,s);
    for(int k = 0; k<*l; k++){
        if(*(s1+k) == 'a' || *(s+k) == 'e' || *(s+k) == 'i' || *(s+k) == 'o' || *(s+k) == 'u' || *(s+k) == 'A' || *(s+k) == 'E' || *(s+k) == 'I' || *(s+k) == 'O' || *(s+k) == 'U')
            *(s1+k) = '-';
    }
    stampa(s1);
}

//dato un carattere, contare quante volte appare
void cntChar(char *s, int *l){
    int n = 0;
    char c = lgChar("Inserire carattere interessato: ");
    for(int k = 0; k<*l; k++){
        if(*(s+k) == c)
            n++;
    }
    if(n == 0)
        printf("Il carattere non '%c' compare nella frase\n", c);
    else
        printf("Il carattere '%c' compare %d volte\n", c, n);
}
