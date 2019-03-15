package 编程题.笔试题.远景能源;

/**
 * @author LIFAN
 * 2019/3/12 20:54
 * leetcode
 * longest-palindromic-substring
 * 最长回文字符串
 */
public class dd {
            private int left, maxLen;

            public String longestPalindrome(String s) {
                int len = s.length();
                if (len < 2)
                    return s;

                for (int i = 0; i < len-1; i++) {
                    extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
                    extendPalindrome(s, i, i+1); //assume even length.
                }
                return s.substring(left, left + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            left = j + 1;
            maxLen = k - j - 1;
        }
    }
}