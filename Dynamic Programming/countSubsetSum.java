
class countSubsetSum {

    public static int count(int nums[], int n, int target) {

        int dp[][] = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
    //Recursive Approach: O(2^n) and Space Complexity: O(n)
    // public static int count(int nums[], int n, int target) {

    //     //Base Condition
    //     if (target == 0) {
    //         return 1;
    //     }
    //     if (n <= 0) {
    //         return 0;
    //     }
    //     //Choice Program
    //     if (nums[n - 1] > target) {
    //         return count(nums, n - 1, target);
    //     }
    //     return count(nums, n - 1, target) + count(nums, n - 1, target - nums[n - 1]);
    // }
    public static void main(String[] args) {
        int nums[] = {5, 2, 3, 10, 6, 8};
        int n = nums.length;
        int target = 10;
        System.out.println(count(nums, n, target) + " ");
    }
}
