
class targetSum {
    //Recursive Aapproach
    // public static int target(int nums[], int n, int s, int target) {

    //     if (target == s) {
    //         return 1;
    //     }
    //     if (n == 0) {
    //         return 0;
    //     }
    //     // int add = target(nums,n-1,s + nums[n-1],target);
    //     // int suntract = target(nums,n-1,s - nums[n-1],target);
    //     return target(nums, n - 1, s + nums[n - 1], target) + target(nums, n - 1, s - nums[n - 1], target);
    // }
    //Tabulation (Bottom-Up) Approach
    public static int targetSum(int nums[], int n, int dp[][], int subSetSum) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= subSetSum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][subSetSum];
    }

    public static void main(String argd[]) {
        int nums[] = {1, 2, 3, 5};
        int n = nums.length;
        int target = 1;
        //System.out.println(target(nums, n, 0, target) + " ");
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if ((totalSum + target) % 2 != 0) {
            return;
        }
        int subSetSum = (totalSum + target) / 2;
        int dp[][] = new int[n + 1][subSetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        System.out.println(targetSum(nums, n, dp, subSetSum));
    }
}
