package 数据结构与算法.算法.糖果;

import java.util.Scanner;

/**
 * @Author ifcc
 * @Date 2018-04-19
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] array = new int[n][2];
        for (int i=0;i<n;i++){
            array[i][0]=scanner.nextInt();
            array[i][1]=scanner.nextInt();
        }

    }

    private static void update(int[][]array,int m){
        for (int i=0;i<array.length;i++){
            if (array[i][0]<array[i][1] && sum(array)<m){
                array[i][0]++;
            }
        }

    }
    private static int sum(int[][]array){
        int sum=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i][0];
        }
        return sum;
    }
}
