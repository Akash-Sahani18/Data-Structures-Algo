
class printLCS {

    public static String printLCS(String s1, String s2, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        //Backtracking
        int i = m;
        int j = n;
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();

    }

    public static void main(String args[]) {
        String s1 = "abcde";
        String s2 = "abfde";
        int m = s1.length();
        int n = s1.length();
        System.out.println("Longest Common Subsequence: " + printLCS(s1, s2, m, n));
    }
}
