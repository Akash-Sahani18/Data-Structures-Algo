
class coinChangeMax {

    //(Tabulation)Bottom Up Approach
    public static int counWays(int coin[], int n, int sum) {

        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coin[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    //Recursive Approach
    // public static int coin(int coin[], int n, int sum) {
    //     if (sum == 0) {
    //         return 1;
    //     }
    //     if (sum < 0 || n <= 0) {
    //         return 0;
    //     }
    //     return coin(coin, n, sum - coin[n - 1]) + coin(coin, n - 1, sum);
    // }
    public static int possibleWays(int coin[], int n, int sum) {

        return counWays(coin, n, sum);
    }

    public static void main(String args[]) {
        int coin[] = {1, 2, 4};
        int sum = 4;
        int n = coin.length;
        System.out.println("Total Ways to Make Sum: " + counWays(coin, n, sum));
    }
}
