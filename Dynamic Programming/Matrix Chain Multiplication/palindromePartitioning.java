
import java.util.*;

class palindromePartioning {

    public static boolean isPalindrome(String s, int i, int j) {

        if (i >= j) {
            return true;
        }
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //Recursive Approach
    public static int palPartion(String s, int i, int j) {

        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int curr = 1 + palPartion(s, i, k) + palPartion(s, k + 1, j);
            res = Math.min(res, curr);
        }
        return res;
    }

    //Memoization(Top Down)Approach
    public static int palPalindrome(String s, int i, int j, int memo[][]) {
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int curr = 1 + palPalindrome(s, i, k, memo) + palPalindrome(s, k + 1, j, memo);
            res = Math.min(res, curr);
        }
        memo[i][j] = res;
        return res;
    }

    public static void main(String args[]) {
        String s = "geek";
        int n = s.length();
        int memo[][] = new int[n][n];
        for (int row[] : memo) {
            Arrays.fill(row, -1);
        }
        System.out.println(palPalindrome(s, 0, n - 1, memo));
    }
}
