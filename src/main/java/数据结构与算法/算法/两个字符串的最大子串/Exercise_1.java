package 数据结构与算法.算法.两个字符串的最大子串;

import java.util.Scanner;

/**
 * 求两个字符串的最大子串
 * 动态规划
 * @Author ifcc
 * @Date 2018-04-14
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Exercise_1 {
    public static void main(String[] artgs){
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        getLongestString(string1,string2);
    }

    private static void getLongestString(String string1, String string2) {
        int[][] dp = new int[string1.length()][string2.length()];
        for (int i=0;i<string1.length();i++){
            for (int j=0;j<string2.length();j++){
                if (string1.charAt(i)==string2.charAt(j)){
                    if (i-1>=0&&j-1>=0){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else {
                        dp[i][j]=1;
                    }

                }

            }
        }
        int maxI=0,maxJ=0,maxLength=0;
        for (int i=0;i<string1.length();i++){
            for (int j=0;j<string2.length();j++){
                if (dp[i][j]>maxLength){
                    maxI=i;
                    maxJ=j;
                    maxLength=dp[i][j];
                }
            }
        }
        for (int i=maxI-maxLength+1;i<=maxI;i++){
            System.out.print(string1.charAt(i));
        }
    }
}
