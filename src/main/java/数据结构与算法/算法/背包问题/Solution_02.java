package 数据结构与算法.算法.背包问题;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * （2）经典的0-1背包问题（有物品的价值）：
 给定n种物品和一个背包。物品i的重量是wi，其价值为vi，背包的容量为C。应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
 上面的两个问题都是0-1背包问题，因为隐含的信息是：对每种物品只有两种选择，即装入背包或者不装入背包。不能将物品装入多次，也不能只装入部分的物品。
 * @Author ifcc
 * @Date 2018-04-21
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution_02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();//背包容量
        int n = scanner.nextInt();//物品的数量
        int[] w=new int[n];//物品的重量
        int[] v=new int[n];//物品的价值
        for(int i=0;i<n;i++){
            w[i]=scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            v[i]=scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int value=0,tempValue=0,k=0;
        while (k<n||(!stack.empty())){
            while (k<n&&t>0){
                if (t-w[k]>=0){
                    stack.push(k);
                    t-=w[k];
                    tempValue+=v[k];
                }
                k++;
            }
            if (tempValue>value){
                value=tempValue;
                updateList(stack,list,w);
            }
            k = stack.pop();
            t+=w[k];
            tempValue-=v[k];
            k++;
        }
        System.out.println("最大价值："+value);
        System.out.println(list);
    }

    private static void updateList(Stack<Integer> stack,ArrayList<Integer> list, int[] w) {
        list.clear();
        for (Integer i:stack){
            list.add(w[i]);
        }
    }

}
