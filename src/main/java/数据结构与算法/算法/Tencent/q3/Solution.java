//package 数据结构与算法.算法.Tencent.q3;
//
//import java.util.*;
//
///**
// * FileName: Cake
// * Author:   ifcc
// * School:   Southeast University
// * Date:     2018/9/16 11:53
// * Description:
// */
//public class Cake {
//    public static void main(String[] args){
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int m=in.nextInt();
//        int[][] zheng=new int[n+1][n+1];
//        int [][]zhengresult=new int[n+1][n+1];
//        int [][]fanresult=new int [n+1][n+1];
//        for(int i=0;i<m;i++){
//            int a=in.nextInt();
//            int b=in.nextInt();
//            zheng[a][b]=1;
//        }
//        int count=0;
//        for(int i=1;i<=n;i++){
//            helper(zheng,i,zhengresult,fanresult);
//        }
//        for(int i=1;i<=n;i++){
//            int count1=0;
//            int count2=0;
//            for(int j=1;j<=n;j++){
//                if(zhengresult[i][j]==1)
//                {
//                    count1++;
//                }
//            }
//            for(int j=1;j<=n;j++){
//                if(fanresult[i][j]==1)
//                {
//                    count2++;
//                }
//            }
//            if(count2>count1)
//            {
//                count++;
//            }
//        }
//        System.out.println(count);
//
//    }
//    public static void helper(int[][] picture,int city,int[][] zhengresult,int [][]fanresult){
//        Queue<Integer> list=new LinkedList<>();
//        Set<Integer> set=new HashSet<>();
//        set.add(city);
//        list.add(city);
//        while(!list.isEmpty()){
//            int aa=list.poll();
//            zhengresult[city][aa]=1;
//            fanresult[aa][city]=1;
//            for(int i=1;i<picture.length;i++){
//                if(picture[aa][i]==1&&!set.contains(i)){
//                    set.add(i);
//                    list.add(i);
//                }
//            }
//        }
//    }
//
//}
