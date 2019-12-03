import java.util.*;

public class Coins  {

   public static int minCoins(int[] coins, int total) {
      int[] dp = new int[total+1];        // dp[i] stores the fewest coins needed to make i
      Arrays.fill(dp, Integer.MAX_VALUE); // (or Integer.MAX_VALUE if it is impossible)
      dp[0] = 0;                          // 0 coins are needed to make 0
      for (int i = 1; i <= total; ++i)                  // For each i, find the optimal solution
         for (int c : coins)                            // For each coin c, check the optimal solution for i-c
            // If i-c is negative, or does not have a solution, move onto the next coin
            if (c <= i && dp[i-c] != Integer.MAX_VALUE) // Find the smallest of these solutions, and add 1
               dp[i] = Math.min(dp[i], dp[i-c] + 1);
      if (dp[total] == Integer.MAX_VALUE)
         return -1;
      return dp[total];
   }

   public static void main(String args[]){
      int[] coins1 = {1, 5, 8};
      System.out.println(minCoins(coins1, 10));
      int[] coins2 = {3, 8};
      System.out.println(minCoins(coins2, 10));
   }
}
