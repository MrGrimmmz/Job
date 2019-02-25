package 数据结构与算法.算法.一颗树的最大和路径;

import 数据结构与算法.算法.Tree;

/**
 * 求一棵二叉树的最大和路径
 * @Author ifcc
 * @Date 2018-04-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(tree1,tree2,3);
        solution(tree3,0);
        System.out.print(maxValue);
    }
    public static int maxValue=0;
    public static void solution(Tree root,int value){
        if(root==null){
            return;
        }
        value+=root.value;
        if (root.left==null&&root.right==null){
            if (maxValue<value){
                maxValue=value;
            }
        }
        if (root.left!=null){
            solution(root.left,value);
        }
        if (root.right!=null){
            solution(root.right,value);
        }
        value-=root.value;
    }
}
