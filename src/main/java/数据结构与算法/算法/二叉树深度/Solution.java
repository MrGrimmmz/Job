package 数据结构与算法.算法.二叉树深度;

import 数据结构与算法.算法.Tree;

/**
 * 二叉树深度算法
 * FileName: Cake
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/7/27 0:01
 * Description:
 */
public class Solution {

    public static int solution(Tree root){
        if (root==null){
            return 0;
        }
        int leftDepth = solution(root.left) + 1;
        int rightDepth=solution(root.right) + 1;
        return leftDepth>rightDepth?leftDepth:rightDepth;
    }

    public static void main(String[] args){
        Tree tree3=new Tree(20);
        Tree tree1 = new Tree(tree3,null,1);
        Tree tree2 = new Tree(2);
        Tree root = new Tree(tree1,tree2,3);
        int depth = solution(root);
        System.out.println(depth);
    }


}
