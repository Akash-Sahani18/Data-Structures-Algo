
class longestPalindromicSubstring {

    //Expand Around the Centre
    public static String longestPal(String s) {

        if (s.length() <= 1) {
            return s;
        }
        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i + 1);
            int length = Math.max(oddLen, evenLen);
            if (length > maxLen) {
                maxLen = length;
                start = i - (length - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String args[]) {
        String s = "cbbd";
        System.out.println("Longest Palindromic Substring: " + longestPal(s));
    }
}
//Time Complexity: O(n);
//Space Complexity: O(1);
