package 编程题.笔试题.科大讯飞.字符串;

import java.util.*;
/**
 * @author LIFAN
 * 2019/3/24 17:23
 */

public class solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int num = minnum(s,s.length());
        System.out.println(num);

    }

    public static int minnum(String str, int n) {
        int num = n;
        //奇数直接返回总长度
        if (n % 2 == 1){
            return n;
        } else {//偶数
            for (int i = 0; i < n/2; i++) {
                //判断第i个数是否和倒数第i个数相等
                if (str.charAt(i) != str.charAt(n-1-i)) {//不相等直接break，返回当前字符串长度
                    break;
                } else if (i == n/2-1){//到达中间点，递归判断前一半字符串
                    num = minnum(str, n / 2);
                }

            }

            return num;
        }

    }

}
