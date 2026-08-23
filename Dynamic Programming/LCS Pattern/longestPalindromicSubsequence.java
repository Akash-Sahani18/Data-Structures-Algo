
class longestPalindromicSubsequence {

    //Tabulation(Bottom Up)
    public static int longestPalindrome(String s1, String s2, int m, int n) {

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
        return dp[m][n];
    }
    //Recursive Approach
    // public static int longestPalindrome(String s1, String s2, int m, int n) {

    //     if (m == 0 || n == 0) {
    //         return 0;
    //     }
    //     if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
    //         return 1 + longestPalindrome(s1, s2, m - 1, n - 1);
    //     }
    //     return Math.max(longestPalindrome(s1, s2, m - 1, n), longestPalindrome(s1, s2, m, n - 1));
    // }
    public static void main(String args[]) {
        String s1 = "agbcba";
        String s2 = new StringBuilder(s1).reverse().toString();
        int m = s1.length();
        int n = s2.length();
        System.out.println("Longest Palindromic Subsequemce: " + longestPalindrome(s1, s2, m, n));
    }
}
