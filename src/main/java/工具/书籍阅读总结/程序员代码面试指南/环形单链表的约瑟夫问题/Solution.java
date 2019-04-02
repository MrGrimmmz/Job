package 工具.书籍阅读总结.程序员代码面试指南.环形单链表的约瑟夫问题;


import 数据结构与算法.算法.Node;

/**
 * @Author ifcc
 * @Date 2018-05-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static Node josephuKill1(Node head,int m){
        if (head==null||head.next==head||m<1){
            return head;
        }
        Node last=head;
        while (last.next!=head){
            last=last.next;
        }
        int count=0;
        while (last!=head){
            if (++count==m){
                last.next=head.next;
                count=0;
            }else {
                last=last.next;
            }
            head=last.next;
        }
        return head;
    }

    public static Node josephuKill2(Node head,int m){
        if (head==null||head.next==head||m<1){
            return head;
        }

        return null;
    }
}
