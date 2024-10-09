#include "header.h"

/*
    DESCRIZIONE FILE .csv:
    il file f.csv conterra' un elemento per riga, con i dati separati da un ';'

    DESCRIZIONE VARIABILI:
    |

    PSEUDOCODIFICA:
    INIZIO
        first = NULL
        apri il file nf come f (input)
        se f esiste
        allora
            leggi la prima riga dal file f in str
            mentre il file non e' finito
                spezzo str nei suoi item
                assegno il primo item a car.tar
                ricerco car.tar nella lista e ritorno true in tro se trovato altrimenti false
                se !tro
                allora
                    assegno il secondo e terzo item a car.mod e .tipo
                    verifico che car.tipo sia corretto e ritorno true in cor se corretto, altrimenti false
                    se cor
                    allora
                        assegno il quarto item a car.prc
                        se car.prc > 0
                        allora
                            assegno l'ultimo item a car.km
                            se car.km
                        fse
                    fse
                fse
            fciclo
        altrimenti
            errore
        fse
    FINE
*/
TNodo* imp(TNodo* first, char *nf){
    FILE* f = fopen(nf, "r");
    if(f != NULL){
        size_t dim = sizeof(TNodo);
        char str[LEN];
        bool tro, cor;
        fgets(str,LEN,f);
        while(!feof(f)){
            TAuto car;
            strcpy(car.tar, strtok(str,";"));
            tro = ricTar(first, car.tar);
            if(!tro){
                strcpy(car.mod, strtok(NULL,";"));
                strcpy(car.tipo, strtok(NULL,";"));
                cor = ricTipo(first,car.tipo);
                if(cor){
                    car.prc = atof(strtok(NULL,";"));
                    if(car.prc > 0){
                        car.km = atoi(strtok(NULL,";"));
                        if(car.km > 0){
                            TNodo* el = (TNodo*)malloc(dim);
                            el->car = car;
                            if(first == NULL){
                                first = el;
                                el->next = NULL;
                            }
                            else{
                                el->next = first;
                                first = el;
                            }
                        }
                    }
                }
            }
            fgets(str,LEN,f);
        }
    }
    else
        err();
    return first;
}

bool ricTar(TNodo *f, char *elTar){
    bool tro = false;
    TNodo* p = f;
    while(p != NULL && tro == false){
        if(strcmp(elTar, p->car.tar) == 0)
            tro  = true;
        p = p->next;
    }
    return tro;
}

bool ricTipo(TNodo *f, char *elTipo){
    bool cor = true;
    TNodo* p = f;
    while(p != NULL && cor == true){
        if(strcmp(elTipo, "Utilitaria") != 0 && strcmp(elTipo, "Lusso") != 0 && strcmp(elTipo, "Comfort") != 0)
            cor  = false;
        p = p->next;
    }
    return cor;
}

void stampa(TNodo *f){
    if(f != NULL){
        TNodo* el = f;
        while(el != NULL){
            stampaEl(el);
            el = el->next;
        }
    }
    else
        printf("Importa prima i dati\n");
}

void stampaEl(TNodo *el){
    printf("Targa: %s | ", el->car.tar);
    printf("Modello: %s | ", el->car.mod);
    printf("TIpologia: %s | ", el->car.tipo);
    printf("Prezzo al giorno: %.2f | ", el->car.prc);
    printf("Kilometraggio: %d\n", el->car.km);
}

void stampaTar(TNodo *f){
    if(f != NULL){
        char ausTar[CTAR];
        lgStr(ausTar, "Inserire targa auto interessata: ");
    }
    else
        printf("Importa prima i dati\n");
}