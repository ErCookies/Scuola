#include <stdio.h>
#include <stdlib.h>
#include <string.h>

///COSTANTI
#define LEN 127

///STRUTTURA RECORD


///PROCEDURE ESERCIZIO
void ins(char *s, int *l);
void stampa(char *s);
void cntVC(char *s, int *l);
void stampaReverse(char *s, int *l);
void sostVoc(char *s, int *l);
void cntChar(char *s, int *l);

///INPUT + VARIE
int lgInt(int vmin, int vmax, char* mex);           //LEGGI INT
float lgFlt(float vmin, float vmax, char* mex);     //LEGGI FLOAT
char lgChar(char* mex);                             //LEGGI CHAR
void lgStr(char *s, char *mex);                     //LEGGI STRING
void menu();
void err();
