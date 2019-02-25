package 数据结构与算法.算法.ByteDance.公司招聘取数;

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
        int N=Integer.parseInt(scanner.nextLine());

        while (N-->0){
            String inputString=scanner.nextLine();
            String[] inputArr = inputString.split(" ");
            int n=Integer.parseInt(inputArr[0]);
            int m=Integer.parseInt(inputArr[1]);
            int[] Ax=new int[m];
            for (int i=2;i<inputArr.length;i++){
                Ax[i-2]=Integer.parseInt(inputArr[i]);
            }
            int res = solution(Ax, n);
            System.out.println(res);
        }


    }

    public static int solution(int[] Ax,int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            list.add(i);
        }
        int AxIndex=0;
        int k=0;
        while (list.size()>1){
            k+=Ax[AxIndex];
            k=k%(list.size())-1;
            if (k<0){
                list.remove(list.size()-1);
                k=0;
            }else {
                list.remove(k);
            }
            AxIndex++;
            if (AxIndex== Ax.length){
                AxIndex=0;
            }
        }
        return list.get(0);
    }
}
