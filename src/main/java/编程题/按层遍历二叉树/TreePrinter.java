package 编程题.按层遍历二叉树;


import java.util.*;
/**
 * @author LIFAN
 * 2019/3/17 17:37
 */
public class TreePrinter {
    //按层遍历：属于图的宽度优先遍历，需要使用队列来辅助完成
    public int[][] printTree(TreeNode root) {
            //①创建一个队列：使用链表LinkedList来实现队列
            LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
            //创建集合results用来存放遍历过的结点，每一层对应一个集合，整体结果也是一个集合，于是集合里面放集合
            ArrayList<ArrayList<TreeNode>> results=new ArrayList<ArrayList<TreeNode>>();
            //②创建临时变量temp表示当前表示当前正在访问的结点
            TreeNode temp=root;
            //③创建遍历指针last表示下一层的最后结点，nlast表示当前now正在访问的结点（不是遍历是访问），注意初始值
            TreeNode last=root;

            TreeNode nlast=null;
            //创建一个集合levelList表示每一层对应的集合，用来存放一层的结点
            ArrayList<TreeNode> levelList=new ArrayList<TreeNode>();
            //③先将根结点放入到队列中
            queue.add(root);
            //④开始循环：弹出结点--记录--放入左右结点--判断是否到层最后
            while(queue.size()!=0){
                //弹出队列，这是正在遍历的结点，放入每一层的集合
                temp=queue.poll();
                levelList.add(temp);
                //压入左右2个子节点,注意要同时移动更新nlast
                if(temp.left!=null){
                    queue.add(temp.left);
                    nlast=temp.left;
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    nlast=temp.right;
                }
                //判断是否到边
                //如果到边则换行，更新
                if(temp==last){
                    //表示到边，进行换行操作，同时更新last
                    results.add(levelList);
                    levelList=new ArrayList<TreeNode>();
                    //常识：levelList只是一个变量名称，只是中间桥梁，results通过levelList已经创建了指向集合真正位置的地址
                    last=nlast;
                }
            }
            //双重遍历将结果取出放入到二维数组中
            int[][] results2=new int[results.size()][];
            for(int i=0;i<results.size();i++){
                results2[i]=new int[results.get(i).size()];
                for(int j=0;j<results2[i].length;j++){
                    results2[i][j]=results.get(i).get(j).val;
                }
            }
            //返回结果
            return results2;
        }
}
