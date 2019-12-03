import java.util.*;

public class UsingIterators {

   public static void main(String[] args) {
      List<Integer> list = new LinkedList<>();
      for (int i = 1; i <= 10; ++i) // Adds the numbers from 1-10 to the list
         list.add(i);
      
      for (Iterator<Integer> it = list.iterator(); it.hasNext();) // Prints the list with an iterator
         System.out.print(it.next() + " ");
      System.out.println();

      for (Iterator<Integer> it = list.iterator(); it.hasNext();) { // Removes all even numbers from the list
         int i = it.next();
         if (i % 2 == 0)
            it.remove();
      }
      
      for (int i : list) // Prints the list with a for-each loop
         System.out.print(i + " ");
   }
}
