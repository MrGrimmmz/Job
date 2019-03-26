package 编程题.笔试题.科大讯飞.加密;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Solution {
    public static String jiami(char[] str,int[] p,int n,int m){

        int len = str.length;
        for(;len<n;len++){
            str[len]=' ';
        }
        char[] res;
        char[] temp = new char[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[p[j]-1] = str[j];
            }
            for(int k=0;k<n;k++){
                str[k] = temp[k];
            }
        }
        res = temp;
        String s = new String(res);
        return s;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] p = new int[n];

        for(int i=0;i<n;i++){
            p[i] = scan.nextInt();
        }

        int[] m = new int[200];

        String[] str = new String[200];
        int i = 0;
        int len = 0;
        while(scan.hasNext()){
            int temp = scan.nextInt();
            if(temp == 0){
                break;
            }
            m[i] = temp;
            str[i] = new String(scan.next());
            i++;
            len = i;
        }


        //System.out.println(jiami(str[0].toCharArray(),p,n,m[0]));
//        int[] p = new int[2];
//        for(int i=0;i<2;i++){
//            p[0] = 2;
//            p[1] = 1;
//        }
//        System.out.println(jiami("CD".toCharArray(),p,2,2));

        String[] res = new String[200];

        for(int j=0;j<len;j++){
            res[j] = jiami(str[j].toCharArray(),p,n,m[j]);
        }

        for(int k=0;k<len;k++) {
            System.out.println(res[k]);
        }
    }

}

