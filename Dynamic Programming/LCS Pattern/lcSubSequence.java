
import java.util.*;

class lcSubSequence {

    //Bottom Up Approach(Tabulation)
    public static int subSequence(String s1, String s2, int n, int m) {

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    //Memoized(Top-Down) Approach
    /*public static int subSequence(String s1, String s2, int n, int m, int memo[][]) {

        if (n == 0 || m == 0) {
            return 0;
        }
        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return memo[n][m] = 1 + subSequence(s1, s2, n - 1, m - 1, memo);
        }
        return memo[n][m] = Math.max(subSequence(s1, s2, n - 1, m, memo), subSequence(s1, s2, n, m - 1, memo));

    }*/

 /*public static int subSequence(String s1, String s2, int n, int m) {

        //Recursive Approach
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + subSequence(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(subSequence(s1, s2, n - 1, m), subSequence(s1, s2, n, m - 1));
        }
    }
     */
    public static void main(String args[]) {
        String s1 = "abcd";
        String s2 = "acd";
        int n = s1.length();
        int m = s2.length();
        int memo[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println("Longest Common Subsequence: " + subSequence(s1, s2, n, m));
    }
}
