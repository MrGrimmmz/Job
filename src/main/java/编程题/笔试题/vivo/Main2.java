package 编程题.笔试题.vivo;

import java.io.*;
/**
 * @author LIFAN
 * 2019/6/10 12:16
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = parseInts(br.readLine().split(" "));
        int[] arrB = parseInts(br.readLine().split(" "));
        int m = arrA[0];
        int n = arrA[1];
        //根据数组构建链表
        ListNode head = null;
        ListNode pre = null;
        for (int v : arrB) {
            ListNode listNode = new ListNode(v);
            if (head == null) {
                head = listNode;
            }
            if (pre != null) {
                pre.next = listNode;
            }
            pre = listNode;
        }
        solution(head, m, n);

    }

    private static void solution(ListNode head, int m, int n) {

        // TODO write your code here

        if(head==null)
            return ;

        ListNode currentNode=head;
        int valueM=0;
        int valueN=0;
        int index=1;
        while(currentNode!=null){
            if(index==m){
                valueM=currentNode.val;
            }
            if(index==n){
                valueN=currentNode.val;
            }
            index++;
            currentNode=currentNode.next;
        }

        index=1;
        while(head!=null){
            if(index==m){
                index++;
                System.out.print(valueN+" ");
                head=head.next;
                continue;
            }

            if(index==n){
                index++;
                System.out.print(valueM+" ");
                head=head.next;
                continue;
            }

            index++;
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
            next = null;
        }

        public String toString() {
            String str = val + " ";
            ListNode node = next;
            while (node != null) {
                str += node.val + " ";
                node = node.next;
            }
            return str;
        }
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
}
