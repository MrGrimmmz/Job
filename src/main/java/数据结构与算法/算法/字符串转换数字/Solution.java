package 数据结构与算法.算法.字符串转换数字;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Scanner;

/**
 * 输入一个表示整数的字符串，把该字符串转换成整数并输出。
 例如输入字符串"345"，则输出整数345。
 * @Author ifcc
 * @Date 2018-04-25
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = solution(s);
        System.out.println(result);
    }
    public static int solution(String s){
        int result=0;
        int k=1;
        for (int i=s.length()-1;i>=0;i--){
            result+=Integer.parseInt(s.charAt(i)+"")*k;
            k*=10;
        }
        return result;
    }
}
