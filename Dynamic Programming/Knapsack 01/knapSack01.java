
class knapSack01 {

    public static int knapsack(int w, int wt[], int val[], int n, int memo[][]) {

        if (n == 0 || w == 0) {
            return 0;
        }
        if (memo[n][w] != -1) {
            return 0;
        }

        int pick = 0;
        if (wt[n - 1] <= w) {
            pick = val[n - 1] + knapsack(w - wt[n - 1], wt, val, n - 1, memo);
        }

        int notPick = knapsack(w, wt, val, n - 1, memo);

        return memo[n][w] = Math.max(pick, notPick);
    }

    public static void main(String args[]) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int w = 4;
        int n = wt.length;
        int memo[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println("Maximum Profit: " + knapsack(w, wt, val, n, memo));
    }
}
