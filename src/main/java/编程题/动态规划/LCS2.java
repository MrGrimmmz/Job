package 编程题.动态规划;

/**
 * @author LIFAN
 * 2019/3/20 13:41
 */
public class LCS2 {

    public static void main(String[] args) {
        String str1 = "13456778";
        String str2 = "357486782";
        printLCS(str1, str2);
    }

    public static void printLCS(String str1, String str2) {
        /**
         * //非算法相关代码，仅保证无异常
         if(null==str1){
         str1="";
         }
         if(null==str2){
         str2="";
         }
         */

        int str1Len = str1.length();
        int str2Len = str2.length();
        int[][] cLenNUm = new int[str1.length() + 1][str2.length() + 1];//默认赋值，[0][?],[?][0]默认两侧皆0,类似公式中0的场景
        //构造一个LCS长度数组
        for (int i = 1; i <= str1Len; i++) {
            for (int j = 1; j <= str2Len; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {//对应公式第二条相等
                    cLenNUm[i][j] = cLenNUm[i - 1][j - 1] + 1;
                } else {//对应公式第三条不相等
                    cLenNUm[i][j] = Math.max(cLenNUm[i][j - 1], cLenNUm[i - 1][j]);
                }
            }
        }

        //反推结果
        int i = str1Len;
        int j = str2Len;
        StringBuffer sb = new StringBuffer();//作为结果
        while (i > 0 && j > 0) {//这里其实处理了i=0,j=0的，对应公式0的反推场景
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {//反推公式中不相等的场景
                //该值一定是被选取到的，根据之前的公式，知道两条字符串的下标都前进一位
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {//对应公式中不相等的反推场景
                if (cLenNUm[i][j - 1] > cLenNUm[i - 1][j]) {//找大的那个方向，此处是左边大于上面，则该处的结果是来自左边
                    j--;
                } else if (cLenNUm[i][j - 1] < cLenNUm[i - 1][j]) {
                    i--;
                } else if (cLenNUm[i][j - 1] == cLenNUm[i - 1][j]) {
                    //对于有分支的可能时，我们选取单方向
                    i--;   //此结果对于结果1所选取方向，str1的下标左移一位.替换为j--，则结果对应与结果2选取的方向
                }
            }
        }
        //由于是从后往前加入字符的，需要反转才能得到正确结果
        System.out.println(sb.reverse().toString());
    }
}
