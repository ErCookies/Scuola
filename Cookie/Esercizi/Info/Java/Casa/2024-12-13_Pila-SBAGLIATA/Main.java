///CUCCHI FRANCESCO  4BI

public class Main {
    public static void main(String[] args) {
        int sc;
        Pila<Integer> pila;
        pila = new Pila<>(2);
        do{
            menu();
            sc = Input.lgInt(0,3,"Inserire funzione interessata: ");
            switch(sc){
                case 1:{
                    aggiunta(pila);
                    break;
                }
                case 2:{
                    calcolo(pila);
                    break;
                }
                case 3:{
                    System.out.println(pila.getLast().intValue());
                    break;
                }
                case 0: break;
            }
        }while(sc != 0);
    }

    public static void menu(){
        System.out.println("1) Aggiunta numero;");
        System.out.println("2) Calcolo fra 2 numeri;");
        System.out.println("3) Stampa ultimo numero;");
        System.out.println("0) Termina il programma;");
    }

    public static void aggiunta(Pila<Integer> pila){
        Integer n = Input.lgInt(0,9,"Inserire numero ad 1 cifra: ");
        try{
            pila.push(n);
        }
        catch(IllegalStateException | NullPointerException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void calcolo(Pila<Integer> pila){
        Integer x1, x2;
        int ris;
        char op;
        try{
            op = Input.lgChar("Inserire operazione ( + - * / ): ");
            while(op != '+' && op != '-' && op != '*' && op != '/'){
                System.out.println("Errore");
                op = Input.lgChar("Inserire operazione ( + - * / ): ");
            }
            x2 = pila.pop();
            x1 = pila.pop();
            ris = 0;
            switch(op){
                case '+':{
                    ris = x1 + x2;
                    break;
                }
                case '-':{
                    ris = x1 - x2;
                    break;
                }
                case '*':{
                    ris = x1 * x2;
                    break;
                }
                case '/':{
                    ris = x1 / x2;
                    break;
                }
            }
            pila.push(ris);
            System.out.println(pila.getLast().intValue());
        }
        // ArithmeticException viene lanciata automaticamente dalla divisione per 0
        catch(IllegalStateException | ArithmeticException exc){
            System.out.println(exc.getMessage());
        }

    }

}