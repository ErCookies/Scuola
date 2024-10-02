#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LEN 32

char* myStrConcat(char *s1, char *s2);
int length(char *s);
void lgStr(char *s, char *mex);
void err();

int main()
{
    char s1[LEN], s2[LEN];
    lgStr(s1,"Inserire prima stringa: ");
    lgStr(s2,"Inserire seconda stringa: ");
    printf("Stringhe concatenate: %s\n", myStrConcat(s1,s2));
}

int length(char *s){
    int n = 0;
    while(*(s+n) != '\0')
        n++;
    return n;
}

char* myStrConcat(char *s1, char *s2){
    int d1 = length(s1);
    int d2 = length(s2);
    size_t dim = d1 + d2 + 1;
    char* strCon = (char*)malloc(dim);
    int k, j;
    for(k = 0; k<d1; k++){
       *(strCon + k) = *(s1 + k);
    }
    for(j = 0; j<d2; j++){
        *(strCon + k + j) = *(s2 + j);
    }
    *(strCon + k + j) = '\0';

    return strCon;
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

void err(){
    printf("Errore\n");
}