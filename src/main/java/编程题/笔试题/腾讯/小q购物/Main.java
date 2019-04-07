package 编程题.笔试题.腾讯.小q购物;

/**
 * @author LIFAN
 * 2019/4/3 20:44
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long m = scan.nextLong();
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);
        int num = 0;
        int sum = 0;

        if(arr[0]!=1){
            num = -1;
        } else {
            while(true) {
                if(sum>=m) {
                    break;
                }
                for(int i=n;i>=1;i--){
                    if(arr[i-1]<=sum+1) {
                        sum+=arr[i-1];
                        num++;
                        break;
                    }
                }

            }
        }
        int result = num;

        System.out.println(result);
    }

}

