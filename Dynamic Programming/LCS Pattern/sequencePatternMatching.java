
class sequencePatternMatching {

    public static int lcs(String s1, String s2, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static boolean patterMatching(String s1, String s2, int m, int n) {

        if (s1.length() == lcs(s1, s2, m, n)) {
            return true;
        }
        return false;

    }

    public static void main(String args[]) {
        String s1 = "axy";
        String s2 = "adxcpy";
        int m = s1.length();
        int n = s2.length();
        System.out.println(patterMatching(s1, s2, m, n));
    }
}
