package 数据结构与算法.算法.pdd;

import java.util.Scanner;

/**
 * FileName: Question1
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/7/22 19:01
 * Description:
 */
public class Question1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N<=0){
            return;
        }
        /*switch (N){
            case 1:
                System.out.println("Alice");
                return;
            case 2:
                System.out.println();
        }*/
        int temp=N;
        int max=0;
        while (temp!=0){
            max=temp;
            temp=temp&(temp-1);
        }
        //max=max*2;
        if(max<4){
            max=0;
        }
        int t=N-(max*2-4);


      /*  int t=0;
        if (N<4){
            max=4;
            t=N;
        }else {
            t=N-max;
        }*/

        //System.out.println(t);
        double d=(double) t/max;
        if (d>0&&d<=0.25){
            System.out.println("Alice");
        }else if (d>0.25&&d<=0.5){
            System.out.println("Bob");
        }else if (d>0.5&&d<=0.75){
            System.out.println("Cathy");
        }else {
            System.out.println("Dave");
        }
    }


}
