
class twoEqualPartition {
    //Tabulation (Bottom-Up Approach)

    public static boolean isEqualPartition(int nums[], int n) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;

        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];

    }

    //Memoized(Top-Down Approach) Solution
    /*public static boolean isSubSetSum(int nums[], int n, int sum, int memo[][]) {

        if (sum == 0) {
            return true;
        }

        if (n <= 0) {
            return false;
        }
        if (memo[n - 1][sum] != -1) {
            return memo[n - 1][sum] == 1;
        }

        if (nums[n - 1] > sum) {
            return isSubSetSum(nums, n - 1, sum, memo);
        }

        memo[n - 1][sum] = isSubSetSum(nums, n - 1, sum, memo) || isSubSetSum(nums, n - 1, sum - nums[n - 1], memo) ? 1 : 0;

        return memo[n - 1][sum] == 1;
    }*/
    // public static boolean isEqual(int nums[], int n) {
    //     int sum = 0;
    //     for (int num : nums) {
    //         sum += num;
    //     }
    //     if (sum % 2 != 0) {
    //         return false;
    //     }
    //     int memo[][] = new int[n + 1][sum + 1];
    //     for (int row[] : memo) {
    //         Arrays.fill(row, -1);
    //     }
    //     return isSubSetSum(nums, n, sum / 2, memo);
    // }
    public static void main(String args[]) {
        int nums[] = {1, 5, 11, 5};
        int n = nums.length;
        System.out.println(isEqualPartition(nums, n) + " ");
    }
}
