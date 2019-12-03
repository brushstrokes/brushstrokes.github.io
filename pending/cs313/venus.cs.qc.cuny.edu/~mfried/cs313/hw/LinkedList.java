import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Stack<E> {
   private Node<E> first, last;
   private int size = 0;
   
   // Construct a new empty list.
   public LinkedList() {
      first = last = new Node<>(null, null);
   }
   
   // Adds element e to the end of the list.
   public void add(E e) {
      last.next = new Node<>(e, null);
      last = last.next;
      ++size;
   }
   
   // Returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   public E get(int index) {
      if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException();
      Node<E> t = first.next;
      for (int i = 0; i < index; ++i)
         t = t.next;
      return t.data;
   }
   
   // Returns a string representation of the linked list.
   public String toString() {
      // Fill in.
   }
   
   // Removes all elements.
   public void clear() {
      // Fill in.
   }
   
   // Removes the first occurrence of the specified element, if it is present.
   // Returns true if the list has been modified.
   public boolean remove(E e) {
      // Fill in.
   }
   
   // Returns the number of elements.
   public int size() {
      return size;
   }
   
   // Adds element e to the top of the stack.
   public void push(E e) {
      // Fill in.
   }

   // Removes and returns the top element of the stack,
   // or throws a NoSuchElementException if the stack is empty.
   public E pop() {
      // Fill in.
   }

   // Returns but does not remove the top element of the stack,
   // or throws a NoSuchElementException if the stack is empty.
   public E top() {
      // Fill in.
   }
   
   private static class Node<E> {
      E data;
      Node<E> next;
      Node(E data, Node<E> next) {
         this.data = data;
         this.next = next;
      }
   }
}