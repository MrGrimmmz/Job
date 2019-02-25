//package 数据结构与算法.算法.JD;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Scanner;
//
///**
// * 题目描述：
// * 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。对于这样的简单无向图，如果能将所有点划分成若干个集合，
// * 使得任意两个同一集合内的点之间没有边相连，任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的图是否为完全多部图。
// * 第一行输入一个整数T表示数据组数，1≤T≤10。
// *
// * 输入：
// *
// * 每组数据格式为：
// * 第一行包含两个整数N和M，1≤N≤1000，0≤M≤N(N-1)/2；
// * 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1≤X，Y≤N。
// *
// * 输出：
// *
// * 每组输出占一行，如果给定的图为完全多部图，输出Yes，否则输出No。
// *
// *
// * 样例输入：
// * 2
// * 5 7
// * 1 3
// * 1 5
// * 2 3
// * 2 5
// * 3 4
// * 4 5
// * 3 5
// * 4 3
// * 1 2
// * 2 3
// * 3 4
// * 样例输出：
// * Yes
// * No
// *
// * FileName: Solution1
// * Author:   ifcc
// * School:   Southeast University
// * Date:     2018/9/9 20:01
// * Description:
// */
//public class Solution1 {
//    public static void main(String[] args){
//        Scanner scanner=new Scanner(System.in);
//        int T=new Integer(scanner.nextLine().trim());
//        while(T>0){
//            String[] numberString = scanner.nextLine().trim().split(" ");
//            int N=new Integer(numberString[0]);
//            int M=new Integer(numberString[1]);
//            ArrayList<HashSet<Integer>> graph=new ArrayList<>();
//            for(int i=0;i<N;i++){
//                graph.add(new HashSet<Integer>());
//            }
//
//            for(int i=0;i<M;i++){
//                numberString = scanner.nextLine().trim().split(" ");
//                int a=new Integer(numberString[0]);
//                int b=new Integer(numberString[1]);
//                graph.get(a-1).add(b-1);
//                graph.get(b-1).add(a-1);
//            }
//            ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
//            int flag=0;
//            for(int i=0;i<N;i++){
//                for(int j=0;j<temp.size();j++){
//                    ArrayList<Integer> list=temp.get(j);
//                    flag=0;
//                    int node=list.get(0);
//                    if(graph.get(i).contains(node)){
//                        flag=1;
//                    }else {
//                        flag=-1;
//                    }
//                    for(int k=0;k<list.size();k++){
//                        if((flag==1&&!graph.get(i).contains(list.get(k)))||(flag==-1&&graph.get(i).contains(list.get(k)))){
//                            flag=-2;
//                            break;
//                        }
//                    }
//                    if(flag==-2){
//                        break;
//                    }
//                    if(flag==-1){
//                        if(solution(graph,temp,i,j)){
//                            list.add(i);
//                        }
//                        else {
//                            flag=-2;
//                        }
//                        break;
//                    }
//                }
//                if(flag==-2){
//                    break;
//                }
//                if(flag==0||flag==1){
//                    ArrayList<Integer> newList=new ArrayList<>();
//                    newList.add(i);
//                    temp.add(newList);
//                }
//            }
//            if(flag==-2){
//                System.out.println("No");
//            }
//            else {
//                System.out.println("Yes");
//            }
//            T--;
//        }
//    }
//    private static boolean solution(ArrayList<HashSet<Integer>> graph, ArrayList<ArrayList<Integer>> temp,int m,int n){
//        for(int i=0;i<temp.size();i++){
//            if(i==n){
//                continue;
//            }
//            ArrayList<Integer> list=temp.get(i);
//            for(int k=0;k<list.size();k++){
//                if(!graph.get(m).contains(list.get(k))){
//                    return false;
//                }
//            }
//        }
//        return true;
//
//    }
//}
