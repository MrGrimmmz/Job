package 工具.书籍阅读总结.程序员代码面试指南.生成窗口最大值数组;

import java.util.LinkedList;

/**
 * @Author ifcc
 * @Date 2018-05-10
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static int[] getMaxWindow(int[] arr,int w){
        if (arr==null||w<1||arr.length<w){
            return null;
        }
        LinkedList<Integer> qmax=new LinkedList<Integer>();
        int[] res=new int[arr.length-w+1];
        int index=0;
        for (int i=0;i<arr.length;i++){
            while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if (i>=w-1){
                res[index++]=arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
