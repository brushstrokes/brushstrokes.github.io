import java.util.*;

// Hoare's partitioning scheme
public class QuicksortHoare {
   
   // Swaps the elements at indices i and j.
   private static void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   
   public static void quicksort(int[] a) {
      quicksort(a, 0, a.length-1);
   }
   
   // Sorts the elements in the range a[low..high].
   private static void quicksort(int[] a, int low, int high) {
      if (low >= high) return;
      int pivotIndex = partition(a, low, high); // Partition the array into two halves
      quicksort(a, low, pivotIndex);            // Sort the left half (note that a[pivot] is included in the left half)
      quicksort(a, pivotIndex+1, high);         // Sort the right half
   }
   
   // Partitions the array and returns the pivot index such that a[low..pivotIndex] <= pivotValue <= a[pivotIndex+1..high].
   // Note that pivotValue will not necessarily be at a[pivotIndex].
   // This implementation uses Hoare's partitioning scheme.
   private static int partition(int[] a, int low, int high) {
      int pivotValue = a[low];               // Choose the leftmost element in the range as the pivot
      int i = low-1, j = high+1;
      while(true) {
         do {i++;} while(a[i] < pivotValue); // Find an element >= pivot
         do {j--;} while(a[j] > pivotValue); // Find an element <= pivot
         if (i < j) swap(a, i, j);           // If they're in the wrong order, swap them
         else return j;
      }
   }
   
   // Returns true if the array is sorted.  Otherwise returns false.
   private static boolean isSorted(int[] a) {
      for (int i = 0; i < a.length-1; ++i)
         if (a[i] > a[i+1])
            return false;
      return true;
   }

   public static void main(String[] args) {
      int[] a = new int[10];
      Random rand = new Random();
      for (int i = 0; i < a.length; ++i)
         a[i] = rand.nextInt(1000);
      System.out.println("Unsorted: " + Arrays.toString(a));
      quicksort(a);
      System.out.println("Sorted: " + Arrays.toString(a));
      
      if (isSorted(a)) // Verify that the array is sorted
         System.out.println("The array is sorted");
      else
         System.out.println("The array is not sorted");
   }
}
