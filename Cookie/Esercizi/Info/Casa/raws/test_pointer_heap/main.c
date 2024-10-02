#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define NMAX 100
void ins(int* v, int* n);  //v: indirizzo vettore || num: numero elementi inseriti
void stampa(int *v, int n);
int lgInt(int vmin, int vmax, char* mex);
/*
    vett, numeri inseriti, array di NMAX int
    num, numero valori effettivamente inseriti, int
*/
int main()
{
    //int* vett = (int*) malloc(sizeof(int)*NMAX); met 1
    //int* vett = (*int) calloc(NMAX, sizeof(int)); met 2
    int* vett = (int*) malloc(sizeof(int)); //met 3
    int* num = (int*) malloc(sizeof(int));
    ins(vett, num);
    stampa(vett, (*num));
    free(vett);
    free(num);
    return 0;
}
/* metodo 1-2
void ins(int* v, int* n){
    int k, r = 1;
    for(k = 0; k<NMAX && r == 1; k++){
        *(v+k) = lgInt(INT_MIN, INT_MAX, "Inserire numero: ");
        r = lgInt(0,1,"Altri numeri da inserire? (0 no | 1 si): ");
    }
    if(k == NMAX && r == 1)
        printf("%s (%d)\n", "Raggiunto limite numeri", NMAX);
    (*n) = k;
}*/

//metodo 3
void ins(int* v, int* n){
    int k, r = 1;
    for(k = 0; r == 1; k++){
        *(v+k) = lgInt(INT_MIN, INT_MAX, "Inserire numero: ");
        r = lgInt(0,1,"Altri numeri da inserire? (0 no | 1 si): ");
        if(r == 1)
            v = realloc(v,sizeof(int)*(k+1));
    }
    (*n) = k;
}

void stampa(int *v, int n){
    printf("Numeri che hai inserito: \n");
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
