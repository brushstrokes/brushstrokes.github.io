import java.math.*;
import java.util.*;

public class StringMatching {

   // Returns the index of the first occurrence of pattern within text, or -1 if it does not occur.
   public static int RabinKarp(String pattern, String text) {
      int m = pattern.length(), n = text.length();
      long largePrime = BigInteger.probablePrime(24, new Random()).intValue(); // A random large prime
      long patternHash = 0, textHash = 0;
      long am = 1; // a^(m-1)
      // Compute the hashes of the pattern and the first substring of the text
      for (int i = 0; i < pattern.length(); ++i) {
         patternHash = (patternHash * 256 + pattern.charAt(i)) % largePrime;
         textHash = (textHash * 256 + text.charAt(i)) % largePrime;
         if (i < pattern.length()-1) am = (am * 256) % largePrime;
      }
      for (int i = 0; i < n-m; ++i) { // For each substring of the text
         // If the hashes match, verify that the strings match
         if (patternHash == textHash && pattern.equals(text.substring(i, i+m))) return i;
         // Compute the hash of the next substring
         textHash = (((textHash - text.charAt(i)*am) * 256) + text.charAt(i+m)) % largePrime;
         if (textHash < 0) textHash += largePrime; // Make sure it's positive
      }
      // Compare the hashes for the last substring
      if (patternHash == textHash && pattern.equals(text.substring(n-m, n))) return n-m;
      return -1; // If there are no matches, return -1
   }
   
   public static void main(String[] args) {
      System.out.println(RabinKarp("EL", "HELLO"));
   }

}
