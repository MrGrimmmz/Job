/*
package 数据结构与算法.算法.Tencent.q2;

import java.util.*;

*/
/**
 * FileName: Solution2
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/16 11:23
 * Description:
 *//*

public class Solution2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        int a, b, c;
        List<String> result=new ArrayList<>();
        Set<Integer> change=new HashSet<>();
        int setCount=0;
        int k = 1;
        while (t!=0) {
            a=scanner.nextInt();
            b=scanner.nextInt();
            c=scanner.nextInt();
            int temp = (a*k + c) % b;
            if (temp == 0)
            {
                result.add("YES");
                continue;
            }
            for (k = 2; change.size()==setCount; k++) {
                change.add(temp);
                setCount++;
                temp = (a*k + c) % b;
                if (temp == 0) {
                    result.add("YES");
                    break;
                }
            }
            if(temp!=0) {
                result.add("NO");
            }
            k = 1;
            change.clear();
            t--;
            setCount=0;
        }
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

}
*/
