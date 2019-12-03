import java.util.*;

public class Timer {

   public static void main(String[] args) {
      long start, end;
      
      List<Integer> arrayList = new ArrayList<>();
      start = System.currentTimeMillis();
      for (int i = 0; i < 1000000; ++i)
         arrayList.add(i);
      end = System.currentTimeMillis();
      System.out.println("ArrayList: " + (end-start)/1000.0);
      
      List<Integer> linkedList = new LinkedList<>();
      start = System.currentTimeMillis();
      for (int i = 0; i < 1000000; ++i)
         linkedList.add(i);
      end = System.currentTimeMillis();
      System.out.println("LinkedList: " + (end-start)/1000.0);
   }
}
