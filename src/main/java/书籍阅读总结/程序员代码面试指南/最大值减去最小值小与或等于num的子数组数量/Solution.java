package 书籍阅读总结.程序员代码面试指南.最大值减去最小值小与或等于num的子数组数量;

import java.util.LinkedList;

/**
 * @Author ifcc
 * @Date 2018-05-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){

    }
    public static int getNum(int[] arr,int num){
        if (arr==null||arr.length<=0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int i=0;
        int j=0;
        int res=0;
        while (i<arr.length){
            while (j<arr.length){
                 while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
                     qmin.pollLast();
                 }
                 qmin.addLast(j);
                 while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
                     qmax.pollLast();
                 }
                 qmax.addLast(j);
                 if (arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                     break;
                 }
                 j++;
            }
            if (qmin.getFirst()==i){
                qmin.pollFirst();
            }
            if (qmax.getFirst()==i){
                qmax.pollFirst();
            }
            res+=j-i;
            i++;
        }
        return res;
    }
}
