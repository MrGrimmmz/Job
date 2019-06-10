package 编程题.笔试题.vivo;

import java.io.*;

/**
 * @author LIFAN
 * 2019/6/10 12:13
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = parseInts(br.readLine().split(" "));
        int[] arrB = parseInts(br.readLine().split(" "));
        solution(arrA, arrB);
    }

    private static void solution(int[] array1, int[] array2) {

        //TODO write your code here
        for(int i = 0; i < array1.length; i++){
            if(java.util.Arrays.binarySearch(array2,array1[i]) < 0){
                System.out.print(array1[i] + " ");
            }
        }


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
