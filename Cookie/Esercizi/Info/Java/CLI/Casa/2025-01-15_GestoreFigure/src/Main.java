/*
    Cucchi Francesco    4BI
    TESTO:
    Gestire quadrilateri e triangoli come elementi ereditati da classe figura e metodi comuni come stampa,
    area e perimetro.
    Realizzare un programma che gestisce n figure tramite classe GESTORE che possono essere o quadrilateri o
    triangoli (a scelta dell'utente) sui quali si possano fare le seguenti operazioni:
    1) inserimento;
    2) stampa dei dati delle figure inserite (se quadrilatero si stampa "quadrilatero+ lato1+lato2+area=.....+perimetro=...’’",
       se triangolo si stampa "triangolo+l1+l2+l3+area=....+perimetro=.....”,
    3) elenco delle aree di ogni figura in output si stampa “quadriatero: area=.....” se quadrilatero; “triangolo:area=....” se triangolo.
    Produrre classe GESTORE (con metodi add, toString ed elencoAree), la classe Figura e le classi Quadrilatero e Triangolo
    ed il main che realizzata I/O con utente e classe Gestore.
*/
public class Main {
    public static void main(String[] args) {
        Gestore ges = new Gestore();
        System.out.println(ges.getClass().toString());
        int sc;
        Figura f;
        do{
            menu();
            sc = Input.lgInt(0,3,"Inserire funzione interesstata: ");
            switch(sc){
                case 0: {break;}
                case 1: {
                    aggiunta(ges);
                    break;
                }
                case 2: {
                    System.out.println(ges);
                    break;
                }
                case 3: {
                    System.out.println(ges.elencoAree());
                    break;
                }
            }
        }while(sc != 0);
    }

    private static void aggiunta(Gestore ges) {
        char f;
        double l1, l2, l3, l4;
        boolean val = false;
        do{
            f = Input.lgChar("Desidera inserire un quadrilatero od un triangolo (q/t)? ");
            if(f == 'q'){
                try{
                    l1 = Input.lgDbl(0, Double.MAX_VALUE, "Inserire primo lato: ");
                    l2 = Input.lgDbl(0, Double.MAX_VALUE, "Inserire secondo lato: ");
                    l3 = Input.lgDbl(0, Double.MAX_VALUE, "Inserire terzo lato: ");
                    l4 = Input.lgDbl(0, Double.MAX_VALUE, "Inserire quarto lato: ");
                    ges.add(new Quadrilatero(l1, l2, l3, l4));
                    val = true;
                }
                catch(IllegalArgumentException exc){
                    System.out.println(exc.getMessage());
                }
            }
            else if(f == 't'){
                try{
                    l1 = Input.lgDbl(0, Double.MAX_VALUE, "Inserire primo lato: ");
                    l2 = Input.lgDbl(0, Double.MAX_VALUE, "Inserire secondo lato: ");
                    l3 = Input.lgDbl(0, Double.MAX_VALUE, "Inserire terzo lato: ");
                    ges.add(new Triangolo(l1, l2, l3));
                    val = true;
                }
                catch(IllegalArgumentException exc){
                    System.out.println(exc.getMessage());
                }
            }
            else
                System.out.println("Errore, reinserire: ");
        }while(f != 'q' && f != 't' && !val);

    }

    private static void menu(){
        System.out.println("1) Inserire una figura;");
        System.out.println("2) Stampa tutti i dati delle figure inserite;");
        System.out.println("3) Stampa le aree delle figure inserite;");
        System.out.println("0) Termina il programma;");
    }
}