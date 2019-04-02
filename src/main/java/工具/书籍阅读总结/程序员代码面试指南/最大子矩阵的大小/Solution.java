package 工具.书籍阅读总结.程序员代码面试指南.最大子矩阵的大小;

import java.util.Stack;

/**
 * 给定一个整形矩阵map，其中的值只有0和1两种，求其中全是1的所有矩阵区域中，最大矩形区域为1的数量
 * @Author ifcc
 * @Date 2018-05-14
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        int[][] input={
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };
        int result = maxRecSize(input);
        System.out.println(result);
    }
    public static int maxRecSize(int[][] map){
        if (map==null||map.length==0||map[0].length==0){
            return 0;
        }
        int maxArea=0;
        int[] height=new int[map[0].length];
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                height[j]=map[i][j]==0?0:height[j]+1;
            }
            maxArea=Math.max(maxArea,maxRecFromBottom(height));
        }
        return maxArea;
    }

    private static int maxRecFromBottom(int[] height) {
        if (height==null||height.length<=0){
            return 0;
        }
        int maxArea=0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty()&&height[stack.peek()]>=height[i]){
                Integer pop = stack.pop();
                int k=stack.isEmpty()?(-1):stack.peek();
                maxArea=Math.max(maxArea,(i-k-1)*height[pop]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            int k=stack.isEmpty()?(-1):stack.peek();
            maxArea=Math.max(maxArea,(height.length-k-1)*height[pop]);
        }
        return maxArea;
    }
}
