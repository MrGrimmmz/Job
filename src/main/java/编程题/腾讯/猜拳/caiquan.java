package 编程题.腾讯.猜拳;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/9 20:42
 */
public class caiquan {
    public static int result=0;

    private static int qiuzuhe(int n,int s){
        int[][] array = new int[n+1][s+1];
        array[0][0] = 1;
        for(int i = 1;i <= n;i++){
            array[i][0] = 1;
            for(int j = 1;j <= s;j++){
                array[i][j] =(array[i-1][j-1] + array[i-1][j])%1000000007;
            }
        }
        return array[n][s];
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        if(n < s){
            return;
        }
        //求2的k次方
        int res = 1;
        int k = n-s;
        for(int i=0;i<k;i++){
            res = 2*res;
        }

        System.out.println((qiuzuhe(n,s)*res)%1000000007);
    }
}
