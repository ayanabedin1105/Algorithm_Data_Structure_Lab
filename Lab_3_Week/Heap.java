// Heap.java
// Skeleton code

class Heap {
   private int[] a;
   int N;
   static int maxH = 100;

   // two constructors
   Heap() {
      N = 0;
      a = new int[maxH + 1];
   }

   Heap(int size) {
      N = 0;
      a = new int[size + 1];
   }

   void siftUp(int k) {
      int v = a[k];
      a[0] = Integer.MAX_VALUE;
      // complete yourself from pseudocode in notes
      while (v > a[k / 2]) {
         a[k] = a[k / 2];
         k = k / 2;
      }
      a[k] = v;

   }

   void siftDown(int k) {
      int v, j;
      v = a[k];
      // complete yourself
      while ((2 * k) <= N) {
         j = (2 * k);
         if (j < N && a[j] < a[j + 1]) {
            j++;
         }
         if (v >= a[j]) {
            break;
         }
         a[k] = a[j];
         k = j;
      }
      a[k] = v;
   }

   void siftDownRec(int k) {
      int largest = k;
      int l = k * 2;
      int r = k * 2 + 1;
      int temp;

      // If the left child is larger than parent
      if (l <= N && a[l] > a[k]) {
         largest = l;
      }
      
      // If the right child is larger than largest
      if (r <= N && a[r] > a[largest]) {
         largest = r;
      }
      
      if (largest != k) {
         temp = a[k];
         a[k] = a[largest];
         a[largest] = temp;

         // Recursively heapify the affected sub-tree
         siftDownRec(largest);
      }
   }

   void insert(int x) {
      a[++N] = x;
      siftUp(N);
   }

   int remove() {
      a[0] = a[1];   // store highest priority value in a[0]
      a[1] = a[N--]; // and replace it with value from end of the heap
      //siftDown(1);   // and then sift this value down
      siftDownRec(1);
      return a[0];
   }

   void display() {
      System.out.println("\nThe tree structure of the heaps is:");
      System.out.println(a[1]);
      for (int i = 1; i <= N / 2; i = i * 2) {
         for (int j = 2 * i; j < 4 * i && j <= N; ++j)
            System.out.print(a[j] + "  ");
         System.out.println();
      }
      System.out.println();
   }

   public static void main(String args[]) {

      Heap h = new Heap();
      int r;
      double x;

      // insert random numbers between 0 and 99 into heap
      for (int i = 1; i <= 10; ++i) {
         x = (Math.random() * 100.0);
         r = (int) x;
         System.out.println("Inserting " + r);
         h.insert(r);
         h.display();
      }
      for (int i = 1; i <= 10; ++i) {
         
         h.remove();
         h.display();
      }
   }

} // end of Heap class