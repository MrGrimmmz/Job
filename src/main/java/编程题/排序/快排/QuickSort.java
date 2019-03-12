package 编程题.排序.快排;

/**
 * @author LIFAN
 * 2019/3/12 22:48
 */
public class QuickSort {
    public static void main(String[] args) {

    }

    /**
     * partition操作
     * @param array
     * @param left 数列左边界
     * @param right 数列右边界
     * @return
     */
    public static int partition(int[] array,int left,int right) {
        int begin = left;
        int end = right;
        int key = right;

        while( begin < end ) {
            //begin找大
            while(begin < end && array[begin] <= array[key])
                begin++;
            //end找小
            while(begin < end && array[end] >= array[key])
                end--;
            swap(array,begin,end);
        }
        swap(array,begin,right);
        return begin;   //返回基准位置
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void Quicksort(int array[], int left, int right){
        if(left < right){
            int pos = partition(array, left, right);
            Quicksort(array, left, pos - 1);
            Quicksort(array, pos + 1, right);
        }
    }

}
