package 工具.书籍阅读总结.程序员代码面试指南.用一个栈实现另一个栈的排序;

import java.util.Stack;

/**
 * 一个栈中元素的类型为整形，现在将该栈从顶到底按从大到小的顺序排序，只允许申请一个栈，除此之外，可以申请新的变量，但不能申请额外的数据结构
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            Integer cur = stack.pop();
            while (!help.isEmpty()&&help.peek()<cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
