package 工具.书籍阅读总结.程序员代码面试指南.删除链表的中间节点和ab处的节点;

import 数据结构与算法.算法.Node;

/**
 * @Author ifcc
 * @Date 2018-05-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        Node result = removeabNode(node1, 0.3);
        System.out.println(result.next.val);
    }
    public static Node removeMidNode(Node head){
        if (head==null||head.next==null){
            return head;
        }
        if (head.next.next==null){
            return head.next;
        }
        Node temp1=head;
        Node temp2=head.next.next;
        while (temp2.next!=null&&temp2.next.next!=null){
            temp1=temp1.next;
            temp2=temp2.next.next;
        }
        temp1.next=temp1.next.next;
        return head;
    }
    public static Node removeabNode(Node head,double r){
        if (head==null||r<0||r>1){
            return head;
        }
        int length=0;
        Node temp=head;
        while (temp!=null){
            temp=temp.next;
            length++;
        }
        int index = (int) Math.ceil(r * length);
        if (index==1){
            return head.next;
        }
        temp=head;
        while (index>2){
            temp=temp.next;
            index--;
        }
        temp.next=temp.next.next;
        return head;
    }
}
