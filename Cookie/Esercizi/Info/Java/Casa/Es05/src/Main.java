/*
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