
public interface Queue<E> {
   // Adds the specified element to the end of the queue.
   void enqueue(E e);
   
   // Removes and returns the first element of the queue.
   E dequeue();
   
   // Returns (but does not remove) the first element of the queue.
   E first();
   
   int size();
}
