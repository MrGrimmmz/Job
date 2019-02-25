package 数据结构与算法.算法;

/**
 * 链表节点类
 * @Author ifcc
 * @Date 2018-04-23
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Node {
    public int val;
    public Node next;
    public Node(){}
    public Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
    public Node(int val){
        this(val,null);
    }
}
