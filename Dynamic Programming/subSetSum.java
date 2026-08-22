
class subSetSum {

    public static boolean subSum(int nums[], int n, int sum, boolean dp[][]) {

        if (sum == 0) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String args[]) {
        int nums[] = {3, 34, 4, 12, 5, 2};
        int n = nums.length;
        int sum = 60;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        System.out.println(subSum(nums, n, sum, dp) + " ");
    }
}
