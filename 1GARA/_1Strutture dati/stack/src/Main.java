import java.util.Stack;



public class Main {


    public static void main(String[] args) {

        // *****************************************************

        // stack = LIFO data structure. Last-In First-Out
        //               stores objects into a sort of "vertical tower"
        //     	  push() to add objects to the top
        //		  pop() to remove objects from the top

        // uses of stacks?
        // 1. undo/redo features in text editor
        // 2. moving back/forward through browser history
        // 3. backtracking algorithms (maze, file directories)
        // 4. calling functions (call stack)

        // *****************************************************

        Stack<String> stack = new Stack<>();

        //System.out.println(stack.empty());

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Borderlands");
        stack.push("FFVII");

        //String myFavGame = stack.pop();
        //System.out.println(stack.peek());
        System.out.println(stack.search("Minecraft"));

        System.out.println(stack.peek());

    }
}

//Stack<OBJ> stack = new Stack<>();  Crea lo stack di OBJ
//stack.push(OBJ);  Aggiunge un elemento OBJ allo stack in fondo
//stack.pop(OBJ); Tira fuori l'ultimo elemento dello stack, returnando l'elemento in questione
//stack.peek(); Returna l'ultimo elemento dello stack
//stack.search(); Returna la posizione dell'elemento al contrario