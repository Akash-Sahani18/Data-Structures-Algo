
class catalanNumber {

    public static int num(int n) {

        int catal[] = new int[n + 1];
        catal[0] = catal[1] = 1;

        for (int i = 2; i <= n; i++) {
            catal[i] = 0;
            for (int j = 0; j < i; j++) {
                catal[i] += catal[j] * catal[i - j - 1];
            }
        }
        return catal[n];
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println("Catalan Number: " + num(n));
    }
}
