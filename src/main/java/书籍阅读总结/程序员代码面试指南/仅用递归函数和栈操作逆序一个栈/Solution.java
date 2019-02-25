package 书籍阅读总结.程序员代码面试指南.仅用递归函数和栈操作逆序一个栈;

import java.util.Stack;

/**
 * 一个栈依次压入1，2，3，4，5，那么从栈顶到栈底元素分别是5，4，3，2，1，将这个栈转置之后，也就是实现栈的逆序，从栈顶到栈底的元素分别是
 * 1，2，3，4，5，只能使用递归函数实现，不能使用其他数据结构
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        Integer value = stack.pop();
        if (stack.empty()){
            return value;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(value);
        return last;
    }
    public static void reverse(Stack<Integer> stack){
        if (stack.empty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

}
