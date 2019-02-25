package 数据结构与算法.算法.DIDI.q1;

import java.util.Scanner;

/**
 * 给定三种类型的小球P、Q、R，每种小球的数量分别为np、nq、nr个。现在想将这些小球排成一条直线，但是不允许相同类型的小球相邻，问有多少种排列方法。如若np=2，nq=1，nr=1则共有6种排列方式：PQRP，QPRP，PRQP，RPQP，PRPQ以及PQPR。 如果无法组合出合适的结果，则输出0。
 * FileName: Solution
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/18 20:18
 * Description:
 */
public class Solution {
    private static int result=0;
    private static String pre;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int np = scanner.nextInt();
        int nq = scanner.nextInt();
        int nr = scanner.nextInt();
        /*if (Math.abs(np-nq-nr)>1||Math.abs(nq-np-nr)>1||Math.abs(nr-nq-np)>1){
            System.out.println("0");
            return;
        }*/
        solution(np,nq,nr);
        System.out.println(result);
    }

    public static void solution(int np,int nq,int nr){
        if (np==0||nq==0||nr==0){
            if (((nq==np)&&nq!=0)||((nr==np)&&nr!=0)||((nq==nr)&&nq!=0)){
                result+=2;
                return;
            }
            if ((Math.abs(nq-np)==1&&nr==0)||(Math.abs(nr-np)==1&&nq==0)||(Math.abs(nq-nr)==1&&np==0)){
                result++;
                return;
            }
           return;
        }
        /*if ((np>=3&&(nq+nr)<=1)||(nq>=3&&(np+nr)<=1)||(nr>=3&&(nq+np)<=1)){
            return;
        }*/
        if (np>0&&!"p".equalsIgnoreCase(pre)){
            pre="p";
            solution(np-1,nq,nr);
        }
        if (nq>0&&!"q".equalsIgnoreCase(pre)){
            pre="q";
            solution(np,nq-1,nr);
        }
        if (nr>0&&!"r".equalsIgnoreCase(pre)){
            pre="r";
            solution(np,nq,nr-1);
        }
    }
}
