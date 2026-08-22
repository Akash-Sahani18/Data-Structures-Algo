
class printLCSubstring {

    public static String printSubstring(String s1, String s2, int n, int m) {

        int dp[][] = new int[m + 1][n + 1];
        int maxLength = 0;
        int endInd = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endInd = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return s1.substring(endInd - maxLength, endInd);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfde";
        int m = s1.length();
        int n = s2.length();
        System.out.println("Longest Common Subsequence: " + printSubstring(s1, s2, n, m));
    }
}
