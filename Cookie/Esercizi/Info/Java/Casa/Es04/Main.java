/*
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