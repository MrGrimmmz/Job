package 数据结构与算法.算法.圆圈删数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。
 求出在这个圆圈中剩下的最后一个数字。
 * @Author ifcc
 * @Date 2018-04-23
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int result = solution(n, m);
        System.out.println(result);
    }
    public static int solution(int n,int m){
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            list.add(i);
        }
        int k=0;
        while (list.size()>1){
            k=k+m;
            k=k%(list.size())-1;
            if (k<0){
                list.remove(list.size()-1);
                k=0;
            }else {
                list.remove(k);
            }
        }
        return list.get(0);
    }
}
