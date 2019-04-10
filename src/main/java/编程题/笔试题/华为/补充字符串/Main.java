package 编程题.笔试题.华为.补充字符串;

/**
 * @author LIFAn
 * 2019/4/10 19:44
 */
import java.util.*;
public class Main{

    private static Scanner scanner=new  Scanner(System.in);
    public static void main(String[] args){
        int n = Integer.valueOf(scanner.next());
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < n ; i++) {
            arrayList.add(scanner.next().trim());
        }
        StringBuilder result = calculate(arrayList,n);

        scanner.close();
        System.out.println(result.toString());

    }

    public static StringBuilder calculate(ArrayList<String> arrayList,int n){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n ; i++) {
            String strTemp = arrayList.get(i);
            int size = strTemp.length();
            int curSize = size;
            int curIndex = 0;
            while (curSize >= 8){
                sb.append(strTemp.substring(curIndex,curIndex+8)+" ");
                curIndex = curIndex + 8;
                curSize = curSize - 8;
            }
            if(curSize > 0){
                sb.append(strTemp.substring(curIndex,size));
                for (int j = 0; j <8-curSize ; j++) {
                    sb.append("0");
                }
                sb.append(" ");
            }
        }

        String[]  sortArray=sb.toString().split(" ");
        Arrays.sort(sortArray,new Comparator<String>(){
            @Override
            public int compare(String str1,String str2){
                String c1 = str1 + str2;
                String c2 = str2 + str1;
                return c1.compareTo(c2);
            }
        });

        StringBuilder result=new StringBuilder();
        for (int i = 0; i <sortArray.length ; i++) {
            result.append(sortArray[i]+" ");
        }
        return result;
    }
}