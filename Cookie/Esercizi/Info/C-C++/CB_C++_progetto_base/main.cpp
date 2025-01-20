#include "header.h"

int main()
{
    int sc;
    do{
        menu();
        sc = lgInt(1,5,"Inserire funzione interessata: ");
        switch(sc){
            case 1:{
                //procedura
                break;
            }
            case 2:{
                //procedura
                break;
            }
            case 3:{
                //procedura
                break;
            }
            case 4:{
                //procedura
                break;
            }
            case 0:{break;}
        }
    }while(sc!=0);
    return 0;
}