#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define NMAX 100
void ins(int* v, int* n);  //v: indirizzo vettore || num: numero elementi inseriti
void stampa(int *v, int n);
int lgInt(int vmin, int vmax, char* mex);

int main()
{
    int vett[NMAX], num;
    ins(vett, &num);
    stampa(vett, num);
    return 0;
}

void ins(int* v, int* n){
    int k;
    (*n) = lgInt(1, NMAX, "Inserire numero elementi (max 100): ");
    for(k = 0; k<(*n); k++){
        *(v+k) = lgInt(INT_MIN, INT_MAX, "Inserire numero: ");
    }
}

void stampa(int *v, int n){
    for(int k=0; k<n; k++){
        printf("%d \n", *(v+k));
    }
}

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
