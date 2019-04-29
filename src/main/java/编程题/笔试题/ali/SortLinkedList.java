package 编程题.笔试题.ali;

/**
 *  如何对一个单项裢表进行排序？
 *  输入：一个无序单向裢表，输出：有序递增裢表
 *  比如：
 *  输入：4->8->0->5
 *  输出：0->4->5->8
 *  要求：
 *     1.空间复杂度要求O(1)
 *     2.自定义数据结构
 *     3.不能使用JDK自带方法或库
 **/
public class SortLinkedList {

    static class Node {
        int data;
        Node next = null;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node sort(Node head){
        int temp;
        Node curNode = head;
        while(curNode != null){
            Node nextNode = curNode.next;
            while(nextNode != null){
                if(nextNode.data < curNode.data){
                    //交换
                    temp = nextNode.data;
                    nextNode.data = curNode.data;
                    curNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }


    public static Node insertNode(int data,Node head){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return head;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = node;
        return head;
    }

    public static void main(String[] args) {
        // write your code here
        Node head = null;
        head = insertNode(4,head);
        insertNode(8,head);
        insertNode(0,head);
        insertNode(5,head);

        head = sort(head);
        Node curNode = head;
        while(curNode != null){
            System.out.println(curNode.data + " ");
            curNode = curNode.next;
        }

    }
}
