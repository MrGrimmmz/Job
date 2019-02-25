package 书籍阅读总结.程序员代码面试指南.由两个栈组成的队列;

import java.util.Stack;

/**
 * 编写一个类，用两个栈实现队列，支持队列的基本操作add，pop，peek
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public void add(Integer value){
        stackPush.push(value);
    }
    public Integer pop() throws Exception {
        if (stackPop.empty()){
            if (stackPush.empty()){
                throw new Exception("queue is empty!");
            }else {
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        return stackPop.pop();

    }
    public Integer peek() throws Exception {
        if (stackPop.empty()){
            if (stackPush.empty()){
                throw new Exception("queue is empty!");
            }else {
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        return stackPop.peek();
    }

}
