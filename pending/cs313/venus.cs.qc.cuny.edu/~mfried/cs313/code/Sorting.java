import java.util.*;

public class Sorting {
   
   // Swaps the elements at indices i and j.
   private static void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   public static void selectionsort(int[] a) {
      for (int i = 0; i < a.length-1; ++i) {
         int min = i;
         for (int j = i+1; j < a.length; ++j) // Find the smallest element in the unsorted portion
            if (a[j] < a[min])
               min = j;
         swap(a, i, min);                     // Swap it into the correct spot
      }
   }

   public static void insertionsort(int[] a) {
      for (int i = 1; i < a.length; ++i) {
         int temp = a[i], j = i-1;         // Save the current element
         while (j >= 0 && a[j] > temp) {   // Shift all elements greater than it to the right
            a[j+1] = a[j];
            --j;
         }
         a[j+1] = temp;                    // Insert the current element into the correct spot
      }
   }

   private static int[] aux; // Used for merging
   public static void mergesort(int[] a) {
      aux = new int[a.length];
      mergesort(a, 0, a.length-1);
   }

   private static void mergesort(int[] a, int low, int high) {
      if (low >= high) return;
      int mid = low + (high - low) / 2;
      mergesort(a, low, mid);      // Sort the left half
      mergesort(a, mid+1, high);   // Sort the right half
      merge(a, low, mid, high);    // Merge the two halves
   }
   
   // Merges two sorted ranges, a[low..mid] and a[mid+1..high], into one sorted range,
   // and stores the new sorted range in a[low..high].
   private static void merge(int[] a, int low, int mid, int high) {
      for (int k = low; k <= high; ++k)                       // Copy the elements to the temporary array, aux
         aux[k] = a[k];
      // Merge back into the original array
      // In each iteration, we compare the smallest element in each half
      // and move the smaller one back into the original array.
      // i is the current index in the left half, j is the current index in the right half,
      // k is the index in the original array where the next element will be placed.
      for (int i = low, j = mid+1, k = low; k <= high; ++k) {
         if (i > mid) a[k] = aux[j++];              // Case 1: No remaining elements in left half
         else if (j > high) a[k] = aux[i++];        // Case 2: No remaining elements in right half
                                                    // Case 3: Compare the smallest element in each half
         else if (aux[i] < aux[j]) a[k] = aux[i++];    // Element from left half is smaller
         else a[k] = aux[j++];                         // Element from right half is smaller
      }
   }
   
   public static void quicksort(int[] a) {
      quicksort(a, 0, a.length-1);
   }
   
   // Sorts the elements in the range a[low..high].
   private static void quicksort(int[] a, int low, int high) {
      if (low >= high) return;
      int pivotIndex = partition(a, low, high); // Partition the array into two halves
      quicksort(a, low, pivotIndex-1);          // Sort the left half
      quicksort(a, pivotIndex+1, high);         // Sort the right half
   }
   
   // Partitions the array and returns the pivot index such that a[low..pivotIndex-1] <= a[pivotIndex] <= a[pivotIndex+1..high].
   // This implementation uses Lomuto's partitioning scheme.
   private static int partition(int[] a, int low, int high) {
      int pivotValue = a[high];        // Choose the rightmost element in the range as the pivot
      int i = low;
      for (int j = low; j < high; ++j) // Compare each element to the pivot
         if (a[j] < pivotValue)        // If it's less than the pivot, move it to the left half by swapping
            swap(a, i++, j);
      swap(a, i, high);                // Swap the pivot with the leftmost element in the right half
      return i;
   }
   
   // Returns the element that would be at index k if the array were sorted.
   // The elements will be arranged such that a[low..k-1] <= a[k] <= a[k+1..high],
   // but the array will not be fully sorted.
   public static int quickselect(int[] a, int low, int high, int k) {
      if (low == high) return a[low];
      int pivot = partition(a, low, high); // Partition the array into two halves
      // The pivot element is in its final position, so if its at index k, return it
      if (k == pivot) return a[k];
      if (k < pivot)                       // Call quickselect on the half that contains index k
         return quickselect(a, low, pivot-1, k);
      else
         return quickselect(a, pivot+1, high, k);
   }
   
   // Sorts an array of integers in the range 0 to k-1.
   public static void countingsort(int[] a, int k) {
      int[] output = new int[a.length];
      int[] count = new int[k];
      for (int i = 0; i < a.length; ++i)    // Count the occurrences of each integer
         ++count[a[i]];
      for (int i = 1; i < k; ++i)           // Compute the number of elements less than each integer
         count[i] += count[i-1];
      for (int i = a.length-1; i >= 0; --i) // Copy each element to the correct spot in the output array
         output[--count[a[i]]] = a[i];
      for (int i = 0; i < a.length; ++i)    // Copy the elements back to array a
         a[i] = output[i];
   }
   
   // Radix sort in base 256.  Numbers are assumed to be positive (extra code would be needed to handle negative numbers).
   public static void radixsort(int[] a) {
      int[] b = new int[a.length];
      stablesort(a, b, 0);  // Sort by the least significant digit
      stablesort(b, a, 8);
      stablesort(a, b, 16);
      stablesort(b, a, 24); // Sort by the most significant digit
   }
   
   // Sorts by the specified 8-bit digit (using counting sort)
   private static void stablesort(int[] a, int[] b, int shift) {
      int[] count = new int[0x100];
      for (int i = 0; i < a.length; ++i)    // Count the occurrences of each integer
         ++count[(a[i]>>shift)&0xFF];
      for (int i = 1; i < 0x100; ++i)       // Compute the number of elements less than each integer
         count[i] += count[i-1];
      for (int i = a.length-1; i >= 0; --i) // Copy each element to the correct spot in the output array
         b[--count[(a[i]>>shift)&0xFF]] = a[i];
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
//      selectionsort(a);
//      insertionsort(a);
//      mergesort(a);
//      quicksort(a);
//      quickselect(a, 0, a.length-1, 5);
//      countingsort(a, 1000);
      radixsort(a);
      System.out.println("Sorted: " + Arrays.toString(a));
      
      if (isSorted(a)) // Verify that the array is sorted
         System.out.println("The array is sorted");
      else
         System.out.println("The array is not sorted");
   }
}
