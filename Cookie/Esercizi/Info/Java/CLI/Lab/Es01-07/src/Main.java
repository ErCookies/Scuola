/*
    ES01
    Sul prezzo di un prodotto viene praticato uno sconto del 20% se costa meno di 500€
    e del 25% per prezzi superiori a 500€. Calcolare il prezzo da pagare.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double sconto1 = 0.2;
        final double sconto2 = 0.25;
        Scanner input = new Scanner(System.in);
        double prc, prcFinale;
        System.out.print("Inserire prezzo: ");
        prc = input.nextDouble();
        if(prc <= 500)
            prcFinale = prc * (1-sconto1);
        else
            prcFinale = prc * (1-sconto2);
        System.out.println("Prezzo finale: " + prcFinale);
    }
}

//-------------------------------------------------
//ES02
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int temp;
        System.out.print("Inserire temperatura: ");
        temp = input.nextInt();
        if(temp < 0)
            System.out.println("Molto freddo");
        else if(temp < 10)
            System.out.println("Freddo");
        else if(temp < 16)
            System.out.println("Fresco");
        else if(temp < 25)
            System.out.println("Clima mite");
        else if(temp < 32)
            System.out.println("Caldo");
        else
            System.out.println("Molto caldo");
    }
}

//-------------------------------------------------
/*
    ES03
    L'indice di massa corporea si calcola dividendo il proprio peso espresso in kg per il quadrato dell'altezza
    espressa in metri: IMC = massa corporea / altezza2.
    Secondo l'Organizzazione Mondiale della Sanità l'IMC, o indice di massa corporea,
    raggruppabile in 4 categorie: sottopeso (IMC al di sotto di 19), normale (IMC compreso tra 19 e 24),
    sovrappeso (IMC compreso tra 25 e 30), obesità (IMC al di sopra di 30).
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double wgt, hgt, imc;
        System.out.print("Inserire peso (in kg): ");
        wgt = input.nextDouble();
        System.out.print("Inserire altezza (in m): ");
        hgt = input.nextDouble();
        imc = wgt / Math.pow(hgt,2);
        System.out.println("Imc: " + imc);
        if(imc < 19)
            System.out.println("Sottopeso");
        else if(imc < 24)
            System.out.println("Normale");
        else if(imc < 30)
            System.out.println("Sovrappeso");
        else
            System.out.println("Obeso");
    }
}

//-------------------------------------------------
/*
    ES04
    Scrivi un algoritmo che legga una sequenza di voti (tra 1 e 10). Quando viene inserito 0, viene stampata la
    media dei voti inseriti.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int voto, tot = 0, num = 0;
        float media;
        System.out.print("Inserire voto (0 per uscire): ");
        voto = input.nextInt();
        while(voto != 0){
            tot += voto;
            num++;
            System.out.print("Inserire voto (0 per uscire): ");
            voto = input.nextInt();
        }
        if(num > 0){
            media = (float) tot/num;
            System.out.println("Media: " + media);
        }
        else
            System.out.println("Nessun voto inserito");
    }
}

//-------------------------------------------------
/*
    ES05
    Leggere una sequenza di numeri interi. Terminare la lettura quando si incontra un valore pari a 9999.
    Determinare quanti sono stati i valori pari e i valori dispari.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, cP = 0, cD = 0;
        System.out.print("Inserire numero (9999 per uscire): ");
        n = input.nextInt();
        while(n != 9999){
            if(n % 2 == 0)
                cP++;
            else
                cD++;
            System.out.print("Inserire numero (9999 per uscire): ");
            n = input.nextInt();
        }
        if(cP != 0 || cD != 0){
            System.out.println("Pari: " + cP);
            System.out.println("Dispari: " + cD);
        }
        else
            System.out.println("Nessun numero inserito");
    }
}

//-------------------------------------------------
/*
    ES06
    Crea un programma organizzato a menu che permette di calcolare le aree di figure geometriche:
    triangolo, rettangolo, rombo, trapezio, cerchio, poligono regolare.
    Vincolo: utilizzare una funzione per ciascuna funzionalità.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sc;
        do{
            menu();
            sc = lgInt(0,6,"Inserire scelta: ");
            switch(sc){
                case 1:{
                    triangolo();
                    break;
                }
                case 2:{
                    rettangolo();
                    break;
                }
                case 3:{
                    rombo();
                    break;
                }
                case 4:{
                    trapezio();
                    break;
                }
                case 5:{
                    cerchio();
                    break;
                }
                case 6:{
                    poligonoReg();
                    break;
                }
            }
        }while(sc != 0);
    }

    public static void menu(){
        System.out.println("Figure di cui calcolare l'area:");
        System.out.println("1) Triangolo;");
        System.out.println("2) Rettangolo;");
        System.out.println("3) Rombo;");
        System.out.println("4) Trapezio;");
        System.out.println("5) Cerchio;");
        System.out.println("6) Poligono regolare;");
        System.out.println("0) Termina il programma.");
    }

    public static void triangolo(){
        double base, hgt;
        base = lgDbl(1, Double.MAX_VALUE, "Inserire base: ");
        hgt = lgDbl(1, Double.MAX_VALUE, "Inserire altezza: ");
        System.out.println("Area: " + (base*hgt)/2);
    }

    public static void rettangolo(){
        double base, hgt;
        base = lgDbl(1, Double.MAX_VALUE, "Inserire base: ");
        hgt = lgDbl(1, Double.MAX_VALUE, "Inserire altezza: ");
        System.out.println("Area: " + base*hgt);
    }

    public static void rombo(){
        double dMag, dMin;
        dMag = lgDbl(1, Double.MAX_VALUE, "Inserire diagonale maggiore: ");
        dMin = lgDbl(1, Double.MAX_VALUE, "Inserire diagonale minore: ");
        System.out.println("Area: " + (dMag*dMin)/2);
    }

    public static void trapezio(){
        double bMag, bMin, hgt;
        bMag = lgDbl(1, Double.MAX_VALUE, "Inserire base maggiore: ");
        bMin = lgDbl(1, Double.MAX_VALUE, "Inserire base minore: ");
        hgt = lgDbl(1, Double.MAX_VALUE, "Inserire altezza: ");
        System.out.println("Area: " + (bMag+bMin)*hgt/2);
    }

    public static void cerchio(){
        double r;
        r = lgDbl(1, Double.MAX_VALUE, "Inserire raggio: ");
        System.out.println("Area: " + Math.pow(r,2)*Math.PI);
    }

    public static void poligonoReg(){
        double per, apo;
        per = lgDbl(1, Double.MAX_VALUE, "Inserire perimetro: ");
        apo = lgDbl(1, Double.MAX_VALUE, "Inserire apotema: ");
        System.out.println("Area: " + per*apo/2);
    }

    public static int lgInt(int vmin, int vmax, String mex){
        int x;
        System.out.print(mex);
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        while(x<vmin || x>vmax){
            System.out.println("Errore");
            System.out.print(mex);
            x = sc.nextInt();
        }
        return x;
    }

    public static double lgDbl(double vmin, double vmax, String mex){
        double x;
        System.out.print(mex);
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        while(x<vmin || x>vmax){
            System.out.println("Errore");
            System.out.print(mex);
            x = sc.nextDouble();
        }
        return x;
    }
}

//-------------------------------------------------
/*
    ES07
    Scrivi una funzione che dati due punti A e B, restituisce la misura della distanza tra A e B.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x1, x2, y1, y2;
        x1 = lgDbl(Double.MIN_VALUE, Double.MAX_VALUE, "Inserire x del primo punto: ");
        y1 = lgDbl(Double.MIN_VALUE, Double.MAX_VALUE, "Inserire y del primo punto: ");
        x2 = lgDbl(Double.MIN_VALUE, Double.MAX_VALUE, "Inserire x del secondo punto: ");
        y2 = lgDbl(Double.MIN_VALUE, Double.MAX_VALUE, "Inserire y del secondo punto: ");
        System.out.println("Distanza: " + dist(x1, x2, y1, y2));
    }

    public static double dist(double x1, double x2, double y1, double y2){
        double dist;
        dist = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return dist;
    }

    public static double lgDbl(double vmin, double vmax, String mex){
        double x;
        System.out.print(mex);
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        while(x<vmin || x>vmax){
            System.out.println("Errore");
            System.out.print(mex);
            x = sc.nextDouble();
        }
        return x;
    }
}