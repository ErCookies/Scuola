#include "header.h"

struct TNodo* imp(struct TNodo *first, int *n){
    FILE* f = fopen("f.csv","r");
    if(f != NULL){
        size_t dim = sizeof(struct TNodo);
        char str[LEN];
        struct TNodo* p = (struct TNodo*) malloc(dim);
        fgets(str,LEN,f);
        while(!feof(f)){
            if(first == NULL){
                first = p;
                p->next = NULL;
                *n = 0;
            }
            else{
                p->next = first;
                first = p;
            }
            fgets(str,LEN,f);
        }
        //
    }
    else
        err();

    return 0;
}