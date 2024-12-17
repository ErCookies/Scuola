/*
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