/*
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