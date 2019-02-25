package 数据结构与算法.算法.子数组的最大累加和;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * @Author ifcc
 * @Date 2018-05-22
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        int[] arr={-11,-2,1,-5,-2,-6,-1};
        int result = solution(arr);
        System.out.println(result);
    }
    public static int solution(int[] arr){
        int maxSum=Integer.MIN_VALUE;//支持数组全是负数
        int curSum=0;
        for (int i=0;i<arr.length;i++){
            curSum+=arr[i];
            if (curSum>maxSum){
                maxSum=curSum;
            }
            if (curSum<0){
                curSum=0;
            }
        }
        return maxSum;
    }
}
