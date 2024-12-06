/*
    Realizzare la classe Coda di oggetti di tipo Tocket(come esercizio di allenamento
    sull'uso di arrayList o LinkedList, decidete voi quale è meglio) che esponga i seguenti
    metodi: pop, push, isEmpty, isFull, getLast. Produrre anche l'UML associato.
    Postare il tutto su OneNote.
*/
public class Main {
    public static void main(String[] args) {
        Coda coda;
        coda = new Coda(3);
        System.out.println("Vuota: " + coda.isEmpty());
        try{
            for(int k = 1; k < 5; k++)
                coda.push(k);
        }
        catch(IllegalStateException exc){
            System.out.println(exc.getMessage());
        }
        System.out.println("Dimensione: " + coda.getSize());
        System.out.println("Piena: " + coda.isFull());
        try{
            for(int k = 0; k < 4; k++)
                System.out.println(coda.pop().getNum());
        }
        catch(IllegalStateException exc){
            System.out.println(exc.getMessage());
        }
    }
}