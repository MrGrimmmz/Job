package 书籍阅读总结.程序员代码面试指南.设计一个有getMin功能的栈;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，在实现返回栈中最小元素的操作
 * 要求：pop，push和getMin操作的时间复杂度都是O(1)
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class MinStack {
    public static void main(String[] args){

    }
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }
    public void push(int value){
        this.stackData.push(value);
        if (stackMin.empty()){
            stackMin.push(value);
        }else {
            if (value<=stackMin.peek()){
                stackMin.push(value);
            }
        }
    }

    public Integer push() throws Exception {
        if (stackData.empty()){
            throw new Exception("stack is empty!");
        }
        Integer result = stackData.pop();
        if (result==stackMin.peek()){
            stackMin.pop();
        }
        return result;
    }

    public Integer getMin() throws Exception {
        if (stackMin.empty()){
            throw new Exception("stack is empty!");
        }
        return stackMin.peek();
    }


}
