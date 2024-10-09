#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

///COSTANTI
#define CTAR 8
#define CMOD 16
#define CTIPO 11
#define LEN 64

///STRUTTURA RECORD
typedef struct{
    char tar[CTAR];
    char mod[CMOD];
    char tipo[CTIPO];
    float prc;
    int km;
}TAuto;

typedef struct TNodo{
    TAuto car;
    struct TNodo* next;
}TNodo;

///PROCEDURE ESERCIZIO
TNodo* imp(TNodo* first, char *nf);
void stampa(TNodo *f);
void stampaEl(TNodo *el);
bool ricTar(TNodo *f, char *elTar);
bool ricTipo(TNodo *f, char *elTipo);


///INPUT + VARIE
int lgInt(int vmin, int vmax, char* mex);           //LEGGI INT
float lgFlt(float vmin, float vmax, char* mex);     //LEGGI FLOAT
char lgChar(char *mex);                             //LEGGI CHAR
void lgStr(char *s, char *mex);                     //LEGGI STRING
void menu();
void err();
