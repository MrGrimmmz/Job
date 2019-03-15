package 编程题.排序.快排;

/**
 * @author LIFAN
 * 2019/3/15 11:52
 * 找数组中超过一半数字的元素
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array){
        Quicksort(array,0,array.length-1);
        int count = 0;
        int mid = array.length/2;
        for(int i=0;i<array.length;i++){
            if(array[i]==array[mid]){
                count++;
            }
        }
        if(count>mid){
            return array[mid];
        }else{
            return 0;
        }
    }
    public  void Quicksort(int array[], int left, int right){
        if(left < right){
            int pos = partition(array, left, right);
            Quicksort(array, left, pos - 1);
            Quicksort(array, pos + 1, right);
        }
    }

    public int partition(int[] array,int begin,int end){
        int key = end;
        int left = begin;
        int right = end;
        while(left < right){
            while(left < right && array[left] <= array[key]){
                left++;
            }
            while(left < right && array[right] >= array[key]){
                right--;
            }
            swap(array,left,right);
        }
        swap(array,left,end);
        return left;
    }

    public void swap(int[] array,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
