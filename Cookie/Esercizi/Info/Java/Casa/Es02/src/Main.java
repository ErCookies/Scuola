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