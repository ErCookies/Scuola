/*
    Cucchi Francesco    4BI

    TESTO:
    Realizzazione programma che preveda di gestire un RandomAccessFile su cui memorizzare oggetti di tipo Automobile
    (targa, marca, modello, cilindrata (float), anno immatricolazione (int), prezzo (float), alimentazione (1 char)).
    Il programma prevede un menu a 2 voci: inserimento di una nuova automobile nel file, visualizzazione di tutte le
    automobili inserite. (note: la classe Automobile deve implementare interface IOFileRandom ed il metodo toString
    che permette di ottenenere una stringa stampabile a monitor).
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {
        try{
            RandomAccessFile file = new RandomAccessFile("car.dat", "rw");
            int sc;
            do{
                menu();
                sc = Input.lgInt(0, 2, "Inserire funzione desiderata: ");
                switch(sc){
                    case 1:{
                        ins(file);
                        break;
                    }
                    case 2:{
                        readAll(file);
                        break;
                    }
                    case 0:{ break; }

                }
            }while(sc != 0);
        }
        catch(IOException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void ins(RandomAccessFile file) throws IOException{
        file.seek(file.length());
        Macchina car = new Macchina(
                Input.lgChar("Inserire alimentazione: "),
                Input.lgInt(0, Integer.MAX_VALUE, "Inserire cilindrata: "),
                Input.lgStr("Inserire marca: "),
                Input.lgStr("Inserire modello: "),
                Input.lgDbl(0, Double.MAX_VALUE, "Inserire prezzo: "),
                Input.lgStr("Inserire targa: "),
                Input.lgInt(1900, Integer.MAX_VALUE, "Inserire anno: ")
        );
        car.write(file);
    }

    public static void readAll(RandomAccessFile file)throws IOException{
        if(file.length() == 0) {
            System.out.println("Nessun'auto salvata");
        }
        else{
            Macchina car = new Macchina();
            file.seek(0);
            while(file.getFilePointer() < file.length()){
                car.read(file);
                System.out.println(car);
                // implicita la chiamata al metodo .toString()
            }
        }
    }

    public static void menu(){
        System.out.println("1) Inserire un'auto;");
        System.out.println("2) Vedere tutte le auto;");
        System.out.println("0) Termina il programma;");
    }
}