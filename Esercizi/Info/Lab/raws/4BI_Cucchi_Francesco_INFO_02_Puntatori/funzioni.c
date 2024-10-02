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