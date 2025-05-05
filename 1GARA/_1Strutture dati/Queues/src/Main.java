import java.util.Queue;
import java.util.LinkedList;

public class Main{

    public static void main(String[] args) {


        // *****************************************************

        // Queue = FIFO data structure. First-In First-Out

        //		   A collection designed for holding elements prior to processing
        //		   Linear data structure

        //         enqueue = offer()
        //         dequeue = poll()

        // Where are queues useful?

        // 1. Keyboard Buffer (letters should appear on the screen in the order they're pressed)
        // 2. Printer Queue (Print jobs should be completed in order)
        // 3. Used in LinkedLists, PriorityQueues, Breadth-first search

        // *****************************************************

        Queue<String> queue = new LinkedList<String>();

        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        //System.out.println(queue.isEmpty());
        //System.out.println(queue.size());
        //System.out.println(queue.contains("Harold"));



        //System.out.println(queue.peek());
        //queue.poll();
        //queue.poll();
        //queue.poll();
        //queue.poll();

        System.out.println(queue);

    }
}

//Queue<OBJ> queue = new LinkedList<>(); le queue sono interface, quindi non possono essere istanziate, usiamo LinkedList
//queue.offer(OBJ);  aggiungo un elemento in fondo alla coda
//queue.poll(OBJ); tiro fuori il primo elemento della lista
//queue.peek(); vedo il primo elemento della lista