package 数据结构与算法.算法.栈的push和pop序列;

import java.util.Stack;

/**
 * 输入两个整数序列。其中一个序列表示栈的push顺序，
 判断另一个序列有没有可能是对应的pop顺序。
 为了简单起见，我们假设push序列的任意两个整数都是不相等的。

 比如输入的push序列是1、2、3、4、5，那么4、5、3、2、1就有可能是一个pop系列。
 因为可以有如下的push和pop序列：
 push 1，push 2，push 3，push 4，pop，push 5，pop，pop，pop，pop，
 这样得到的pop序列就是4、5、3、2、1。
 但序列4、3、5、1、2就不可能是push序列1、2、3、4、5的pop序列。
 * @Author ifcc
 * @Date 2018-04-26
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        int[] push={1,2,3,4,5};
        int[] pop={4,3,5,1,2};
        boolean result = solution(push, pop);
        System.out.println(result);
    }
    public static boolean solution(int[] push,int[] pop){
        if (push==null||pop==null||push.length!=pop.length){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i=0,j=0;
//        stack.push(push[i]);
        while (i<push.length||((!stack.empty())&&stack.peek()==pop[j])){
            if ((!stack.empty())&&stack.peek()==pop[j]){
                stack.pop();
                j++;
            }else {
                stack.push(push[i]);
                i++;
            }
        }
        if (j==pop.length){
            return true;
        }else {
            return false;
        }
    }
}
