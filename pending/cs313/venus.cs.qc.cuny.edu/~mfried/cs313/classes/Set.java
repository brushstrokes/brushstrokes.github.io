
public interface Set<E> {
   // Adds the specified element to the set (if it is not already in the set).
   void add(E e);
   
   // Removes the specified element from the set.
   void remove(E e);
   
   // Returns true if the specified element is in the set.
   boolean contains(E e);
}
