package 编程题.笔试题.招行信用卡.大鱼吃小鱼数列;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/17 20:20
 */
public class shulie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //判断是否满足条件
        if (n < 1) {
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int zhengshu = 0;
        int fushu = 0;
        for(int i=0;i<n;i++){
            if(arr[i] > 0){
                zhengshu += arr[i];
            }else{
                fushu += arr[i];
            }
        }

        int result;
        int max = arr[0];
        int min = arr[0];
        if(zhengshu == 0){
            for(int i=1;i<n;i++){
                if(arr[i] > max) {
                    max = arr[i];
                }
            }
            result = 0 - fushu + 2*max;
        }else if(fushu == 0){
            for(int i=1;i<n;i++){
                if(arr[i] < min) {
                    min = arr[i];
                }
            }
            result = zhengshu - 2*min;
        }else{
            result = zhengshu - fushu;
        }

        System.out.println(result);

    }
}
