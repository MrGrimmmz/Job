package 数据结构与算法.算法.左旋转字符串;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。

 如把字符串abcdef左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。
 要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。
 * @Author ifcc
 * @Date 2018-04-25
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        char[] c = s.toCharArray();
        solution(c,n);
    }
    public static void solution(char[] s,int n){
        reverse(s,0,n-1);
        reverse(s,n,s.length-1);
        reverse(s,0,s.length-1);
        System.out.println(new String(s));
    }
    public static void reverse(char[] s,int start,int end){
        int i=start,j=end;
        while (i<j){
            char c=s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
    }
}
