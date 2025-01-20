#include "header.h"

int lgInt(int xmin, int xmax, string mex){
    int x;
    cout<<mex;
    cin>>x;
    while(x<xmin||x>xmax){
        err();
        cout<<mex;
        cin>>x;
    }
    return x;
}

float lgFlt(float xmin, float xmax, string mex){
    float x;
    cout<<mex;
    cin>>x;
    while(x<xmin||x>xmax){
        err();
        cout<<mex;
        cin>>x;
    }
    return x;
}

double lgDbl(double xmin, double xmax, string mex){
    double x;
    cout<<mex;
    cin>>x;
    while(x<xmin||x>xmax){
        err();
        cout<<mex;
        cin>>x;
    }
    return x;
}

char lgChar(string mex){
    char x;
    cout<<mex;
    cin.ignore()>>x;
    while(x=='\0'){
        err();
        cout<<mex;
        cin.ignore();
        cin>>x;
    }
    return x;
}

string lgStrS(string mex){
    string s;
    cout<<mex;
    getline(cin.ignore(),s);
    while(s==""){
        err();
        cout<<mex;
        getline(cin.ignore(),s);
    }
    return s;
}

void lgStrC(char *s, string mex){
    cout<<mex;
    fflush(stdin);
    gets(s);
    while(s[0]=='\0'){
        err();
        cout<<mex;
        fflush(stdin);
        gets(s);
    }
}

void srt(string *s, int n){
    for(int k=0;k<n-1;k++)
        for(int j=k+1;j<n;j++)
            if(s[k]>s[j])
                swcS(s[k],s[j]);
}

void swcI(int &x1, int &x2){
    int aus = x1;
    x1 = x2;
    x2 = aus;
}

void swcF(float &x1, float &x2){
    float aus = x1;
    x1 = x2;
    x2 = aus;
}

void swcD(double &x1, double &x2){
    double aus = x1;
    x1 = x2;
    x2 = aus;
}

void swcC(char &x1, char &x2){
    char aus = x1;
    x1 = x2;
    x2 = aus;
}

void swcS(string &x1, string &x2){
    string aus = x1;
    x1 = x2;
    x2 = aus;
}

int ricUni(string el, string *v, int n){
    int pos = -1;
    for(int k=0;k<n && pos==-1;k++)
        if(el == v[k])
            pos = k;

    return pos;
}

int ricBinStr(string el, string *v, int n){
    int pos = -1;
    int c;
    int i = 0;
    int f = n-1;
    while(pos==-1 && i<=f){
        c = (int)(i+f)/2;
        if(el == v[c])
            pos = c;
        else{
            if(el > v[c])
                i = c+1;
            else
                f = c-1;
        }
    }
    return pos;
}

int ricBinChar(char* el, string *v, int n){
    int pos = -1;
    int c;
    int i = 0;
    int f = n-1;
    while(pos==-1 && i<=f){
        c = (int)(i+f)/2;
        if(strcmp(el,v[c].c_str())==0)
            pos = c;
        else{
            if(strcmp(el,v[c].c_str())>0)
                i = c+1;
            else
                f = c-1;
        }
    }
    return pos;
}

void err(){
    cout<<"Errore"<<endl;
}

void menu(){
    cout<<"1) ;"<<endl;
    cout<<"2) ;"<<endl;
    cout<<"3) ;"<<endl;
    cout<<"4) ;"<<endl;
    cout<<"0) Termina il programma."<<endl;
}

void sep(){
    cout<<"----------------------------------------"<<endl;
}
