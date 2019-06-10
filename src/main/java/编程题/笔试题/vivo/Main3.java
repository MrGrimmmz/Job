package 编程题.笔试题.vivo;

import java.io.*;

/**
 * @author LIFAN
 * 2019/6/10 12:17
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] arrA = parseInts(br.readLine().split(" "));
        int[] arrB = parseInts(br.readLine().split(" "));
        solution(total, arrA, arrB);

    }

    private static void solution(int total, int[] arrA, int[] arrB) {

        // TODO write your code here

        //动态规划
        int N=arrA.length;
        int[] dp = new int[total+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=total;j>=arrA[i-1];j--){
                dp[j] = Math.max(dp[j-arrA[i-1]]+arrB[i-1],dp[j]);
            }
        }
        System.out.println(dp[total]);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
}
