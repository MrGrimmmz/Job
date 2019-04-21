package 数据结构与算法.数据结构.遍历二叉树;

/**
 * @author LIFAN
 * 2019/3/10 12:37
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;

public class BinTree {
    private char data;
    private BinTree lchild;
    private BinTree rchild;

    public BinTree(char c) {
        data = c;
    }

    // 先序遍历递归
    public static void preOrder(BinTree t) {
        if (t == null) {
            return;
        }
        System.out.print(t.data);
        preOrder(t.lchild);
        preOrder(t.rchild);
    }

    // 中序遍历递归
    public static void InOrder(BinTree t) {
        if (t == null) {
            return;
        }
        InOrder(t.lchild);
        System.out.print(t.data);
        InOrder(t.rchild);
    }

    // 后序遍历递归
    public static void PostOrder(BinTree t) {
        if (t == null) {
            return;
        }
        PostOrder(t.lchild);
        PostOrder(t.rchild);
        System.out.print(t.data);
    }

    // 先序遍历非递归
    public static void preOrder2(BinTree t) {
        Stack<BinTree> s = new Stack<BinTree>();
        while (t != null || !s.empty()) {
            while (t != null) {
                System.out.print(t.data);
                s.push(t);
                t = t.lchild;
            }
            if (!s.empty()) {
                t = s.pop();
                t = t.rchild;
            }
        }
    }

    // 中序遍历非递归
    public static void InOrder2(BinTree t) {
        Stack<BinTree> s = new Stack<BinTree>();
        while (t != null || !s.empty()) {
            //一直遍历左孩子，入栈
            while (t != null) {
                s.push(t);
                t = t.lchild;
            }
            //到达左子树最下边，需要出栈
            if (!s.empty()) {
                t = s.pop();
                System.out.print(t.data);
                t = t.rchild;
            }
        }
    }

    // 后序遍历非递归
    public static void PostOrder2(BinTree t) {
        Stack<BinTree> s = new Stack<BinTree>();
        Stack<Integer> s2 = new Stack<Integer>();
        Integer i = new Integer(1);
        while (t != null || !s.empty()) {
            while (t != null) {
                s.push(t);
                s2.push(new Integer(0));
                t = t.lchild;
            }
            while (!s.empty() && s2.peek().equals(i)) {
                s2.pop();
                System.out.print(s.pop().data);
            }

            if (!s.empty()) {
                s2.pop();
                s2.push(new Integer(1));
                t = s.peek();
                t = t.rchild;
            }
        }
    }

    /**
     * 对列法实现二叉树广度优先遍历，队列遵循先进先出的规则，适合本方法
     * @param root
     */
    public static void levelOrer(BinTree root){
        Queue<BinTree> queue = new LinkedList<BinTree>();//新增队列

        if(root != null){
            queue.add(root);//将根节点加入队列
        }

        while (!queue.isEmpty()){
            BinTree cur = queue.peek();//创建cur的目的是在while循环的时候逐层将树带入，如果直接用root,会导致只能输出一级树
            System.out.print(cur.data + " ");
            queue.remove();
            if (cur.lchild != null){
                queue.add(cur.lchild);//先将左分支加入队列，之后先输出
            }
            if(cur.rchild != null){
                queue.add(cur.rchild);
            }
        }

    }

    public static void main(String[] args) {
        BinTree b1 = new BinTree('a');
        BinTree b2 = new BinTree('b');
        BinTree b3 = new BinTree('c');
        BinTree b4 = new BinTree('d');
        BinTree b5 = new BinTree('e');

        /**
         *      a
         *     / \
         *    b   c
         *   / \
         *  d   e
         */
        b1.lchild = b2;
        b1.rchild = b3;
        b2.lchild = b4;
        b2.rchild = b5;

//        BinTree.preOrder(b1);
//        System.out.println();
//        BinTree.preOrder2(b1);
//        System.out.println();
//        BinTree.InOrder(b1);
//        System.out.println();
//        BinTree.InOrder2(b1);
//        System.out.println();
//        BinTree.PostOrder(b1);
//        System.out.println();
        BinTree.PostOrder2(b1);
//        System.out.println();
//        BinTree.levelOrer(b1);
    }
}