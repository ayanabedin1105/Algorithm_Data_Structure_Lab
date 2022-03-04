
// Sorted linked list with a sentinel node
// Skeleton code
import java.util.Scanner;

class SortedLL
{
    // internal data structure and
    // constructor code to be added here
    class Node {
        int data;
        Node next;

        public Node(int x){
            this.data = x;
        }
    }
    Node head, z;

    public SortedLL() {
        z= new Node(-1);
        z.next = z;
        head = z;
    }
    
   
    
    
    // this is the crucial method
    public void insert(int x)
    {
        Node prev, curr, t;

        t = new Node(x);
        curr = head;
        prev = null;
        z.data = x;
        while(x > curr.data) {
            prev = curr;
            curr = curr.next;
        } 

        t.next = curr;
        if (curr == head) {
           head = t;
        }
        else {
            prev.next = t;
        }
          
             
    }    
    
    /*
    public boolean remove(int x) {
        Node prev, curr;
        
            }
    
    public boolean isEmpty() {
        
    }
    */
    
    public void display()
    {
        Node t = head;
        System.out.print("\nHead -> ");
        while( t != z) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("Z\n");
    }
    
    public static void main(String args[])   
    {
        SortedLL list = new SortedLL();
        //list.display();
        
        double x;
        int i, r;
        
        
           for(i = 1; i <= 5; ++i)  {
           x =  (Math.random()*100.0);
           r = (int) x; 
           System.out.println("Inserting " + r);
           list.insert(r);
           list.display();            
        }
        
        
        /*
        while(!list.isEmpty())  {
            System.out.println("\nInput a value to remove: ");
            Scanner in = new Scanner(System.in);
            r = in.nextInt();
            if(list.remove(r)) {
                System.out.println("\nSuccessfully removed: " + r);
            list.display(); }
            else System.out.println("\nValue not in list");                        
        }
        */
    }
}