package 数据结构与算法.算法.JD.首都防卫问题;

import java.util.Scanner;
import java.util.Stack;

/**
 * 小B负责首都的防卫工作
 * 首都处于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，日夜不停地瞭望周围发生的情况
 * 一旦发生外敌入侵事件，山顶上的岗哨将点燃烽烟
 * 若两个岗哨所在的山峰之间的那些山峰，高度都不大于这两座山峰，且这两个山峰之间有相连的通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃
 * 由于小山处于环上，任意两个小山之间存在两个不同的连接通路，满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到
 * 对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟
 * 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量
 * @Author ifcc
 * @Date 2018-05-22
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(communications(arr));
        }
    }

    /**
     * 两种情况，第一种：山峰的高度都不相同，岗哨对的数量是 2*n-3
     * 第二种，山峰的高度存在相同，单调栈
     */
    public static void solution(int[] arr){

    }

    public static int nextIndex(int size,int i){
        return i<(size-1)?(i+1):0;
    }


    public static long getInternalSum(int n){
        return n==1L?0L:(long) n*(long) (n-1)/2L;
    }

    public static class Pair{
        public int value;
        public int times;
        public Pair(int value){
            this.value=value;
            this.times=1;
        }
    }

    public static long communications(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        int size=arr.length;
        int maxIndex=0;
        for (int i=0;i<size;i++){
            maxIndex=arr[maxIndex]<arr[i]?i:maxIndex;
        }
        int value=arr[maxIndex];
        int index=nextIndex(size,maxIndex);
        long res=0L;
        Stack<Pair> stack=new Stack<Pair>();
        stack.push(new Pair(value));
        while (index!=maxIndex){
            value=arr[index];
            while (!stack.isEmpty()&&stack.peek().value<value){
                int times = stack.pop().times;
                res+=getInternalSum(times)+times*2;//关键
            }
            if (!stack.isEmpty()&&stack.peek().value==value){
                stack.peek().times++;
            }else {
                stack.push(new Pair(value));
            }
            index=nextIndex(size,index);
        }
        while (!stack.isEmpty()){
            int times=stack.pop().times;
            res+=getInternalSum(times);
            if (!stack.isEmpty()){
                res+=times;
                if (stack.size()>1){
                    res+=times;
                }else {
                    res+=stack.peek().times>1?times:0;
                }
            }
        }
        return res;
    }
}
