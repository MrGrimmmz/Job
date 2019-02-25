package 数据结构与算法.算法.fx;

import java.util.Scanner;

/**
 * FileName: Question3
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/7/1 20:40
 * Description:
 */
public class Question3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string1=scanner.nextLine();
        String string2=scanner.nextLine();
        if (string1==null||string2==null){
            System.out.println("none");
            return;
        }
       /* int result = solution(string1, string2);
        System.out.println(result);*/
        int[][] re = longestCommonSubsequence(string1, string2);
        //打印矩阵
        for (int i = 0; i <= string1.length(); i++) {
            for (int j = 0; j <= string2.length(); j++) {
                System.out.print(re[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        //输出LCS
        print(re, string1, string2, string1.length(), string2.length());
    }
    public static int solution(String string1,String string2){

        return 0;
    }

    public static int[][] longestCommonSubsequence(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];//建立二维矩阵
        // 初始化边界条件
        for (int i = 0; i <= str1.length(); i++) {
            matrix[i][0] = 0;//每行第一列置零
        }
        for (int j = 0; j <= str2.length(); j++) {
            matrix[0][j] = 0;//每列第一行置零
        }
        // 填充矩阵
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = (matrix[i - 1][j] >= matrix[i][j - 1] ? matrix[i - 1][j]
                            : matrix[i][j - 1]);
                }
            }
        }

        //int i=str1.length()
        int result=0;
        /*for (int i=1;i<matrix.length;i++){
            if (matrix[i]>0&&matrix[i]==matrix[i-1])
        }*/
        return matrix;
    }
    //根据矩阵输出LCS
    public static void print(int[][] opt, String X, String Y, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            print(opt, X, Y, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (opt[i - 1][j] >= opt[i][j]) {
            print(opt, X, Y, i - 1, j);
        } else {
            print(opt, X, Y, i, j - 1);
        }
    }

    void LCS(char[] a, char[] b, int[][] c)
    {
        c = new int[a.length][];
        //初始化c[i][0]
        boolean contain = false;
        for (int i = 0; i < a.length; i++)
        {
            c[i] = new int[b.length];
            if (a[i] == b[0] || contain)
            {
                c[i][0] = 1;  contain = true;
            }
            else
            {
                c[i][0] = 0;
            }
        }
        //初始化c[0][j]
        contain = false;
        for (int j = 0; j < b.length; j++)
        {
            if (b[j] == a[0])
            {
                c[0][j] = 1;  contain = true;
            }
            else
            {
                c[0][j] = 0;
            }
        }

        //递归求得LCS的长度：c[i][j]
        for (int i = 1; i < a.length; i++)
        {
            for (int j = 1; j < b.length; j++)
            {
                if (a[i] == b[j])
                {
                    c[i][j] = c[i - 1][j - 1] + 1;  // 相等,pre+1
                }
                else if (c[i - 1][j] >= c[i][j - 1])   // get max of pre string
                {
                    c[i][j] = c[i - 1][j];
                }
                else
                {
                    c[i][j] = c[i][j - 1];
                }
            }
        }
    }

}
