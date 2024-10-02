#include <stdio.h>
#include <stdlib.h>
#include <string.h>

///COSTANTI
#define NMAX 16
#define LEN 128
#define STR 32

///STRUTTURA RECORD
typedef struct{
    int numI;
    float numF;
    char c;
    char stringa[STR];
}TDati;

///PROTOTIPI
void caricaArray(TDati *v, int *n);
void stampa(TDati *v, int *n);
void stamparec(TDati *v);
