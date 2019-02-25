package 书籍阅读总结.程序员代码面试指南.反向单向和双向链表;

import 数据结构与算法.算法.Node;

/**
 * @Author ifcc
 * @Date 2018-05-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){

    }
    public static Node reverseList(Node head){
        if (head==null||head.next==null){
            return head;
        }
        Node temp=head.next;
        head.next=null;
        while (temp!=null){
            Node node=temp.next;
            temp.next=head;
            head=temp;
            temp=node;
        }
        return head;
    }
    public static DoubleNode reverseDoubleList(DoubleNode head){
        if (head==null){
            return head;
        }
        DoubleNode pre=null;
        DoubleNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;

        }
        return pre;
    }
    public class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value){
            this.value=value;
        }
    }
}
