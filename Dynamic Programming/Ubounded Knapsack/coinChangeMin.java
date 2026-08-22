
class coinChangeMin {

    //Bottom Up Approach(Tabulation)
    public static int coinChange(int coins[], int n, int sum) {

        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
    // public static int coinChange(int coins[], int n, int sum) {

    //     if (sum == 0) {
    //         return 1;
    //     }
    //     if (sum < 0 || n == 0) {
    //         return Integer.MAX_VALUE;
    //     }
    //     int take = Integer.MAX_VALUE;
    //     if (sum >= coins[n - 1]) {
    //         take = coinChange(coins, n, sum - coins[n - 1]);
    //         if (take != Integer.MAX_VALUE) {
    //             take = take + 1;
    //         }
    //     }
    //     int notTake = coinChange(coins, n - 1, sum);
    //     return Math.min(take, notTake);
    // }
    public static void main(String args[]) {
        int coins[] = {25, 10, 5};
        int sum = 30;
        int n = coins.length;
        System.out.println("Minimum Ways to make a sum: " + coinChange(coins, n, sum));
    }
}
