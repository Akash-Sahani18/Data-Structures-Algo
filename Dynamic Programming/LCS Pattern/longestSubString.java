
class longestSubString {

    //Bottom Up Approach
    public static int subString(String s1, String s2, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }

    //Recursive Approach
    /*public static int subString(String s1, String s2, int m, int n) {

        if (m == 0 || n == 0 || s1.charAt(m - 1) != s2.charAt(n - 1)) {
            return 0;
        }

        return 1 + subString(s1, s2, m - 1, n - 1);
    }*/
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfde";
        int m = s1.length();
        int n = s2.length();
        System.out.println("Longest Common SubString: " + subString(s1, s2, m, n));
    }
}
