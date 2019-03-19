package 编程题.笔试题.招行信用卡.切蛋糕;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/17 19:52
 */
public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        //判断是否满足条件
        if (n < 1) {
            return;
        }
        int[] high = new int[n];
        for (int i = 0; i < n; i++) {
            high[i] = scanner.nextInt();
        }

        //找到最小的
        int min = high[0];
        for (int i = 1; i < n; i++) {
            if (high[i] < min) {
                min = high[i];
            }
        }

        //求出所有比最小高的差值
        int all = 0;
        for (int i = 0; i < n; i++) {
            if (high[i] != min) {
                all = high[i] - min + all;
            }
        }
        //求最后结果
        int result;
        if(all%k == 0){
            result = all/k;
        }else{
            result = all/k + 1;
        }

        System.out.println(result);
    }
}
