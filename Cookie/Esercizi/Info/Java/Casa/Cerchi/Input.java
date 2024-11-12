import java.util.Scanner;

public class Input {
    private Scanner in;
    ///costruttore
    public Input(){
        in = new Scanner(System.in);
    }

    public int intr(int vmin, int vmax, String mex){
        int x;
        System.out.print(mex);
        x = in.nextInt();
        while(x < vmin || x > vmax){
            System.out.println("Errore");
            System.out.print(mex);
            x = in.nextInt();
        }
        return x;
    }
    public double dbl(double vmin, double vmax, String mex){
        double x;
        System.out.print(mex);
        x = in.nextDouble();
        while(x < vmin || x > vmax){
            System.out.println("Errore");
            System.out.print(mex);
            x = in.nextDouble();
        }
        return x;
    }
    public char chr(String mex){
        String c;
        //c = new String();
        System.out.print(mex);
        c = in.next();
        while(c.isEmpty()){
        //while(c.charAt(0) == '\0'){
            System.out.println("Errore");
            System.out.print(mex);
            c = in.next();
        }
        return c.charAt(0);
    }
    public String str(String mex){
        String s;
        //s = new String();
        System.out.print(mex);
        s = in.next();
        while(s.isEmpty()){
        //while(s.charAt(0) == '\0'){
            System.out.println("Errore");
            System.out.print(mex);
            s = in.next();
        }
        return s;
    }

}
