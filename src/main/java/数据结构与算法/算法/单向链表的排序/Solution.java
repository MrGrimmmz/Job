package 数据结构与算法.算法.单向链表的排序;

import 数据结构与算法.算法.Node;

import java.util.Scanner;

/**
 * 单向链表的排序
 * @Author ifcc
 * @Date 2018-04-23
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
       /* Node node=root;
        while (node.next!=null){
            node=node.next;
        }*/
    }
    public static void mergeSort(Node left,Node right){
        if (left!=right){
            Node middle = getMiddleNode(left, right);
            mergeSort(left,middle);
            mergeSort(middle.next,right);
            merge(left,middle,right);
        }

    }

    private static void merge(Node left, Node middle, Node right) {
        Node rightIndex=middle.next;
        Node temp=left;
        Node newNode=new Node();
        Node newTemp=newNode;
        if (left.val<=rightIndex.val){
            newTemp.val=left.val;
            left=left.next;
        }else {
            newTemp.val=rightIndex.val;
            rightIndex=rightIndex.next;
        }
        while (left!=null&&rightIndex!=null){
            if (left.val<=rightIndex.val){
                newTemp.next=new Node(left.val);
                left=left.next;
                newTemp=newTemp.next;
            }else {
                newTemp.next=new Node(rightIndex.val);
                rightIndex=rightIndex.next;
                newTemp=newTemp.next;
            }

        }
        while (left!=null){
            newTemp.next=new Node(left.val);
            left=left.next;
            newTemp=newTemp.next;
        }
        while (rightIndex!=null){
            newTemp.next=new Node(rightIndex.val);
            rightIndex=rightIndex.next;
            newTemp=newTemp.next;
        }

        while (newNode!=null&&temp!=null){
            temp.val=newNode.val;
            temp=temp.next;
            newNode=newNode.next;
        }
    }

    public static Node getMiddleNode(Node left,Node right){
        if (left==right||left.next==right)
            return left;
        Node temp1=left.next;
        Node temp2=left.next.next;
        while (temp2!=null&&temp2!=right){
            temp1=temp1.next;
            temp2=temp2.next.next;
        }
        return temp1;
    }
}
