///HEADER
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

///FUNZIONI
///-----------------------------------------------------------------
#include "header.h"

/*
    Francesco Cucchi    4BI

    1) Importa il catalogo dei videogiochi da file (controlla che i dati del videogioco siano corretti. In caso di
    errori la riga riferita al videogioco dovra' essere esportata in un file chiamato log.csv);

    DESCRIZIONE FILE .CSV:
    Il file csv conterra' i dati di un singolo videogioco per ogni riga. Ogni dato sara' separato da un ";", nel seguente ordine:
    id;nome;prezzo;tipo;nuovo/usato;

    PSEUDOCODIFICA:
    INIZIO
        apri il file f (input)
        apri il file log (output)
        se il file esiste
        allora
            leggi la prima riga del file f in str
            k = 0
            mentre il file non e' finito
                spezza str nei vari item
                assegna il primo item a v[k].id
                ricerca v[k].id all'interno del vettore v e ritorna la sua posizione in pos o -1
                se pos == -1
                allora
                    assegna il 2,3,4 item a v[k]. name, price e tipo
                    se tipo!= "S" && "A" && "B"
                    allora
                        scrivi str nel file di log
                    altrimenti
                        assegna l'ultimo item a nuovo
                        se nuovo != 0 != 1
                        allora
                            scrivi str nel file di log
                        altrimenti
                            k++
                        fse
                    fse
                altrimenti
                    scrivi str nel file log
                fse
                leggi la prossima riga del file in str
            fciclo
            se k == 0
            allora
                scrivi "nessun gioco importato"
            fse
            chiudi il file f
            chiudi il file log
        altrimenti
            errore
        fse
    FINE
*/

Tgioco* imp(Tgioco *v, int *n){ ///importazione dei dati da file
    FILE *f = fopen("f.csv","r"); //apro il file da cui importare i dati
    if(f != NULL){ //se esiste
        size_t dim = sizeof(Tgioco); //dimensione dell'array da istanziare
        if(v != NULL) //se l'importazione e' gia' stata effettuata
            free(v); //libera la zona di memoria corrispondente
        v = (Tgioco*)malloc(dim); //allocazione di memoria
        FILE *log = fopen("log.csv","w"); //apertura / creazione del file di log
        *n = 0; //azzeramento contatore
        int pos; //eventuale posizione dell'elemento duplicato
        char str[LEN], aus[LEN]; //riga letta dal file | copia ausiliaria
        fgets(str,LEN,f); //lettura della prima riga del file
        while(!feof(f)){ //ciclo fino a terminazione file
            strcpy(aus,str); ///copia della riga letta dal file in una stringa ausiliaria per evitare problemi nella stampa sul file di log
            strcpy((v+*n)->id,strtok(str,";"));  //assegnazione primo item
            pos = ric(v,(v+*n)->id,*n); //ricerca dell'univocita' dell'id
            if(pos == -1){ //se non esiste
                strcpy((v+*n)->name,strtok(NULL,";")); //assegnazione secondo item
                (v+*n)->price = atof(strtok(NULL,";")); //assegnazione terzo item
                if((v+*n)->price <= 0){ //controllo sul prezzo
                    printf("Contenuto riga invalido, prezzo non positivo\n");
                    fprintf(log,"%s",aus);
                    //esportazione riga su file di log + motivazione
                }
                else{
                    strcpy(&((v+*n)->tipo),strtok(NULL,";")); //assegnazione quarto item
                    if((v+*n)->tipo != 'S' && (v+*n)->tipo != 'A' && (v+*n)->tipo != 'B'){ //controllo sulla validita' del file
                        printf("Contenuto riga invalido, TIPOLOGIA errata\n");
                        fprintf(log,"%s",aus);
                        //esportazione riga su file di log + motivazione
                    }
                    else{
                        (v+*n)->nuovo = atoi(strtok(NULL,";")); //importazione ultimo item
                        if((v+*n)->nuovo != 0 && (v+*n)->nuovo != 1){
                            printf("Contenuto riga invalido, valore USATO errato\n");
                            fprintf(log,"%s",aus);
                            //esportazione riga su file di log + motivazione
                        }
                        else{
                            printf("Elemento num %d importato con successo\n", *n); //conferma
                            (*n)++; //incremento contatore elementi corretti
                            dim += sizeof(Tgioco); //aumento dimensione
                            v = (Tgioco*)realloc(v,dim); //riallocazione con nuova dimensione
                        }
                    }
                }
            }
            else{
                printf("Contenuto riga invalido, ID duplicato\n");
                fprintf(log,"%s",aus);
                //esportazione riga su file di log + motivazione
            }
            fgets(str,LEN,f); //lettura riga successiva
        }
        fclose(f);
        fclose(log);
    }
    else
        err();

    return v;
}

int ric(Tgioco *v, char *el, int num){
    int pos = -1;
    for(int k = 0; k<num && pos == -1; k++){
        if(strcmp((v+k)->id,el) == 0)
            pos = k;
    }
    return pos;
}

void stampaCat(Tgioco *v, int num){ ///stampa ogni elemento importato
    if(v != NULL){
        for(int k=0; k<num; k++)
            stampa(v+k);
    }
    else
        printf("Importa prima i dati\n");
}

void stampa(Tgioco *v){
    printf("ID: %s\n",v->id);
    printf("Nome: %s\n",v->name);
    printf("Prezzo: %.2f\n",v->price);
    printf("Classificazione: %c\n",v->tipo);
    printf("Nuovo: %d\n",v->nuovo);
}


void valEcTot(Tgioco *v, int n){ ///stampa valore economico totale
    if(v != NULL){
        float tot = 0;
        for(int k=0; k<n; k++){
            tot += (v+k)->price;
        }
        printf("Valore economico totale: %.2f\n", tot);
    }
    else
        printf("Importa prima i dati\n");
}

void stampaPerID(Tgioco *v, int n){ ///stampa videogioco per ID
    if(v != NULL){
        char ausID[CONID];
        lgStr(ausID,"Inserire ID interessato: ");
        int pos = ric(v,ausID,n);
        if(pos != -1)
            stampa(v+pos);
        else
            printf("Nessun videogioco con tale ID\n");
    }
    else
        printf("Importa prima i dati\n");
}

void modPricePerID(Tgioco *v, int n){ ///dato ID modifica il prezzo
    if(v != NULL){
        char ausID[CONID];
        lgStr(ausID,"Inserire ID interessato: ");
        int pos = ric(v,ausID,n);
        if(pos != -1){
            (v+pos)->price = lgFlt(0.01,FLT_MAX,"Inserire nuovo prezzo: ");
            printf("Modifica effettuata con successo\n");
        }
        else
            printf("Nessun videogioco con tale ID\n");
    }
    else
        printf("Importa prima i dati\n");
}

void espCat(Tgioco *v, int n){ ///esporta tutti i videogiochi di una data categoria
    char cat = lgChar("Inserire categoria ('S', 'A', 'B'): ");
    int expd = 0;
    while(cat != 'S' && cat != 'A' && cat != 'B'){
        err();
        cat = lgChar("Inserire categoria ('S', 'A', 'B'): ");
    }
    FILE* exp = fopen("expCat.csv","w");
    for(int k = 0; k<n; k++){
        if((v+k)->tipo == cat){
            fprintf(exp, "%s;%s;%.2f;%c;%d;\n", (v+k)->id, (v+k)->name, (v+k)->price, (v+k)->tipo, (v+k)->nuovo);
            expd++;
        }
    }
    fclose(exp);
    printf("Sono stati esportati %d elementi\n", expd);
}

///MAIN
///-----------------------------------------------------------------
#include "header.h"

/*
    Francesco Cucchi    4^BI

    TESTO:
    Un negozio di informatica commissiona un applicativo per la gestione del proprio catalogo di videogiochi.
    Ogni videogioco ha le seguenti caratteristiche:
    - ID – Univoco
    - Nome
    - Costo
    - Classificazione (S, A, B)
    - Usato (0->usato, 1->nuovo)
    Realizzare un menu che presenti le seguenti funzionalita':
    1) Importa il catalogo dei videogiochi da file (controlla che i dati del videogioco siano corretti. In caso di
    errori la riga riferita al videogioco dovra' essere esportata in un file chiamato log.csv);
    2) Stampa catalogo;
    3) Stampa il valore economico totale del catalogo;
    4) Dato l'ID, stampa i dati videogioco;
    5) Dato l'ID, modifica il costo del videogioco;
    6) Data la classificazione, esporta in un file i videogiochi aventi quella classificazione;
    - VINCOLI/OBBLIGHI
    − Il progetto dovrà essere realizzato dividendo il codice in piu' file.
    − Per gli input si dovranno utilizzare le apposite funzioni realizzate.
    − L'array di record si deve istanziare a run time
    − obbligo di uso dei puntatori all'interno delle procedure e delle funzioni.
    − Non è possibile utilizzare parentesi quadre ([]).
*/

int main()
{
    Tgioco* giochi = NULL;
    int* num = (int*)malloc(sizeof(int));
    int sc;
    do{
        system("cls");
        menu();
        sc = lgInt(0,6,"Inserire funzione interessata: ");
        switch(sc){
            case 1:{
                giochi = imp(giochi,num);
                break;
            }
            case 2:{
                stampaCat(giochi,*num);
                break;
            }
            case 3:{
                valEcTot(giochi,*num);
                break;
            }
            case 4:{
                stampaPerID(giochi,*num);
                break;
            }
            case 5:{
                modPricePerID(giochi,*num);
                break;
            }
            case 6:{
                espCat(giochi,*num);
                break;
            }
            case 0: break;
        }
        system("pause");
        system("cls");

    }while(sc!=0);
}

///INPUT
///-----------------------------------------------------------------
#include "header.h"

//Francesco Cucchi  4BI

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

float lgFlt(float vmin, float vmax, char* mex){
    float x;
    printf("%s", mex);
    scanf("%f", &x);
    while(x<vmin || x>vmax){
        printf("%s", "Errore\n");
        printf("%s", mex);
        scanf("%f", &x);
    }
    return x;
}

char lgChar(char *mex){
    char c;
    printf("%s",mex);
    fflush(stdin);
    scanf("%c",&c);
    while(c == '\0'){
        err();
        printf("%s",mex);
        fflush(stdin);
        scanf("%c",&c);
    }
    return c;
}

void lgStr(char *s, char *mex){
    printf("%s", mex);
    fflush(stdin);
    gets(s);
    while(strcmp(s, "") == 0){
        err();
        printf("%s", mex);
        fflush(stdin);
        gets(s);
    }
}

void menu(){
    printf("1) Importazione catalogo;\n");
    printf("2) Stampa catalogo;\n");
    printf("3) Valore economico totale;\n");
    printf("4) Dato ID, stampa dati;\n");
    printf("5) Dato ID, modifica costo;\n");
    printf("6) Esporta i videogiochi con una data la classificazione;\n");
    printf("0) Termina programma;\n");
}

void err(){
    printf("Errore\n");
}
