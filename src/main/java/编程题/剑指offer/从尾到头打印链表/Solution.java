package 编程题.剑指offer.从尾到头打印链表;

import java.util.Stack;
import java.util.ArrayList;
/**
 * @author LIFAN
 * 2019/3/1 20:12
 */

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        //将链表从头到尾push进栈
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        //pop出栈，存入arrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;

    }
}
