
class catalUsingBinomial {

    public static long binCoff(int n, int k) {

        if (k > n - k) {
            k = n - k;
        }
        long res = 1;
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static long catalan(int n) {

        long c = binCoff(2 * n, n);

        return c / (n + 1);
    }

    public static void main(String args[]) {
        int n = 5;

        System.out.println("Catalan Number: " + catalan(n));
    }
}
