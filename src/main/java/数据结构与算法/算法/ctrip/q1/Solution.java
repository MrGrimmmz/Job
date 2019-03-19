package 数据结构与算法.算法.ctrip.q1;

import java.util.Scanner;

/**
 * FileName: Cake
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/4 19:43
 * Description:
 */
public class Solution {

    private static Integer value=10;
    public static void main(String[] args){
        /*Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        int result=0;
        while (input!=0){
            input=input&(input-1);
            result++;
        }
        System.out.println(result);*/
        solution(value);
        System.out.println(value);
    }
    public static void solution(Integer x){
        x=x*3;
    }
}
