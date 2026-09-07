
class booleanParenthesization {

    public static boolean evaluate(boolean b1, boolean b2, char op) {

        if (op == '&') {
            return b1 & b2;
        } else if (op == '|') {
            return b1 | b2;
        }
        return b1 ^ b2;
    }

    public static int countWays(String s, int i, int j, boolean req) {

        if (i == j) {
            return (req == (s.charAt(i) == 'T')) ? 1 : 0;
        }
        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = countWays(s, i, k - 1, true);
            int leftFalse = countWays(s, i, k - 1, false);

            int rightTrue = countWays(s, k + 1, j, true);
            int rightFalse = countWays(s, k + 1, j, false);

            if (evaluate(true, true, s.charAt(k)) == req) {
                ans += leftTrue * rightTrue;
            }
            if (evaluate(true, false, s.charAt(k)) == req) {
                ans += leftTrue * rightFalse;
            }
            if (evaluate(false, true, s.charAt(k)) == req) {
                ans += leftFalse * rightTrue;
            }
            if (evaluate(false, false, s.charAt(k)) == req) {
                ans += leftFalse * rightFalse;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        String s = "T|F&T";
        System.out.println(countWays(s, 0, s.length() - 1, true));
    }
}
