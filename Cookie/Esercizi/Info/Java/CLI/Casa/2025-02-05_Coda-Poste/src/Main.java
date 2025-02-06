/*
    Cucchi Francesco    4BI
    TESTO:
    Gestione di una coda per o sportello di un ufficio postale in cui esistono code
    di tipo diverso ed in cui ogni push avviene determinando il numero del ticket da
    stampare per l'utente come concatenazione di nome della coda + numero progressivo autoincrementante.
*/

public class Main {
    public static void main(String[] args) {
        int sc;
        MyList<MyList<Ticket>> code = new MyList<>("Code");
        code.addLast(new MyList<>("A"));
        code.addLast(new MyList<>("B"));
        code.addLast(new MyList<>("C"));

        do{
            menu();
            sc = Input.lgInt(0,5,"Inserire funzione interessata: ");
            switch(sc){
                case 1:
                case 2:
                case 3:{
                    insert(code.get(sc - 1), code.get(sc - 1).getName());
                    break;
                }
                case 4:{
                    printTurn(code);
                    break;
                }
                case 5:{
                    printAll(code);
                    break;
                }
                case 0:{ break; }

            }
        }while(sc != 0);
    }

    static public void insert(MyList<Ticket> coda, String name){
        try{
            coda.addLast(new Ticket(coda.getLast().getNum() + 1, name));
        }
        catch(IllegalStateException e){
            coda.addLast(new Ticket(name));
        }
    }

    // La politica di gestione che ho immaginato implica l'estrazione un elemento dalla coda  con il maggior numero di essi.
    // Nel caso due o piu' siano pari, verra' "scelta" la prima lista che incontro nella ricerca.
    static public void printTurn(MyList<MyList<Ticket>> code){
        try{
            int maxSize = code.get(0).size();
            int index = 0;
            for(int k = 1; k < code.size(); k++){
                if(code.get(k).size() > maxSize){
                    maxSize = code.get(k).size();
                    index = k;
                }
            }
            System.out.println("Tocca a: " + code.get(index).remove().toStr());
        }
        catch(IllegalStateException e){
            System.out.println("Tutte le code sono vuote");
        }
    }

    static public void printAll(MyList<MyList<Ticket>> code){
        for(int k = 0; k < code.size(); k++){
            if(code.get(k).size() > 0){
                System.out.println(code.get(k).getName() + ":");
                System.out.println(code.get(k).toStr());
            }
            else
                System.out.println("Coda " + code.get(k).getName() + " vuota\n");
        }
    }

    static public void menu(){
        System.out.println("1) Inserisci in coda A;");
        System.out.println("2) Inserisci in coda B;");
        System.out.println("3) Inserisci in coda C;");
        System.out.println("4) Stampa a chi tocca;");
        System.out.println("5) Stampa interamente code;");
        System.out.println("0) Termina il programma;");
    }
}