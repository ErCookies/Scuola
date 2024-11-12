/*
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