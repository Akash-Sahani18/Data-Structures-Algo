
class knapsackTabulation {

    public static int knapsack(int w, int wt[], int val[], int n) {

        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[n - 1][j - wt[i - 1]], dp[n - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String args[]) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int w = 4;
        int n = wt.length;
        System.out.println("Maximum Profit: " + knapsack(w, wt, val, n));
    }
}
