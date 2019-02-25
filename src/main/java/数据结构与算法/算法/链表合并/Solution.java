package 数据结构与算法.算法.链表合并;

import 数据结构与算法.算法.Node;

/**
 * 链表合并
 * @Author ifcc
 * @Date 2018-04-25
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Node node2=new Node(6);
        Node node1 = new Node(5,node2);
        Node root1 = new Node(2,node1);

        Node node4=new Node(7);
        Node node3 = new Node(3,node4);
        Node root2 = new Node(1,node3);
        Node root = solution(root1, root2);
        while (root!=null){
            System.out.println(root.val);
            root=root.next;
        }
    }
    public static Node solution(Node root1,Node root2){
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        Node root,pre;

        if (root1.val<=root2.val){
            root=root1;
            pre=root1;
            root1=root1.next;
        }else {
            root=root2;
            pre=root2;
            root2=root2.next;
        }
        while (root1!=null && root2!=null){
            if (root1.val<=root2.val){
                pre.next=root1;
                root1=root1.next;
                pre=pre.next;
            }else {
                pre.next=root2;
                root2=root2.next;
                pre=pre.next;
            }
        }
        if (root1!=null){
            pre.next=root1;
            root1=root1.next;
            pre=pre.next;
        }
        if (root2!=null){
            pre.next=root2;
            root2=root2.next;
            pre=pre.next;
        }
        return root;
    }
}
