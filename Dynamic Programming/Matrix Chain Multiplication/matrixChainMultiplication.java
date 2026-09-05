
class matrixChainMultiplication {

    public static int chainMultiplication(int nums[], int i, int j) {

        if (j - 1 == i) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int curr = chainMultiplication(nums, i, k) + chainMultiplication(nums, k, j) + nums[i] * nums[k] * nums[j];
            res = Math.min(res, curr);
        }
        return res;
    }

    public static void main(String args[]) {
        int nums[] = {2, 1, 3, 4};
        int i = 0;
        int j = nums.length - 1;
        System.out.println(chainMultiplication(nums, i, j) + " ");
    }
}
