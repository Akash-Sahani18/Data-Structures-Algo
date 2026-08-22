
class partitionSubsetMinDiff {

    //Tabulation(Bottom-Up Approach)
    public static int minDiff(int nums[], int n) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int target = totalSum / 2;

        boolean dp[][] = new boolean[n + 1][totalSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        int sum1 = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                sum1 = j;
                break;
            }
        }
        int sum2 = totalSum - sum1;
        return Math.abs(sum2 - sum1);

    }
    //Recursive Approach
    // public static int minDiff(int nums[], int n, int totalSum, int sumCal) {
    //     //Base Condition
    //     if (n == 0) {
    //         return Math.abs((totalSum - sumCal) - sumCal);
    //     }

    //     return Math.min(minDiff(nums, n - 1, totalSum, sumCal + nums[n - 1]), minDiff(nums, n - 1, totalSum, sumCal));
    // }
    // public static int sumCalculated(int nums[], int n) {
    //     int sum = 0;
    //     for (int num : nums) {
    //         sum += num;
    //     }
    //     return minDiff(nums, n, sum, 0);
    // }
    public static void main(String args[]) {
        int nums[] = {1, 6, 11, 5};
        int n = nums.length;
        System.out.println("Minimum Difference: " + minDiff(nums, n));
    }
}
