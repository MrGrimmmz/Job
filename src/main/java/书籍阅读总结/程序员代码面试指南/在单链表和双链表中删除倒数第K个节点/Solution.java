package 书籍阅读总结.程序员代码面试指南.在单链表和双链表中删除倒数第K个节点;

import 数据结构与算法.算法.Node;

/**
 * 分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表倒数第K个节点
 * @Author ifcc
 * @Date 2018-05-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){

    }
    public static Node removeLastKthNode(Node head,int k){
        Node temp=head;
        Node result=head;
        for (int i=0;i<k;i++){
            if (temp==null){
                return result;
            }
            temp=temp.next;
        }
        if (temp==null){
            return result.next;
        }
        while (temp.next!=null){
            temp=temp.next;
            head=head.next;
        }
        head.next=head.next.next;
        return result;
    }

    public static DoubleNode removeLastKthNode(DoubleNode head,int k){
        DoubleNode temp=head;
        DoubleNode result=head;
        for (int i=0;i<k;i++){
            if (temp==null){
                return result;
            }
            temp=temp.next;
        }
        if(temp==null){
            result=result.next;
            result.last=null;
            return result;
        }
        while (temp.next!=null){
            temp=temp.next;
            head=head.next;
        }
        temp=head.next.next;
        head.next=temp;
        if(temp!=null){
            temp.last=head;
        }
        return result;
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
