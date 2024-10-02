#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

///COSTANTI
#define LEN 128

///STRUTTURA RECORD
typedef struct{
    float w, h, b;
}TDati;

///PROCEDURE ESERCIZIO
TDati* imp(int *n);
void stampaDati(TDati *v, int n);
void stampa(TDati *v);
float bmi(TDati *v);
void gestClasse(TDati *v);
void espSP(TDati *v, int num);

///INPUT + VARIE
int lgInt(int vmin, int vmax, char* mex);           //LEGGI INT
float lgFlt(float vmin, float vmax, char* mex);     //LEGGI FLOAT
void lgStr(char *s, char *mex);                     //LEGGI STRING
void menu();
void err();
