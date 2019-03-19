package 数据结构与算法.算法.zhaoying;

import java.util.Scanner;

/**
 * FileName: Cake
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/8 11:34
 * Description:
 */
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n<=0){
            return;
        }
        int start = 1;
        int end = 2;
        int count = (n+1)/2;
        int sum = 1;
        while (start <= count){
            if (sum == n){
                System.out.print("["+start);
                for (int i=start+1;i<end;i++){
                    System.out.print(", "+i);
                }
                System.out.println("]");
                sum -= start;
                start++;
            }
            else if (sum < n){
                sum += end;
                end++;
            }
            else{
                sum -= start;
                start++;
            }
        }
    }
}
