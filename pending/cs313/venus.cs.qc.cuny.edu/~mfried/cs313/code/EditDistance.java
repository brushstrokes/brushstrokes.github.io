
public class EditDistance {
   
   public static int editDistance(String x, String y) {
      // dp[i][j] is the distance between the first i letters of x and the first j letters of y
      int[][] dp = new int[x.length()+1][y.length()+1];
      
      for (int i = 0; i <= x.length(); ++i) {
         for (int j = 0; j <= y.length(); ++j) {
            if (i == 0) // If string x is empty
               dp[i][j] = j;
            
            else if (j == 0) // If string y is empty
               dp[i][j] = i;
            
            else if (x.charAt(i-1) == y.charAt(j-1)) // If the last letter matches
               dp[i][j] = dp[i-1][j-1];
            
            else { // If the last letter does not match
               int insertion = dp[i][j-1] + 1;
               int deletion = dp[i-1][j] + 1;
               int substitution = dp[i-1][j-1] + 1;
               dp[i][j] = Math.min(insertion, Math.min(deletion, substitution));
            }
         }
      }
      return dp[x.length()][y.length()];
   }
   
   public static void main(String[] args) {
      System.out.println(editDistance("intention", "execution"));
      System.out.println(editDistance("relevant", "elephant"));
   }
}
