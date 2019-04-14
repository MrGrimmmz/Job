package 编程题.排序.堆排序;

/**
 * @author LIFAN
 * 2019/3/25 15:56
 */
public class HeapSort {
    //声明全局变量，用于记录数组array的长度；
    static int len;
    /**
     * 堆排序算法
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len == 0) return array;
        //1.构建一个大根堆
        buildMaxHeap(array);
        //2.循环将堆顶（最大值）与堆尾交换，删除堆尾元素，然后重新调整大根堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--; //原先的堆尾进入有序区，删除堆尾元素
            adjustHeap(array, 0); //重新调整大根堆
        }
        return array;
    }

    /**
     * 自顶向下调整以 i 为根的堆为大根堆
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (2 * i + 1 < len && array[2 * i + 1] > array[maxIndex])
            maxIndex = 2 * i + 1;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (2 * i + 2 < len && array[2 * i + 2] > array[maxIndex])
            maxIndex = 2 * i + 2;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    /**
     * 自底向上构建初始大根堆
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始自底向上构造大根堆
        for (int i = (len-1 - 1) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    public static void swap(int[] heap,int index1,int index2){
        int tmp=heap[index1];
        heap[index1]=heap[index2];
        heap[index2]=tmp;

    }

    public static void main(String[] args){
        int[] arr={3,2,4,1,5};
        HeapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


}
