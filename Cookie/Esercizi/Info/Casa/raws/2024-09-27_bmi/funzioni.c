#include "header.h"

/*
    apri il file file.txt (input)
    se il file esiste
    allora
        leggi la prima riga
        k = 0
        mentre il file non e' finito
            assegna il primo elemento a v[k].w
            se v[k].w != 0
            allora
                assegna il secondo elemento a v[k].h
                n++
                leggi la riga successiva dal file
            fse
        fciclo
        chiudi il file f
    altrimenti
        errore
    fse
*/
TDati* imp(int *n){
    TDati* v = (TDati*) malloc(sizeof(TDati));
    FILE* f = fopen("file.txt", "r");
    if(f != NULL){
        int k;
        for(k = 0;!feof(f);k++){
            fscanf(f,"%f %f",&((v+k)->w),&((v+k)->h));
            (*n)++;
            v = realloc(v,sizeof(TDati)*((*n)+1));
        }
        fclose(f);
        stampaDati(v,*n);
    }
    else
        err();

    return v;
}

void stampaDati(TDati *v, int n){
    printf("Numero importati: %d\n",n);
    for(int k=0;k<n;k++){
        (v+k)->b = bmi(v+k);
        stampa(v+k);
        gestClasse(v+k);
    }
}
void stampa(TDati *v){
    printf("Peso: %.2f kg | Altezza: %.2f m | Indice bmi: %.2f | Classe: ", v->w, v->h, v->b);
}

float bmi(TDati *v){
    return (v->w)/pow(v->h,2);
}

void gestClasse(TDati *v){
    if(v->b <= 16.00)
        printf("Grave magrezza\n");
    else{
        if(v->b > 16.00 && v->b < 18.50)
            printf("Sottopeso\n");
        else{
            if(v->b >= 18.50 && v->b <25.00)
                printf("Normopeso\n");
            else{
                if(v->b >=25.00 && v->b < 30.00)
                    printf("Sovrappeso\n");
                else{
                    if(v->b >=30.00 && v->b < 35.00)
                        printf("Obeso classe 1\n");
                    else{
                        if(v->b >=35.00 && v->b <40.00)
                            printf("Obeso classe 2\n");
                        else
                            printf("Obeso classe 3\n");
                    }
                }
            }
        }
    }
}

/*
    se v != NULL
    allora
        scrivi "Numero importati: " n
        apri il file f (output)
        per ogni k<n
            se v[k].b > 16 && < 18.50
            allora
                scrivi nel file v[k].w .h .b
                expd++
            fse
        fciclo
        chiudi il file f
        scrivi "numero persone sottopeso: " expd
    altrimenti
        errore
    fse
*/
void espSP(TDati *v, int n){
    if(v != NULL){
        printf("Numero importati: %d\n",n);
        int expd = 0;
        FILE* f = fopen("sp.txt","w");
        for(int k = 0; k<n; k++){
            //printf("Iterazione numero %d\n",k);
            //stampa(v+k);
            printf("BMI: %.2f\n", (v+k)->b);
            if((v+k)->b > 16.00 && (v+k)->b < 18.50){
                fprintf(f,"%.2f %.2f %.2f\n",(v+k)->w,(v+k)->h,(v+k)->b);
                expd++;
            }
        //system("pause");
        }
        fclose(f);
        printf("Numero persone sottopeso: %d\n",expd);
    }
    else
        printf("Importa prima i dati\n");
}