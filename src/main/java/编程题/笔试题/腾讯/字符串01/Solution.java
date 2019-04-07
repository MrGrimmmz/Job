package 编程题.笔试题.腾讯.字符串01;

import java.util.*;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Solution {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int a = 0;
        int b = 0;

        for(int i=0; i<n; i++){
            char tmp = s.charAt(i);
            if(tmp=='0'){
                a++;
            } else{
                b++;
            }
        }
        int res = Math.abs(a-b);

        System.out.println(res);
    }

}

