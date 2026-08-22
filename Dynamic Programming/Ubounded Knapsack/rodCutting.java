
class rodCutting {
    //Tabulation (Bottom-up Approach)

    public static int cutting(int price[], int n, int rodLength) {

        int dp[][] = new int[n + 1][rodLength + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= rodLength; j++) {
                if (i <= j) {
                    dp[i][j] = Math.max(price[i] + dp[i][j - i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][rodLength];
    }
    //Recurssive Approach
    // public static int cutting(int price[], int n, int rodLength) {

    //     if (n == 0 || rodLength == 0) {
    //         return 0;
    //     }
    //     int take = 0;
    //     if (n <= rodLength) {
    //         take = price[n] + cutting(price, n, rodLength - n);
    //     }
    //     int notTake = cutting(price, n - 1, rodLength);
    //     return Math.max(take, notTake);
    // }
    public static void main(String args[]) {

        int price[] = {0, 3, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = price.length - 1;
        int n = price.length;
        System.err.println("Maximum Cost of Cutting a rod: " + cutting(price, n, rodLength));

    }
}
