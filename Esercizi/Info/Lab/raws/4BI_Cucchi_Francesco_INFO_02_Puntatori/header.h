//Francesco Cucchi  4BI

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <float.h>

///COSTANTI
#define CONID 6
#define CONNAME 16
#define LEN 128

///STRUTTURA RECORD
typedef struct{
    char id[CONID];     ///univoco
    char name[CONNAME];
    float price;        ///>0
    char tipo;          ///S-A-B
    int nuovo;          ///0-1
}Tgioco;

///PROCEDURE ESERCIZIO
Tgioco* imp(Tgioco *v, int *n);
int ric(Tgioco *v, char *el, int num);
void stampaCat(Tgioco *v, int num);
void stampa(Tgioco *v);
void valEcTot(Tgioco *v, int n);
void stampaPerID(Tgioco *v, int n);
void modPricePerID(Tgioco *v, int n);
void espCat(Tgioco *v, int n);

///INPUT + VARIE
int lgInt(int vmin, int vmax, char* mex);           //LEGGI INT
float lgFlt(float vmin, float vmax, char* mex);     //LEGGI FLOAT
char lgChar(char *mex);                              //LEGGI CHAR
void lgStr(char *s, char *mex);                     //LEGGI STRING
void menu();
void err();