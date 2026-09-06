
import java.util.*;

class matrixChainMultiplication {
    //Recursive Solution
    // public static int chainMultiplication(int nums[], int i, int j) {

    //     if (j - 1 == i) {
    //         return 0;
    //     }
    //     int res = Integer.MAX_VALUE;
    //     for (int k = i + 1; k < j; k++) {
    //         int curr = chainMultiplication(nums, i, k) + chainMultiplication(nums, k, j) + nums[i] * nums[k] * nums[j];
    //         res = Math.min(res, curr);
    //     }
    //     return res;
    // }
    //Top Down(Memoization)
    public static int chainMultiplication(int nums[], int i, int j, int memo[][]) {

        if (j - 1 == i) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int curr = chainMultiplication(nums, i, k, memo) + chainMultiplication(nums, k, j, memo) + nums[i] * nums[j] * nums[k];
            res = Math.min(res, curr);
        }
        memo[i][j] = res;
        return res;

    }

    public static void main(String args[]) {
        int nums[] = {2, 1, 3, 4};
        int n = nums.length;
        //System.out.println(chainMultiplication(nums, i, j) + " ");
        int memo[][] = new int[n][n];

        for (int row[] : memo) {
            Arrays.fill(row, -1);
        }
        System.out.println(chainMultiplication(nums, 0, n - 1, memo));
    }
}
