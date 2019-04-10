package 编程题.KMP;

/**
 * @author LIFAN
 * 2019/3/27 16:16
 */
public class KMP {

    public static boolean hasSubString(String originStr, String subString) {
        if ((null != originStr && null != subString) && (originStr.length() < subString.length())) {
            return false;
        }
        char[] originStrChars = originStr.toCharArray();
        char[] subStringChars = subString.toCharArray();
        return matchString(originStrChars, subStringChars);
    }

    /**
     * KMP中的核心算法，获得记录跳转状态的next数组
     *
     * @param c
     * @return
     */
    public static int[] matchTable(char[] c) {
        int length = c.length;

        int[] next = new int[length];

        int j = 0;
        int k = -1;

        next[0] = -1;

        while(j < length - 1) {
            if (k == -1 || c[j] == c[k]) {
                //当两个字符相等时要跳过
                if(c[++j] == c[++k]){
                    next[j] = next[k];
                }else{
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 匹配字符串
     *
     * @param originStrChars
     * @param subStringChars
     * @return
     */
    public static boolean matchString(char[] originStrChars, char[] subStringChars) {
        int[] next = matchTable(subStringChars);
        int i = 0;
        int j = 0;
        while (i <= originStrChars.length - 1 && j <= subStringChars.length - 1) {
            if (j == -1 || originStrChars[i] == subStringChars[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < subStringChars.length) {
            return false;
        } else
            return true;
    }

    public static void main(String[] args){
        System.out.println(hasSubString("abababcd","ababc"));
    }
}
