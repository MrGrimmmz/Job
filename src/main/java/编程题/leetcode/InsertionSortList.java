package 编程题.leetcode;

/**
 * @author LIFAN
 * 2019/5/18 22:15
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class InsertionSortList {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
        // 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
        // 每次迭代完成，从插入元素为止，该链表可以被认为已经部分排序
        // 重复直到所有输入数据插入完为止

        // 1.遍历并与前面已经有序的序列向前逐一比较排序，找到合适为止插入

        // 定义三个指针 辅助节点aux,pre, cur
        //aux     pre    cur
        //aux  ->  4  ->  2  ->  5  ->  3  ->  null

        ListNode pre = head;//pre指向已经有序的节点
        ListNode cur = head.next;//cur指向待排序的节点

        //辅助节点
        ListNode aux = new ListNode(-1);
        aux.next = head;

        while(cur!=null){
            if(cur.val<pre.val){
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                //记录下一个要插入排序的值
                pre.next = cur.next;

                //从前往后找到l2.val>cur.val,然后把cur节点插入到l1和l2之间
                ListNode l1 = aux;
                ListNode l2 = aux.next;
                while(cur.val>l2.val){
                    l1 = l2;
                    l2 = l2.next;
                }
                //把cur节点插入到l1和l2之间
                l1.next = cur;
                cur.next = l2;//插入合适位置

                cur = pre.next;//指向下一个待处理节点

            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }
}
