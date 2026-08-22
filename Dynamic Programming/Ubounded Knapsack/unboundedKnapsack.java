
class unboundedKnapsack {

    //Recursive approach
    // public static int knapsack(int val[], int wt[], int n, int m, int cap) {
    //     if (m == 0 || n == 0) {
    //         return 0;
    //     }
    //     if (cap <= 0) {
    //         return 0;
    //     }
    //     int take = 0;
    //     if (wt[n - 1] <= cap) {
    //         take = val[n - 1] + knapsack(val, wt, n, m, cap - wt[n - 1]);
    //     }
    //     int notTake = knapsack(val, wt, n - 1, m - 1, cap);
    //     return Math.max(take, notTake);
    // }
    //Tabulation (Bottom-Up) Approach
    public static int knapsack(int val[], int wt[], int n, int m, int cap) {

        int dp[][] = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j >= wt[i - 1]) {
                    dp[i][j] = val[i - 1] + dp[i][j - wt[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][cap];
    }

    public static void main(String args[]) {
        int val[] = {1, 50};
        int wt[] = {10, 30};
        int cap = 10;
        int n = val.length;
        int m = wt.length;

        System.out.println(knapsack(val, wt, n, m, cap) + " ");

    }
}
