package 书籍阅读总结.程序员代码面试指南.打印两个有序链表的公共部分;

import 数据结构与算法.算法.Node;

/**
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 * @Author ifcc
 * @Date 2018-05-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){

    }
    public static void printCommonPart(Node head1,Node head2){
        if (head1==null||head2==null){
            return;
        }
       while (head1!=null&&head2!=null){
            if (head1.val<head2.val){
                head1=head1.next;
            }else if (head1.val>head2.val){
                head2=head2.next;
            }else {
                System.out.println(head1.val+" ");
                head1=head1.next;
                head2=head2.next;
            }
       }
    }
}
