///CUCCHI FRANCESCO  4BI
/*
    Realizzare la classe PILA (finita o infinita) su tipo Generico T
    (con lancio di eccezioni per le situazioni di errore e SENZA I/O interni) che
    abbia i seguenti metodi pubblici:
    a) costruttori
    b) push
    c) pop
    d) size
    e) isEmpty e isFull
    Realizzare il main che permetta di risolvere la seguente espressione
    (con numeri ad 1 sola cifra) matematica in notazione postfissa 56+7-4*
*/

public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila;
        String expr;
        char oper;
        Integer x1, x2;
        pila = new Pila<>(2);
        expr = Input.lgStr("Inserire operazione: ");
        pila.push(Character.getNumericValue(expr.charAt(0)));
        for(int k = 1; k < expr.length(); k += 2){
            pila.push(Character.getNumericValue(expr.charAt(k)));
            oper = expr.charAt(k + 1);
            x2 = pila.pop();
            x1 = pila.pop();

            System.out.println("Operazione corrente: " + x1 + oper + x2);

            switch(oper){
                case '+':{
                    pila.push(x1 + x2);
                    break;
                }
                case '-':{
                    pila.push(x1 - x2);
                    break;
                }
                case '*':{
                    pila.push(x1 * x2);
                    break;
                }
                case '/':{
                    pila.push(x1 / x2);
                    break;
                }
            }
        }
        System.out.println("Risultato finale: " + pila.pop());
    }
}