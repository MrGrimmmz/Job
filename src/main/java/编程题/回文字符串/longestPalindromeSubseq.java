package 编程题.回文字符串;

/**
 * @author LIFAN
 * 2019/3/28 12:32
 * 最长回文子序列
 */
public class longestPalindromeSubseq {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int [][] dp = new int[len][len];
        for(int i = len - 1; i>=0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }

    //递归
    public static int longestPalindromeSubseq2(String s,int begin,int end) {
        if (begin == end) {
            return 1;
        }
        if(begin > end){
            return 0;
        }
        if(s.charAt(begin) == s.charAt(end))
            return longestPalindromeSubseq2(s,begin+1,end-1) + 2;
        else
            return Math.max(longestPalindromeSubseq2(s,begin+1,end),longestPalindromeSubseq2(s,begin,end-1));

    }

    public static void main(String[] args){
        //System.out.println(longestPalindromeSubseq("abccccdd"));
        String s = "abccccdd";
        System.out.println(longestPalindromeSubseq2(s,0,s.length()-1));
    }
}
