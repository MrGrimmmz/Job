package 数据结构与算法.算法.和为m的所有组合;

import javafx.scene.shape.SVGPath;

import java.util.Scanner;

/**
 *  输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,
 使其和等于 m ,要求将其中所有的可能组合列出来.
 * @Author ifcc
 * @Date 2018-04-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        solution(n,m,new int[n]);
    }
    public static void solution(int n,int m,int[] array){
        if(n<1||m<1){
            return;
        }
        if (n<m){
            array[n-1]=1;
            solution(n-1,m-n,array);
            array[n-1]=0;
            solution(n-1,m,array);
        }else {
            array[m-1]=1;
            boolean flag=true;
            for (int i=0;i<array.length;i++){
                if (array[i]==1){
                    if (flag){
                        System.out.print(i+1);
                        flag=false;
                    }else {
                        System.out.print(" "+(i+1));
                    }

                }
            }
            System.out.println();
            array[m-1]=0;
            solution(m-1,m,array);
        }
    }
}
