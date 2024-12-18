import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static int lgInt(int vmin, int vmax, String mex){
        Scanner in = new Scanner(System.in);
        int x = 0;
        boolean val = false;
        while(!val){
            try {
                System.out.print(mex);
                x = in.nextInt();
                while (x < vmin || x > vmax) {
                    System.out.println("Errore");
                    System.out.print(mex);
                    x = in.nextInt();
                }
                val = true;
            } catch (InputMismatchException exc) {
                System.out.println(exc.getMessage());
                in.nextLine();
            }
        }
        return x;
    }

    public static double lgDbl(double vmin, double vmax, String mex){
        Scanner in = new Scanner(System.in);
        double x = 0;
        boolean val = false;
        while(!val){
            try {
                System.out.print(mex);
                x = in.nextDouble();
                while (x < vmin || x > vmax) {
                    System.out.println("Errore");
                    System.out.print(mex);
                    x = in.nextDouble();
                }
                val = true;
            } catch (InputMismatchException exc) {
                System.out.println(exc.getMessage());
                in.nextLine();
            }
        }
        return x;
    }

    public static char lgChar(String mex){
        Scanner in = new Scanner(System.in);
        char c;
        System.out.print(mex);
        c = in.next().charAt(0);
        while(c == '\0'){
            System.out.println("errore");
            System.out.print(mex);
            c = in.next().charAt(0);
        }
        return c;
    }

    public static String lgStr(String mex){
        Scanner in = new Scanner(System.in);
        String s;
        System.out.print(mex);
        s = in.next();
        while(s.isEmpty()){
            System.out.println("Errore");
            System.out.print(mex);
            s = in.next();
        }
        return s;
    }
}
