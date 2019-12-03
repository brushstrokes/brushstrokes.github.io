
public class RodCutting {
   
   public static int cutRodTopDown(int[] prices, int n) {
      int[] dp = new int[prices.length+1]; // dp[i] stores the optimal solution for rod length i
      return cutRodTopDown(prices, n, dp);
   }
   
   public static int cutRodTopDown(int[] prices, int n, int[] dp) {
      if (n == 0) return 0; // Base case
      if (dp[n] != 0) return dp[n]; // If the subproblem has already been solved, return the answer
      int bestSolution = 0;
      // For i = 1 to n (i is the position of the leftmost cut)
      // calculate (value of piece of length i) + (optimal solution for cutting piece of length n-i)
      for (int i = 1; i <= n; ++i)
         bestSolution = Math.max(bestSolution, prices[i] + cutRodTopDown(prices, n-i, dp));
      return dp[n] = bestSolution; // Return the best solution for rod length n
   }
   
   public static int cutRodBottomUp(int[] prices, int n) {
      int[] dp = new int[prices.length+1]; // dp[i] stores the optimal solution for rod length i
      for (int j = 1; j <= n; ++j) { // For each rod length j, from 1 to n
         int bestSolution = 0;
         // For i = 1 to j (i is the position of the leftmost cut)
         // calculate (value of piece of length i) + (optimal solution for cutting piece of length j-i)
         for (int i = 1; i <= j; ++i)
            bestSolution = Math.max(bestSolution, prices[i] + dp[j-i]);
         dp[j] = bestSolution; // Store the best solution for rod length j
      }
      return dp[n];
   }

   public static void main(String[] args) {
      int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
      System.out.println(cutRodTopDown(prices, 10));
      System.out.println(cutRodBottomUp(prices, 10));
   }
}
