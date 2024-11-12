/*
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