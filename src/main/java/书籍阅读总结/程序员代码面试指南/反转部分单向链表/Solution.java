package 书籍阅读总结.程序员代码面试指南.反转部分单向链表;

import 数据结构与算法.算法.Node;

/**
 * 给定一个单向链表的头结点head，以及两个整数from和to，在单向链表上把from个节点到第to个节点这一部分进行反转
 * @Author ifcc
 * @Date 2018-05-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){

    }
    public static Node reversePartList(Node head,int from,int to){
          int len=0;
          Node node1=head;
          Node fPre=null;
          Node tPos=null;
          while (node1!=null){
              len++;
              fPre=len==from-1?node1:fPre;
              tPos=len==to+1?node1:tPos;
              node1=node1.next;
          }
          if (from>to||from<1||to>len){
              return head;
          }
          node1=fPre==null?head:fPre.next;
          Node node2=node1.next;
          node1.next=tPos;
          Node next=null;
          while (node2!=tPos){
              next=node2.next;
              node2.next=node1;
              node1=node2;
              node2=next;
          }
          if (fPre!=null){
              fPre.next=node1;
              return head;
          }
          return node1;
    }
}
