
class printShortestSC {

    public static String printSCS(String s1, String s2, int m, int n) {
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
                }
                dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        int i = m;
        int j = n;
        StringBuilder res = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res.append(s1.charAt(i - 1));
                i--;
            } else {
                res.append(s2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            res.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            res.append(s2.charAt(j - 1));
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String args[]) {
        String s1 = "geek";
        String s2 = "eke";
        int m = s1.length();
        int n = s2.length();
        System.out.println("Super Shortest Common Subsequence: " + printSCS(s1, s2, m, n));

    }
}
