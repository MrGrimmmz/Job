package 书籍阅读总结.程序员代码面试指南.构造数组的MaxTree;

import 数据结构与算法.算法.Tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author ifcc
 * @Date 2018-05-10
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        int[] arr={3,2,4,1};
        Tree tree = getMaxTree(arr);
        System.out.println(tree.value);
        System.out.println(tree.left.value);
        System.out.println(tree.right.value);
        if (tree.left.left!=null){
            System.out.println(tree.left.left.value);
        }else if (tree.left.right!=null){
            System.out.println(tree.left.right.value);
        }
    }

    public static Tree getMaxTree(int[] arr){
        Tree[] nArr=new Tree[arr.length];
        for(int i=0;i!=arr.length;i++){
            nArr[i]=new Tree(arr[i]);
        }
        Stack<Tree> stack=new Stack<Tree>();
        HashMap<Tree, Tree> lBigMap=new HashMap<Tree,Tree>();
        HashMap<Tree, Tree> rBigMap=new HashMap<Tree,Tree>();
        for(int i=0;i!=nArr.length;i++){
            Tree curNode=nArr[i];
            while((!stack.isEmpty())&&stack.peek().value<curNode.value){
                popStackSetMap(stack,lBigMap);

            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }
        for(int i=nArr.length-1;i!=-1;i--){
            Tree curNode=nArr[i];
            while((!stack.isEmpty())&&stack.peek().value<curNode.value){
                popStackSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,rBigMap);
        }
        Tree head=null;
        for(int i=0;i!=nArr.length;i++){
            Tree curNode=nArr[i];
            Tree left=lBigMap.get(curNode);
            Tree right=rBigMap.get(curNode);
            if(left==null&&right==null){
                head=curNode;
            }else if(left==null){
                if(right.left==null){
                    right.left=curNode;
                }else{
                    right.right=curNode;
                }
            }else if(right==null){
                if(left.left==null){
                    left.left=curNode;
                }else{
                    left.right=curNode;
                }
            }else{
                Tree parent=left.value<right.value?left:right;
                if(parent.left==null){
                    parent.left=curNode;

                }else{
                    parent.right=curNode;
                }
            }
        }

        return head;
    }
    public static void popStackSetMap(Stack<Tree> stack,HashMap<Tree, Tree> map){
        Tree popNode=stack.pop();
        if(stack.isEmpty()){
            map.put(popNode, null);
        }else{
            map.put(popNode, stack.peek());
        }

    }
}
