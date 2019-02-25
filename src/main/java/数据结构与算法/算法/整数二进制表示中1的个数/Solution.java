package 数据结构与算法.算法.整数二进制表示中1的个数;

import java.util.Scanner;

/**
 * 输入一个整数，求该整数的二进制表达中有多少个1。
 例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
 * @Author ifcc
 * @Date 2018-04-25
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = solution(n);
        System.out.println(result);
    }
    public static int solution(int n){
       /* if (n==0){
            return 0;
        }*/
        int result=0;
        while (n!=0){
            result++;
            n=n&(n-1);
        }
        return result;
    }
}
