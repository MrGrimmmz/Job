package 编程题.leetcode;

/**
 * @author LIFAN
 * 2019/5/18 12:24
 */
public class MinimumDepthOfTree {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public int run(TreeNode root) {
        //终止条件
        if(root == null){
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);
        if(left == 0 || right == 0){
            return left + right + 1;
        }
        //一般条件
        return Math.min(left, right) + 1;
    }

}
