// StackTest.java
// Linked list implementation of Stack

class Stack {
    
    class Node {
        int data;
        Node next;  
    }
    private Node top;
      
    public Stack()
    { 
        top = null;
    }
        
    public void push(int x) {
        Node  t = new Node();
        if(t == null) {
            System.out.println("\nHeap Overflow");
            return;
        }
        t.data = x;
        t.next = top;
        top = t;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if(!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // pop() method here
    // only to be called if list is non-empty.
    // Otherwise an exception should be thrown.
    public void pop() {
        //check for stack overflow
        if(top == null) {
            System.out.println("\nStack Overflow. Exceeded...!!!!");
            return;
        }

        //update the top pointer to point to the next node
        top = (top).next;


    }
       


    public void display() {
        Node t = top;     
        System.out.println("\nStack contents are:  ");
        
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }        
        System.out.println("\n");
    }

}


public class StackTest
{
    public static void main( String[] arg){
        Stack s = new Stack();
        //Console.Write("Stack is created\n");
        System.out.println("Stack is created");
        
        s.push(10); 
        s.push(3); 
        s.push(11); 
        s.push(7);
        s.display();
        
        System.out.printf("\nTop element is %d\n", s.peek());
        
        
        
        // System.out.println("Just popped " + );
        s.display();
    }
}


