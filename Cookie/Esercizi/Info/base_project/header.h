#include <stdio.h>
#include <stdlib.h>
#include <string.h>

///COSTANTI
#define CNOM 16
#define LEN 128

///STRUTTURA RECORD
typedef struct{
    char nom[CNOM];
    char cog[CNOM];
    float age;
}TDati;

struct TNodo{
    TDati pers;
    struct TNodo* next;
};

///PROCEDURE ESERCIZIO
struct TNodo* imp(struct TNodo *first, int *n);

///INPUT + VARIE
int lgInt(int vmin, int vmax, char* mex);           //LEGGI INT
float lgFlt(float vmin, float vmax, char* mex);     //LEGGI FLOAT
char lgChar(char *mex);                             //LEGGI CHAR
void lgStr(char *s, char *mex);                     //LEGGI STRING
void menu();
void err();
