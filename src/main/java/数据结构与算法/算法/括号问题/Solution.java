package 数据结构与算法.算法.括号问题;

/**
 * 1、已知一个字符串都是由左括号(和右括号)组成，判断该字符串是否是有效的括号组合。
 例子：
 有效的括号组合:()(),(()),(()())
 无效的括号组合:(,()),((),()(()
 2、题目进阶：
 已知一个字符串都是由左括号(和右括号)组成，返回最长有效括号子串的长度。
 * @Author ifcc
 * @Date 2018-05-08
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){

    }
    public static boolean solution1(String str){
        if (str==null||str.length()==0){
            return false;
        }
        char[] chars = str.toCharArray();
        int status=0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='('&&chars[i]!=')'){
                return false;
            }
            if (chars[i]==')'&&--status<0){
                return false;
            }
            if (chars[i]=='('){
                status++;
            }
        }
        return status==0;
    }

    public static int solution2(String str){
        if (str==null||str.equals("")){
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] dp=new int[chars.length];
        int pre=0;
        int res=0;
        for (int i=1;i<chars.length;i++){
            if (chars[i]==')'){
                pre=i-1-dp[i-1];
                if (pre>=0 && chars[pre]=='('){
                    dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
                }
            }
            res=Math.max(dp[i],res);
        }
        return res;
    }

}
