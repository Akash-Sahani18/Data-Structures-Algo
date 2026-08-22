
class superShortestSub {

    //Bottom Up Approach(Tabulation)
    public static int shortest(String s1, String s2, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
    //Recursice Approach
    // public static int shortest(String s1, String s2, int m, int n) {

    //     if (m == 0) {
    //         return n;
    //     }
    //     if (n == 0) {
    //         return m;
    //     }
    //     if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
    //         return 1 + shortest(s1, s2, m - 1, n - 1);
    //     } else {
    //         return 1 + Math.min(shortest(s1, s2, m - 1, n), shortest(s1, s2, m, n - 1));
    //     }
    // }
    public static void main(String args[]) {
        String s1 = "GEEK";
        String s2 = "EKE";
        int m = s1.length();
        int n = s2.length();
        System.out.print("Super Shortest Subsequence: " + shortest(s1, s2, m, n));
    }
}
