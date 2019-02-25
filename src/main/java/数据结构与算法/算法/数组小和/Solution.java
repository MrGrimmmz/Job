package 数据结构与算法.算法.数组小和;

/**
 *数组小和的定义如下：
 * 例如，数组s=[1,3,5,2,4,6],在s[0]的左边小于或等于s[0]的数的和为0，在s[1]的左边小于等于s[1]的数的和为1，在s[2]的左边小于或等于s[2]的数的和为
 * 1+3=4，在s[3]的左边小于或等于s[3]的数的和为1,在s[4]的左边小于或等于s[4]的数的和为1+3+2=6，在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15
 * 所以s的小和为0+1+4+1+6+15=27
 * @Author ifcc
 * @Date 2018-05-22
 * @School SouthEast University
 * @Verstion 1.0
 * 归并排序思路
 **/
public class Solution {
    public static void main(String[] args){
        int[] array={1,3,5,2,4,6};
        solution(array,0,array.length-1);
        System.out.println(smallSum);
    }
    private static int smallSum=0;
    private static void solution(int[] array,int start,int end){
        if (array==null||array.length<=0){
            return;
        }
        if (start<end){
            int mid = (start+end) >> 1;
            solution(array,start,mid);
            solution(array,mid+1,end);
            merge(array,start,end,mid);
        }
    }
    private static void merge(int[] array,int start,int end,int mid){
        int leftIndex=start;
        int rightIndex=mid+1;
        int newIndex=start;
        int[] newArray=new int[array.length];
        while (leftIndex<=mid&&rightIndex<=end){
            if (array[leftIndex]<=array[rightIndex]){
                smallSum+=array[leftIndex]*(end-rightIndex+1);
                newArray[newIndex++]=array[leftIndex++];
            }else {
                newArray[newIndex++]=array[rightIndex++];
            }
        }
        while (leftIndex<=mid){
            newArray[newIndex++]=array[leftIndex++];
        }
        while (rightIndex<=end){
            newArray[newIndex++]=array[rightIndex++];
        }
        while (start<=end){
            array[start]=newArray[start];
            start++;
        }
    }
}
