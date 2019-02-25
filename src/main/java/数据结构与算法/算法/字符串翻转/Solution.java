package 数据结构与算法.算法.字符串翻转;

import java.util.Scanner;

/**
 * 字符串翻转，不能借助外部空间
 * @Author ifcc
 * @Date 2018-04-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = solution(s);
        System.out.println(result);
    }
    public static String solution(String s){
        if (s==null||s.length()<=1){
            return s;
        }
        return solution(s.substring(1))+s.charAt(0);
    }
}
