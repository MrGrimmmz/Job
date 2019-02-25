package 数据结构与算法.算法.Tencent.q1;

import java.util.Scanner;

/**
 * FileName: Solution1
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/16 10:53
 * Description:
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m;
        for(m=n;m>0;m--)
        {
            if(solution(m)){
                break;
            }
        }

        System.out.println(m * 2);
    }

    private static boolean solution(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
