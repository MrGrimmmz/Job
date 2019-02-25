package 数据结构与算法.算法.背包问题;

import java.util.Scanner;
import java.util.Stack;

/**
 * （1）经典的0-1背包问题（无物品的价值）：
 假设有一个能装入容量为C的背包和n件重量分别为w1,w2,,...,wn的物品，能否从n件物品中挑选若干件恰好装满背包,要求找出所有满足上述条件的解。
 当C=10,各件物品重量为{1,8,4,3,5,2}时，可以找到下列4组解：(1,4,3,2)、(1,4,5)、(8,2)和(3,5,2)。
 根据这个问题的一个变形是：
 已知一个数为C，一个长度为n的无序的数组，分别是数w1,w2,...,wn，能否从这n个数中找到若干个数使其和等于数C,要求找出所有满足上述条件的解。
 * @Author ifcc
 * @Date 2018-04-21
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution_01 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();//背包的容量
        int n = scanner.nextInt();//物品的数量
        int[] v = new int[n];//物品的体积数组
        for (int i=0;i<n;i++){
            v[i]=scanner.nextInt();
        }
        int k=0;
        Stack<Integer> stack = new Stack<Integer>();
        while ((!stack.empty()) || k<n){
            while (c>0&&k<n){
                if (c-v[k]>=0){
                    stack.push(k);
                    c-=v[k];
                }
                k++;
            }

            if (c==0){
                showStack(stack,v);
            }
            k = stack.pop();
            c+=v[k];
            k++;
        }
    }

    private static void showStack(Stack<Integer> stack,int[] v) {
        if (stack==null||stack.empty()){
            return;
        }
        System.out.print(v[stack.elementAt(0)]);
        for (int i=1;i<stack.size();i++){
            System.out.print(" "+v[stack.elementAt(i)]);
        }
        System.out.println();

    }
}
