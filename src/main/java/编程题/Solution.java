package 编程题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Solution {

    public static int Calulate(int[] h,int n){
        int k = 0;

        int minOfe = 0;
        int e = 0;

        for(int j=1;j<=n;j++){
            for(int i=0;i<j;i++){
                k += solute(j-i-1) * h[i];
            }
            while(solute(j)*e < k){
                e++;
            }
            if(e > minOfe){
                minOfe = e;
            }
            e = 0;
            k = 0;
        }

        return minOfe;
    }

    public static long solute(int n) {
        long res = 1;
        for(int i = 0;i<n;i++){
            res *= 2;
        }
        return res;
    }

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();

        int n = 3;
        int[] h = new int[n];
//        for(int i=0;i<n;i++){
//            h[i] = scanner.nextInt();
//        }
        h[0] = 4;h[1] = 4;h[2] = 4;
        int result = Calulate(h,n);

        System.out.println(result);
    }

}

