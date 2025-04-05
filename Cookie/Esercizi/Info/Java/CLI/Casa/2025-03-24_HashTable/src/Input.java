import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/// Classe che gestisce vari metodi di input
public class Input {
    /// Metodo di lettura di un intero compreso fra vmin e vmax (estremi inclusi), con mex di prompt
    /// @param vmin Valore minimo
    /// @param vmax Valore massimo
    /// @param mex Messaggio di prompt
    /// @return Valore intero compreso fra vmin e vmax
    public static int lgInt(int vmin, int vmax, String mex)
    {
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

    /// Metodo di lettura di un double compreso fra vmin e vmax (estremi inclusi), con mex di prompt
    /// @param vmin Valore minimo
    /// @param vmax Valore massimo
    /// @param mex Messaggio di prompt
    /// @return Valore double compreso fra vmin e vmax
    public static double lgDbl(double vmin, double vmax, String mex)
    {
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

    /// Metodo di lettura di un char, con mex di prompt
    /// @param mex Messaggio di prompt
    /// @return Carattere letto
    public static char lgChar(String mex)
    {
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

    /// Metodo di lettura di una String, con mex di prompt
    /// @param mex Messaggio di prompt
    /// @return Stringa letta
    public static String lgStr(String mex)
    {
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

    /// Scrittura di una Stringa str lunga len su Random Access File raf
    /// @param raf Random Access File su cui scrivere
    /// @param str Stringa da scrivere
    /// @param len Lunghezza della stringa da scrivere
    /// @throws IOException Errore durante le operazioni di IO
    public static void writeString(RandomAccessFile raf, String str, int len)
            throws IOException
    {
        StringBuilder buf = new StringBuilder(str);
        buf.setLength(len);
        raf.writeChars(buf.toString());
    }

    /// Lettura di una Stringa lunga len da Random Access File raf
    /// @param raf Random Access File da cui leggere
    /// @param len Lunghezza della stringa da leggere
    /// @throws IOException Errore durante le operazioni di IO
    /// @return Stringa letta dal Random Access File
    public static String readString(RandomAccessFile raf, int len)
            throws IOException
    {
        char[] str = new char[len];
        for(int k = 0; k < len; k++)
            str[k] = raf.readChar();

        String s = new String(str);
        return s.trim();
    }
}
