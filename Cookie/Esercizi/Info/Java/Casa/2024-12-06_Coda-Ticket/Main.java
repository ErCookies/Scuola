/*
    Realizzare la classe Coda di oggetti di tipo Tocket(come esercizio di allenamento
    sull'uso di arrayList o LinkedList, decidete voi quale è meglio) che esponga i seguenti
    metodi: pop, push, isEmpty, isFull, getLast. Produrre anche l'UML associato.
    Postare il tutto su OneNote.

    Realizzare il programma che , usando la classe Coda, implementi la coda di uno sportello all'ufficio postale:
    a) arrivo di una nuova persona (nuovo ticket, numero da determinare)
    b) accesso di una persona allo sportello (visualizzare numero ticket)
    Postare il tutto su OneNote.
*/
public class Main {
    public static void main(String[] args) {
        int sc;
        Coda coda;
        coda = insDati();
        do{
            menu();
            sc = Input.lgInt(0,2,"Selezionare funzione interessata: ");
            switch(sc){
                case 1:{
                    arrivo(coda);
                    break;
                }
                case 2:{
                    visualizzazione(coda);
                    break;
                }
                case 0: break;
            }
        }while(sc != 0);
    }

    public static Coda insDati(){
        Coda coda;
        int nmax;
        nmax = Input.lgInt(1, Integer.MAX_VALUE, "Inserire numero persone massimo: ");
        coda = new Coda(nmax);
        return coda;
    }

    public static void arrivo(Coda coda){
        try{
            coda.push();
        }
        catch(IllegalStateException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void visualizzazione(Coda coda){
        try{
            System.out.println(coda.pop().getNum());
        }
        catch(IllegalStateException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void menu(){
        System.out.println("1) Registrazione ticket;");
        System.out.println("2) Visualizza a chi tocca;");
        System.out.println("0) Termina il programma;");
    }
}