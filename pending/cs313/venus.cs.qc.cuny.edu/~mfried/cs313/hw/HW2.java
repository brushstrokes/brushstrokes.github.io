import java.io.*;
import java.util.*;

public class HW2 {

   // Prints all movies that occur in both lists.
   public static void intersection(List<String> list1, List<String> list2) {
      // Fill in.
   }

   // Prints all movies in the list that occur at least k times
   // (print the movie followed by the number of occurrences in parentheses).
   public static void frequent(List<String> list, int k) {
      // Fill in.
   }

   // Prints all movies in the list, grouped by number of characters.
   // All movies with the same number of characters are printed on the same line.
   // Movies with fewer characters are listed first.
   public static void groupByNumChars(List<String> list) {
      // Fill in.
   }

   // Returns a List of all movies in the specified file (assume there is one movie per line).
   public static List<String> getList(String filename) {
      List<String> list = new ArrayList<>();
      try (Scanner in = new Scanner(new FileReader(filename))) {
         while (in.hasNextLine()) {
            String line = in.nextLine();
            list.add(line);
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      return list;
   }

   public static void main(String[] args) {
      List<String> list1 = getList("imdb.txt");
      List<String> list2 = getList("sight_and_sound.txt");
      List<String> list3 = getList("3_lists.txt");

      System.out.println("***intersection***");
      intersection(list1, list2);

      System.out.println("***frequent***");
      frequent(list3, 3);

      System.out.println("***groupByNumChars***");
      groupByNumChars(list1);
   }
}
