package 数据结构与算法.算法.链表反向;

import 数据结构与算法.算法.Node;

/**
 * 链表反转
 * @Author ifcc
 * @Date 2018-04-25
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){

    }
    public static Node solution(Node root){
        if (root==null){
            return null;
        }
        if (root.next==null){
            return root;
        }
        Node node=root.next;
        root.next=null;
        while (node==null){
            Node temp=node.next;
            node.next=root;
            root=node;
            node=temp;
        }
        return root;
    }
}
