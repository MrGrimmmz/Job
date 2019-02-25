package 数据结构与算法.算法.数组累加和问题;

import java.util.HashMap;
import java.util.Map;

/**
 1、给定一个数组，值全是正数，请返回累加和为给定值k的最长子数组长度。
 2、给定一个数组，值可以为正、负和0，请返回累加和为给定值k的最长子数组长度。
 3、给定一个数组，值可以为正、负和0，请返回累加和小于等于k的最长子数组长度。
 子数组必须连续，子序列可以不连续
 * @Author ifcc
 * @Date 2018-05-08
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        int result = solution2(new int[]{-1,-1,-1,-1,-1, 120, 3,2, 4},9);
        System.out.println(result);
    }
    public static int solution1(int[] array,int k){
        if (array==null||array.length<=0){
            return 0;
        }
        int i=0,t=0,sum=0,len=0;

        while (i<=t&&t<array.length){
            if (sum<=k){
                if (sum==k){
                    len=Math.max(len,t-i);
                }
                sum+=array[t];
                t++;
            }else if (sum>k){
                sum-=array[i];
                i++;
            }
        }
        return len;
    }
    public static int solution2(int[] array,int k){
        if (array==null||array.length<=0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,-1);
        int sum=0;
        int len=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i];
            if (map.containsKey(sum-k)){
                len=Math.max(len,i-map.get(sum-k));
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }
    public static int solution3(int[] array,int k){
        if (array==null|| array.length<=0){
            return 0;
        }
        int[] sums=new int[array.length];
        Map<Integer,Integer> ends=new HashMap<Integer, Integer>();
        sums[array.length-1]=array[array.length-1];
        ends.put(array.length-1,array.length-1);
        for (int i=array.length-2;i>=0;i--){
            if (sums[i+1]<=0){
                sums[i]=array[i]+sums[i+1];
                ends.put(i,ends.get(i+1));
            }else {
                sums[i]=array[i];
                ends.put(i,i);
            }
        }
        int end=0;
        int sum=0;
        int res=0;
        for (int i=0;i<array.length;i++){
            while (end<array.length && sum+sums[end]<=k){
                sum+=sums[end];
                end=ends.get(end)+1;
            }
            sum-=end>i?array[i]:0;
            res=Math.max(res,end-i);
            end=Math.max(end,i+1);
        }
        return res;
    }
}
