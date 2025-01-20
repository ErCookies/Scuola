#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <iostream>
#include <fstream>
#include <string>
#include <string.h>
#include <float.h>

using namespace std;

///COSTANTI


///STRUTTURA RECORD


///PROCEDURE SPECIFICHE ESERCIZIO


///INPUT
int lgInt(int xmin, int xmax, string mex); //INT
float lgFlt(float xmin, float xmax, string mex); //FLOAT
double lgDbl(double xmin, double xmax, string mex); //DOUBLE
char lgChar(string mex); //CHAR
string lgStrS(string mex); //STRINGA come string
void lgStrC(char *s, string mex); //STRINGA come *char

///RICERCHE
int ricUni(string el, string *v, int n); //RICERCA CLASSICA
int ricBinStr(string el, string *v, int n); //RICERCA BINARIA STRING
int ricBinChar(char* el, string *v, int n); //RICERCA BINARIA CHAR

///ORDINAMENTO E SCAMBI
void srt(string *s, int n); //SORT GENERICO
void swcI(int &x1, int &x2); //SCAMBIA INT
void swcF(float &x1, float &x2); //SCAMBIA FLOAT
void swcD(double &x1, double &x2); //SCAMBIA DOUBLE
void swcC(char &x1, char &x2); //SCAMBIA CHAR
void swcS(string &x1, string &x2); //SCAMBIA STRING

///VARIE
void err();
void menu();
void sep();

#endif // HEADER_H_INCLUDED
