
class matrixChainMultiplication {

    public static int chainMultiplication(int nums[], int i, int j) {

        if (i + j == 0) {
            return 0;
        }
        int curr = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            curr = chainMul(nums, i, k) + chainMul(nums, k + 1, j);
        }
        return curr;
    }

    public static void main(String args[]) {
        int nums[] = {2, 1, 3, 4};
        int i = 0;
        int j = nums.length;
        System.out.println(chainMul(nums, i, j) + " ");
    }
}
