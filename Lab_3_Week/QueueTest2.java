// Exercise to separate ADT Queue from its implementation
// and to provide 2 implementations. Also exception handling.

class QueueException extends Exception {
    // do as in stack example
}    

// In Java an interface can often be the best way to 
// describe an Abstract Data Type (ADT) such as Queue or Stack
interface Queue {
    public void enQueue(int x) throws QueueException;
    public int deQueue() throws QueueException;
    public boolean isEmpty();   
}


class QueueLL implements Queue {
    
 
    // assume the queue is non-empty when this method is called, otherwise thro exception
    public int deQueue() throws QueueException {
        return deQueue();
    }

 

} // end of QueueLL class



class QueueCB implements Queue {
    private int q[], back, front;
    private int qmax, size, capacity, count;

 
    public QueueCB() {
        qmax = 4;
        size = front = back = 0;
        count = 0;
        q = new int[qmax];
        capacity = size;
    }

    public void enQueue( int x) throws QueueException  {
        // do it
        //check for queue overflow
        if(isFull()) {
            System.out.println("Overflow\n Program Terminated");
            System.exit(-1);
        }

        System.out.println("Inserting " + x);

        back = (back + 1) % capacity;
        q[back] = x;
        count++;
    }
  
    private boolean isFull() {
        return (size() == capacity);
    }

    private int size() {
        return count;
    }

    public int deQueue()  throws QueueException 
    {
        // do it
        if(isEmpty()) {
            System.out.println("Underflow \nProgram Terminated");
            System.exit(-1);
        }

        int x = q[front];

        System.out.println("Removing " + x);

        front = (front  + 1) % capacity;
        count--;

        return x;
  }

    public boolean isEmpty() {
        return size == 0;
    }
}


// here we test both implementations
class QueueTest2 {
    public static void main(String[] arg) {
        Queue q1, q2;
        q1 = new QueueLL();
        q2 = new QueueCB();
        
        for(int i = 1; i<6; ++i)
        try { 
            q1.enQueue(i);            
        } catch (QueueException e) {
            System.out.println("Exception thrown: " + e); 
        }
        
        // more test code
    }   
}

