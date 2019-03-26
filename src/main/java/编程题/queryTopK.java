package 编程题;
import java.util.HashMap;
import java.util.Map;
/**
 * @author LIFAN
 * 2019/3/25 14:28
 * 出现次数的top K问题
 */

public class queryTopK {
    //建立哈希节点
    public static class Node{
        public String str;
        public int times;
        public Node(String s,int t){
            str=s;
            times=t;
        }
    }

    public static void main(String[] args){
        String[] strArr={"a","b","c","a","a","c","c"};
        int k=2;
        printTopKAndRank(strArr,k);
    }

    public static void printTopKAndRank(String[] arr,int topK){
        if(arr==null|| topK<1){
            return;
        }
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        //生成哈希表（字符串词频）
        //注意词频表的处理
        for(int i=0;i!=arr.length;i++){
            String cur = arr[i];
            if(!map.containsKey(cur)){
                map.put(cur,1);
            }else{
                map.put(cur,map.get(cur)+1);
            }
        }

        //将节点存入小根堆中
        Node[] heap =new Node[topK];
        int index=0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String str=entry.getKey();
            int times=entry.getValue();
            Node node=new Node(str,times);
            if(index!=topK){
                heap[index]=node;
                heapInsert(heap,index++);
            }else{
                if(heap[0].times<node.times){
                    heap[0]=node;
                    heapAdjust(heap,0,topK);
                }
            }
        }

        //把小根堆的所有元素按词频从大到小排序
        for(int i=index-1;i!=0;i--){
            swap(heap,0,i);
            heapAdjust(heap,0,i);
        }

        //严格按照排名打印k条记录
        for(int i=0;i!=heap.length;i++){
            if(heap[i]==null){
                break;
            }else{
                System.out.print("No."+(i+1)+": ");
                System.out.print(heap[i].str+",times: ");
                System.out.println(heap[i].times);
            }

        }
    }

    public static void heapInsert(Node[] heap,int index){
        while(index!=0){
            int parent =(index-1)/2;
            if(heap[index].times<heap[parent].times){
                swap(heap,parent,index);
                index=parent;
            }else{
                break;
            }
        }
    }

    public static void heapAdjust(Node[] heap,int index,int heapSize){
        int left=index*2+1;
        int right=index*2+2;
        int smallest=index;
        while(left<heapSize){
            //如果有左子树，且左子树小于父节点，则将最小指针指向左子树
            if(heap[left].times<heap[index].times){
                smallest=left;
            }
            //如果有右子树，且右子树小于父节点，则将最小指针指向右子树
            if(right<heapSize && heap[right].times<heap[smallest].times){
                smallest=right;
            }
            //循环找
            //swap(heap,left,smallest);
            index=smallest;
            left=index*2+1;
            right=index*2+1;
        }
    }
    public static void swap(Node[] heap,int index1,int index2){
        Node tmp=heap[index1];
        heap[index1]=heap[index2];
        heap[index2]=tmp;

    }
}