
class longestRepeatingSubsequence {

    //Space Optimization
    public static int longestRepeating(String s, int n) {

        int curr[] = new int[n + 1];
        int match = 0;
        for (int i = 1; i <= n; i++) {
            int temp = curr[i];
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    curr[j] = 1 + match;
                } else {
                    curr[j] = Math.max(curr[j], curr[j - 1]);
                }
                match = temp;
            }
        }
        return curr[n];
    }
    //Tabulation Approach
    // public static int longestRepeating(String s, int n) {

    //     int dp[][] = new int[n + 1][n + 1];
    //     for (int i = 1; i <= n; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
    //                 dp[i][j] = 1 + dp[i - 1][j - 1];
    //             } else {
    //                 dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
    //             }
    //         }
    //     }
    //     return dp[n][n];
    // }
    //Time Complexity: O(n^2)
    //Space Complexity: O(n^2)
    public static void main(String args[]) {
        String s = "aabebcdd";
        int n = s.length();
        System.out.print("Longest Repeating Subsequence: " + longestRepeating(s, n));
    }
}
