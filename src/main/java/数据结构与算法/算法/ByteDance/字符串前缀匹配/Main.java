package 数据结构与算法.算法.ByteDance.字符串前缀匹配;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author ifcc
 * @Date 2018-05-12
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();

        while (scanner.hasNext()){
            String mn = scanner.nextLine();
            String[] mnarr = mn.split(" ");
            int m=Integer.parseInt(mnarr[0]);
            int n=Integer.parseInt(mnarr[1]);


            for (int i=0;i<m;i++){
                list.add(scanner.nextLine());
            }
            scanner.nextLine();
            String[] waitCheck=new String[n];
            for (int i=0;i<n;i++){
                waitCheck[i]=scanner.nextLine();
            }
            for (int i=0;i<n;i++){
                int res=solution(list,waitCheck[i]);
                System.out.println(res);

            }
            System.out.println();
            list.clear();
        }

    }

    public static int solution(ArrayList<String> list,String checkString){
        char[] chars = checkString.toCharArray();
        String s="";
        for (int i=0;i<chars.length;i++){
            s=s+chars[i];
            if (list.contains(s)){
                return 1;
            }
        }
        return -1;
    }
}
